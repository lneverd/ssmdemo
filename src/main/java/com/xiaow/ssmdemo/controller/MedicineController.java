package com.xiaow.ssmdemo.controller;

import com.xiaow.ssmdemo.model.CategoryBean;
import com.xiaow.ssmdemo.model.MedicineBean;
import com.xiaow.ssmdemo.service.CategoryService;
import com.xiaow.ssmdemo.service.MedicineService;
import com.xiaow.ssmdemo.utils.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/medicine")
public class MedicineController extends BaseController{

    @Autowired
    MedicineService medicineService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/backadd",method = RequestMethod.GET)
    public String backadd(HttpServletRequest request) {
        List<CategoryBean> all = categoryService.findALL();
        request.setAttribute("type",all);
        return "/view/hpl/medicine/add";
    }

    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    public String getMediList(Integer cid,HttpServletRequest request) {
        List<MedicineBean> all = medicineService.findALL(cid);
        request.setAttribute("list",all);
        return "/view/hpl/medicine/list";
    }

    @RequestMapping(value = "/getone",method = RequestMethod.GET)
    public String getCateOne(String medicine,HttpServletRequest request) {
        System.out.println(medicine);
        MedicineBean one = medicineService.findByName(medicine);
        System.out.println(one);
        List<MedicineBean> all = new ArrayList<MedicineBean>();
        all.add(one);
        request.setAttribute("list",all);
        return "/view/hpl/medicine/list";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete( int id,HttpServletRequest request) {
        try {
            medicineService.delete(id);
            List<MedicineBean> all = medicineService.findALL(null);
            request.setAttribute("list",all);
            request.setAttribute("msg","删除成功!");
        }catch (Exception p){
            p.printStackTrace();
            request.setAttribute("msg","删除失败!");
        }
        return "/view/hpl/medicine/list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addmedicine(String medicine,double price,int num,String logo,int cid ,HttpServletResponse resp,HttpServletRequest request) {
        MedicineBean bean=new MedicineBean();
        bean.setMedicine(medicine);
        bean.setPrice(price);
        bean.setNum(Math.abs(num));
        bean.setCid(cid);
        bean.setLogo(logo);
        if (NotNullUtil.isBlank(bean)){
            return jsAlert("请完善信息","/medicine/backadd",resp);
        }
        medicineService.insert(bean);
        return "redirect:/medicine/backadd";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editmedicine( int id,HttpServletRequest request) {
        MedicineBean bean = medicineService.findById(id);
        List<CategoryBean> all = categoryService.findALL();
        request.setAttribute("type",all);
        request.setAttribute("bean",bean);
        return "/view/hpl/medicine/update";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updatemedicine(MedicineBean bean,HttpServletRequest request) {
        medicineService.update(bean);
        List<MedicineBean> all = new ArrayList<MedicineBean>();
        all.add(bean);
        request.setAttribute("list",all);
        return "/view/hpl/medicine/list";
    }

    @RequestMapping(value = "/logo")
    public void logo(MultipartFile file,HttpServletResponse response,HttpServletRequest request){
        String filename=file.getOriginalFilename();
        System.out.println(getUploadPath(request)+"/"+filename);
        try {
            file.transferTo(new File(getUploadPath(request)+"/"+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //输出到图片路径到函数中
        outRespJson("/file/"+filename,response);
    }

    @RequestMapping(value = "/detail")
    public String detail(int id,HttpServletRequest request){
        request.setAttribute("bean",medicineService.findById(id));
        return "/view/hpl/medicine/list";
    }
}
