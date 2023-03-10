package com.liuche.wiki.mapper;

import com.liuche.wiki.domain.Content;
import org.apache.ibatis.annotations.Param;

/**
 * 文档内容(Content)表数据库访问层
 *
 * @author LiuChe
 * @since 2023-03-09 19:21:36
 */
public interface ContentMapper {
    int updateContent(Content content);

    int insertContent(Content content);

    Content selectOne(@Param("id") Long id);
    int deleteContent(@Param("id") Long id);
}

