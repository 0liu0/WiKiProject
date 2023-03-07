package com.liuche.wiki.controller;

import com.liuche.wiki.req.CategoryQueryReq;
import com.liuche.wiki.req.CategorySaveReq;
import com.liuche.wiki.resp.CommonResp;
import com.liuche.wiki.resp.CategoryQueryResp;
import com.liuche.wiki.resp.PageResp;
import com.liuche.wiki.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public CommonResp list(@Valid CategoryQueryReq req){
        CommonResp<PageResp<CategoryQueryResp>> resp = new CommonResp<>();
        PageResp<CategoryQueryResp> categoryList = categoryService.selectAll(req); // 得到所有的category

        resp.setContent(categoryList);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody CategorySaveReq req){ // @RequestBody从前端接收JSON对象时要使用这个注解
        CommonResp<Object> resp = new CommonResp<>();
        boolean b = categoryService.saveCategory(req);
        resp.setSuccess(b);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){ // @RequestBody从前端接收JSON对象时要使用这个注解
        CommonResp<Object> resp = new CommonResp<>();
        boolean b = categoryService.deleteCategory(id);
        resp.setSuccess(b);
        return resp;
    }
}
