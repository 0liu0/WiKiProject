package com.liuche.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuche.wiki.domain.Category;
import com.liuche.wiki.mapper.CategoryMapper;
import com.liuche.wiki.req.CategoryQueryReq;
import com.liuche.wiki.req.CategorySaveReq;
import com.liuche.wiki.resp.CategoryQueryResp;
import com.liuche.wiki.resp.PageResp;
import com.liuche.wiki.service.CategoryService;
import com.liuche.wiki.utils.CopyUtil;
import com.liuche.wiki.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private SnowFlake snowFlake;
    @Override
    public Category queryById(Long id) {
        return categoryMapper.queryById(id);
    }


    @Override
    public PageResp<CategoryQueryResp> selectAll(CategoryQueryReq req) {
        List<Category> categorys; // 返回的数据
        String name = req.getName();
        if (!ObjectUtils.isEmpty(name)){
            name = "%" + name + "%";
            req.setName(name);
            PageHelper.startPage(req.getPage(), req.getSize()); // TODO 如果都没有的话就是不做分页
            categorys = categoryMapper.selectAll(req);
        }else {
            PageHelper.startPage(req.getPage(), req.getSize());
            categorys = categoryMapper.selectAll1();
        }
        PageInfo<Category> p = new PageInfo<>(categorys); // 得到mysql中这些数据的信息
        List<CategoryQueryResp> categoryQueryResp = CopyUtil.copyList(categorys, CategoryQueryResp.class); // 转化
        PageResp<CategoryQueryResp> pageResp = new PageResp<>(); // 定义返回的信息
        pageResp.setList(categoryQueryResp); // 将categorys装入pageResp中
        pageResp.setTotal(p.getTotal()); // 将数据库总量装入返回值中
        return pageResp;
    }

    @Override
    public boolean saveCategory(CategorySaveReq req) {
        try {
            Category category = CopyUtil.copy(req, Category.class);
            if (!ObjectUtils.isEmpty(category.getId())){
                categoryMapper.saveCategory(category);
            }else { // 执行新增的逻辑
                category.setId(snowFlake.nextId());
                categoryMapper.saveCategory2(category);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteCategory(Long id) {
        try {
            categoryMapper.deleteCategory(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
