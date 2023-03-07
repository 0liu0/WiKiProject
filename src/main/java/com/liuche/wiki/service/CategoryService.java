package com.liuche.wiki.service;

import com.liuche.wiki.domain.Category;
import com.liuche.wiki.req.CategoryQueryReq;
import com.liuche.wiki.req.CategorySaveReq;
import com.liuche.wiki.resp.CategoryQueryResp;
import com.liuche.wiki.resp.PageResp;

public interface CategoryService {
    Category queryById(Long id);

    PageResp<CategoryQueryResp> selectAll(CategoryQueryReq req);
    boolean saveCategory(CategorySaveReq req);
    boolean deleteCategory(Long id);
}
