package com.xiaow.ssmdemo.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xiaow.ssmdemo.model.CategoryBean;
import com.xiaow.ssmdemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController{

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/backadd",method = RequestMethod.GET)
    public String backadd() {
        return "/view/hpl/category/add";
    }

    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    public String getCateList(HttpServletRequest request) {
        List<CategoryBean> all = categoryService.findALL();
        request.setAttribute("list",all);
        return "/view/hpl/category/list";
    }

    @RequestMapping(value = "/getone",method = RequestMethod.GET)
    public String getCateOne(String category,HttpServletRequest request) {
        CategoryBean one = categoryService.findByName(category);
        List<CategoryBean> all = new ArrayList<CategoryBean>();
        all.add(one);
        request.setAttribute("list",all);
        return "/view/hpl/category/list";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete( int id,HttpServletRequest request) {
        try {
            categoryService.delete(id);
            List<CategoryBean> all = categoryService.findALL();
            request.setAttribute("list",all);
            request.setAttribute("msg","删除成功!");
        }catch (Exception p){
            p.printStackTrace();
            request.setAttribute("msg","删除失败!");
        }
        return "/view/hpl/category/list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addCategory(String category, HttpServletResponse resp) {
        if (StringUtils.isEmpty(category.trim())){
            return jsAlert("输入不可为空","/category/backadd",resp);
        }
        CategoryBean bean=new CategoryBean();
        bean.setCategory(category);
        categoryService.insert(bean);
        return "/view/hpl/category/add";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editCategory( int id,HttpServletRequest request) {
        CategoryBean bean = categoryService.findById(id);
        request.setAttribute("bean",bean);
        return "/view/hpl/category/update";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateCategory( Integer id,String category,HttpServletRequest request) {
        CategoryBean bean = new CategoryBean(id, category);
        categoryService.update(bean);
        List<CategoryBean> all = new ArrayList<CategoryBean>();
        all.add(bean);
        request.setAttribute("list",all);
        return "/view/hpl/category/list";
    }
}
