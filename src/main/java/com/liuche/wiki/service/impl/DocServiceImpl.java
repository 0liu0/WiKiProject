
package com.liuche.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuche.wiki.domain.Doc;
import com.liuche.wiki.mapper.DocMapper;
import com.liuche.wiki.req.DocQueryReq;
import com.liuche.wiki.req.DocSaveReq;
import com.liuche.wiki.resp.DocQueryResp;
import com.liuche.wiki.resp.PageResp;
import com.liuche.wiki.service.DocService;
import com.liuche.wiki.utils.CopyUtil;
import com.liuche.wiki.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class DocServiceImpl implements DocService {
    @Autowired
    private DocMapper docMapper;
    @Autowired
    private SnowFlake snowFlake;

    @Override
    public Doc queryById(Long id) {
        return docMapper.queryById(id);
    }


    @Override
    public PageResp<DocQueryResp> selectAll(DocQueryReq req) {
        List<Doc> docs; // 返回的数据
        PageHelper.startPage(req.getPage(), req.getSize());
        docs = docMapper.selectAll1();
        PageInfo<Doc> p = new PageInfo<>(docs); // 得到mysql中这些数据的信息
        List<DocQueryResp> docQueryResp = CopyUtil.copyList(docs, DocQueryResp.class); // 转化
        PageResp<DocQueryResp> pageResp = new PageResp<>(); // 定义返回的信息
        pageResp.setList(docQueryResp); // 将docs装入pageResp中
        pageResp.setTotal(p.getTotal()); // 将数据库总量装入返回值中
        return pageResp;
    }

    @Override
    public boolean saveDoc(DocSaveReq req) {
        try {
            Doc doc = CopyUtil.copy(req, Doc.class);
            if (!ObjectUtils.isEmpty(doc.getId())) {
                docMapper.saveDoc(doc);
            } else { // 执行新增的逻辑
                doc.setId(snowFlake.nextId());
                docMapper.saveDoc2(doc);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteDoc(Long id) {
        try {
            docMapper.deleteDoc(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
