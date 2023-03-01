package com.liuche.wiki.mapper;

import com.liuche.wiki.domain.Ebook;

import java.util.List;

/**
 * 电子书(Ebook)表数据库访问层
 *
 * @author LiuChe
 * @since 2023-03-01 17:39:57
 */
public interface EbookMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Ebook queryById(Long id);

    List<Ebook> selectAll();

}

