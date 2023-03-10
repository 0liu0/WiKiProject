
package com.liuche.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuche.wiki.domain.Content;
import com.liuche.wiki.domain.Doc;
import com.liuche.wiki.mapper.ContentMapper;
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
    private ContentMapper contentMapper;
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
            Content content = CopyUtil.copy(req, Content.class);
            if (!ObjectUtils.isEmpty(doc.getId())) {
                if (!ObjectUtils.isEmpty(content.getContent())) { // 如果内容部分有内容我再保存，没有不保存
                    int flag = contentMapper.updateContent(content);
                    if (flag == 0) {
                        contentMapper.insertContent(content);
                    }
                }
                docMapper.saveDoc(doc);
            } else { // 执行新增的逻辑
                doc.setId(snowFlake.nextId());
                if (!ObjectUtils.isEmpty(content.getContent())) {// 如果内容部分有内容我再保存，没有不保存
                    content.setId(doc.getId());
                    contentMapper.insertContent(content);
                }
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
            int flag = contentMapper.deleteContent(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String selectOne(Long id) {
        Content content = contentMapper.selectOne(id);
        return content.getContent();
    }

    @Override
    public PageResp<DocQueryResp> getOne(Long id) {
        List<Doc> docs; // 返回的数据
        docs = docMapper.getOne(id);
        PageInfo<Doc> p = new PageInfo<>(docs); // 得到查询出来的信息的对象
        List<DocQueryResp> docQueryResp = CopyUtil.copyList(docs, DocQueryResp.class); // 转化
        PageResp<DocQueryResp> pageResp = new PageResp<>(); // 定义返回的信息
        pageResp.setList(docQueryResp); // 将docs装入pageResp中
        pageResp.setTotal(p.getTotal()); // 将数据库总量装入返回值中
        return pageResp;
    }

    @Override
    public int vote(Long id) {
        return docMapper.vote(id);
    }

}
