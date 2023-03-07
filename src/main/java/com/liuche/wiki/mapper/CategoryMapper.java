package com.liuche.wiki.mapper;

import com.liuche.wiki.domain.Category;
import com.liuche.wiki.req.CategoryQueryReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 分类(Category)表数据库访问层
 *
 * @author LiuChe
 * @since 2023-03-06 20:27:39
 */
public interface CategoryMapper {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Category queryById(Long id);

    List<Category> selectAll(CategoryQueryReq req);
    List<Category> selectAll1();
    void saveCategory(Category req);
    void deleteCategory(@Param("id") Long id);
    void saveCategory2(Category req);

}

