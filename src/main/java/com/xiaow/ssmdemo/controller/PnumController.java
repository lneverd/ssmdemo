package com.xiaow.ssmdemo.controller;

import com.xiaow.ssmdemo.model.*;
import com.xiaow.ssmdemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pnum")
public class PnumController extends EXCElController{

    @Autowired
    PnumService pnumService;

    @Autowired
    PatientService patientService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MedicineService medicineService;

    @Autowired
    NmService nmService;

    @RequestMapping(value = "/out",method = RequestMethod.GET)
    public void FixOut(int id,HttpServletResponse response) {
        PatientBean patientBean = new PatientBean();
        patientBean.setId(id);
        List<PatientBean> history = patientService.getHistory(patientBean);
        StringBuilder name=new StringBuilder();
        name.append(history.get(0).getName());
        name.append("的历史病例.xls");
        downExportExcel("/helloworld.xls",history,name.toString(),response);
//        downExportExcel("C:\\Users\\Lenovo\\Desktop\\ssmdemo\\ssmdemo\\src\\main\\java\\com\\xiaow\\ssmdemo\\conf\\helloworld.xls",history,"你好世界.xls",response);
    }

    @RequestMapping(value = "/makedrug",method = RequestMethod.GET)
    public String makedrug(int nid,HttpServletRequest request) {
        List<CategoryBean> cateall = categoryService.findALL();
        request.setAttribute("type",cateall);
        request.setAttribute("nid",nid);
        return "/view/hpl/pnum/add";
    }

    @RequestMapping(value = "/makedrugMe",method = RequestMethod.GET)
    public String makedrugMe(int id,int nid,HttpServletRequest request,HttpServletResponse response) {
        List<CategoryBean> catelist = categoryService.findALL();
        List<MedicineBean> Mealist = medicineService.findByCid(id);
        request.setAttribute("type",catelist);
        request.setAttribute("medicine",Mealist);
        request.setAttribute("selected",id);

        request.setAttribute("nid",nid);
        return "/view/hpl/pnum/add";
    }

    @RequestMapping(value = "/drugSave",method = RequestMethod.GET)
    public String drugSave(Integer nid,Integer mid,Integer num,HttpServletRequest request) {
        System.out.println(nid+" "+mid+" "+num);
        NmBean nmBean=new NmBean(nid,mid,num);
        nmService.insert(nmBean);
        request.setAttribute("nid",nid);
        List<CategoryBean> catelist = categoryService.findALL();
        request.setAttribute("type",catelist);
        return "/view/hpl/pnum/add";
    }

    @RequestMapping(value = "/drugresult",method = RequestMethod.GET)
    public String drugresult(int nid,HttpServletRequest request,HttpServletResponse response) {
        List<NmBean> all = nmService.findByNid(nid);
        double allmoney=0;
        double money=0;
        for (NmBean one:all) {
            money=one.getPrice()*one.getCounts();
            one.setMoney(money);
            allmoney+=money;
        }
        request.setAttribute("list",all);
        request.setAttribute("allmoney",allmoney);
        return "/view/hpl/pnum/list";
    }
}
