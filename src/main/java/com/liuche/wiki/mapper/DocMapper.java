package com.liuche.wiki.mapper;

import com.liuche.wiki.domain.Doc;
import com.liuche.wiki.req.DocQueryReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文档(Doc)表数据库访问层
 *
 * @author LiuChe
 * @since 2023-03-08 15:13:31
 */
public interface DocMapper {
    Doc queryById(Long id);
    List<Doc> selectAll(DocQueryReq req);
    List<Doc> selectAll1();
    void saveDoc(Doc req);
    void deleteDoc(@Param("id") Long id);
    void saveDoc2(Doc req);
    List<Doc> getOne(@Param("id") Long id); // 得到某一本电子书的所有文档
}

