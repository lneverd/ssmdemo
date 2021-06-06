package com.xiaow.ssmdemo.controller;

import com.xiaow.ssmdemo.model.UserBean;
import com.xiaow.ssmdemo.service.UserService;
import com.xiaow.ssmdemo.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends EXCElController{
    @Autowired
    UserService userService;

    @RequestMapping("/login")
//    @ResponseBody
    public String getOneByName(String name, String password, HttpServletRequest request) {
        if (name == null || "".equals(name.trim())) {
            request.getSession().setAttribute("msg", "账户名为空");
            return "redirect:/signin.jsp";
        }
        if (password == null || "".equals(password.trim())) {
            request.getSession().setAttribute("msg", "密码为空");
            return "redirect:/signin.jsp";
        }
        UserBean oneByName = userService.getOneByName(name);
        if (oneByName != null) {
            if (oneByName.getPassword().equals(password)) {
                request.getSession().setAttribute("userinfo", userService.getOneByName(name));
                return "redirect:/main.html";
            }
        }
        request.getSession().setAttribute("msg", "账户或密码错误");
        return "redirect:/signin.jsp";
    }

    //    动态条件获取用户
    @RequestMapping("/getOneDramic")
    @ResponseBody
    public Result getOneDramic(UserBean userBean) {
        System.out.println(userBean);
        List dramic = userService.getDramic(userBean);
        if (dramic != null && dramic.size() > 0) {
            return Result.succ(dramic);
        }
        return Result.fail("无此用户");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Integer id, HttpServletRequest request) {
        System.out.println(id);
        request.setAttribute("user", id == null ? null : userService.getDramic(new UserBean().setId(id)).get(0));
        return "/view/hpl/user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(UserBean userBean, HttpServletRequest request,HttpServletResponse response) {
        try {
            if (userBean.getId() != null) {
                userService.update(userBean);
            } else {
                userService.add(userBean);
            }
        }
        catch (Exception e){
            jsAlert("用户名重复","/user/list",response);
            e.printStackTrace();
        }
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id, HttpServletRequest request,HttpServletResponse response) {
        UserBean userBean = (UserBean) userService.getDramic(new UserBean().setId(id)).get(0);
        if(userBean.getLevel1().equals("admin")) {
          jsAlert("超级管理员不可删除","/user/list",response);
        }
        else {
            userService.delete(id);
        }
        return "redirect:/user/list";
    }
    @RequestMapping(value = "/delete2")
    public String delete2(Integer id, HttpServletRequest request,HttpServletResponse response) {
        System.out.println(id);
        UserBean userBean = (UserBean) userService.getDramic(new UserBean().setId(id)).get(0);
        System.out.println(userBean);
        if(userBean.getLevel1().equals("admin")) {
            jsAlert("超级管理员不可删除","/user/list",response);
        }
        else {
            userService.delete(id);
            request.getSession().invalidate();
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.println("<html>");
            out.println("<script>");
            out.println("window.open ('/signin.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
            out.flush();;
            out.close();
        }
        return "/view/hpl/user/list2";
    }
    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request) {
        List dramic = userService.getDramic(null);
        request.setAttribute("userlist",dramic);
        UserBean userinfo = (UserBean) request.getSession().getAttribute("userinfo");
        System.out.println(userinfo);
        if(userinfo.getLevel1().equals("admin")){
            return "/view/hpl/user/list";
        }
        return "/view/hpl/user/list2";
    }
    @RequestMapping("/excelExport")
    public void out(HttpServletResponse response){
        List dramic = userService.getDramic(null);
        downExportExcel("/user.xls",dramic,"医生列表.xls",response);

    }

    @RequestMapping("/showqrcode")
    public String showqrcode(@RequestParam(value = "username",required = false) String username, ModelMap modelMap){
        modelMap.put("username",username);
        System.out.println(username);
        return "view/hpl/user/showqrcode";
    }

    @RequestMapping("/detail")
    public String userdetail(@RequestParam(value = "username",required = false) String username, ModelMap modelMap){
        UserBean userBean= userService.getOneByName(username);
        System.out.println(username);
        modelMap.put("username",userBean.getUsername());
        modelMap.put("userid",userBean.getId());
        modelMap.put("userlevel1",userBean.getLevel1());
        modelMap.put("introduce",userBean.getIntroduce());
        modelMap.put("realname",userBean.getRealname());
        return "view/hpl/user/detail";
    }
}

