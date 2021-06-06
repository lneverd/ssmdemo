package com.xiaow.ssmdemo.controller;

import com.xiaow.ssmdemo.model.*;
import com.xiaow.ssmdemo.model.PatientBean;
import com.xiaow.ssmdemo.service.*;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/patient")
public class PatientController extends EXCElController{

    @Autowired
    PatientService patientService;

    @Autowired
    PnumService pnumService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/backadd",method = RequestMethod.GET)
    public String backadd(HttpServletRequest request) {
        List list = userService.getDramic(new UserBean());
        request.setAttribute("type",list);
        return "/view/hpl/patient/add";
    }

    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    public String getPatientList(HttpServletRequest request) {
        List<PatientBean> all = patientService.findALL(null);
        request.setAttribute("list",all);
        return "/view/hpl/patient/list";
    }

    @RequestMapping(value = "/getone",method = RequestMethod.GET)
    public String getPatientOne(String name,HttpServletRequest request) {
        PatientBean one = patientService.findByName(name);
        List<PatientBean> all = new ArrayList<PatientBean>();
        all.add(one);
        request.setAttribute("list",all);
        return "/view/hpl/patient/list";
    }
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addpatient(PatientBean bean,HttpServletRequest request,HttpServletResponse response) {
        bean.setOutt("入院");
        PatientBean byIdCard = patientService.findByIdCard(bean.getIdcard());
        System.out.println(byIdCard);
        if (byIdCard!=null&&byIdCard.getOutt().equals("入院")){
            return jsAlert("该病人已经入院！","/patient/backadd",response);
        }
        try {
            patientService.insert(bean);
            CreatePnum(bean);
            return jsAlert("病人信息已录入！","/patient/backadd",response);
        }catch (Exception e){
            patientService.updateByIdCard(bean);
            bean.setId(byIdCard.getId());
            System.out.println(bean);
            CreatePnum(bean);
            return jsAlert("病人已经入院！","/patient/backadd",response);
        }
    }

    private void CreatePnum(PatientBean bean){
        PnumBean pnumBean = new PnumBean();
        pnumBean.setPid(bean.getId());
        pnumBean.setUid(bean.getUid());
        pnumBean.setAge(bean.getAge());
        pnumBean.setMoney(bean.getMoney());
        pnumBean.setIdentification("目前");
        System.out.println(pnumBean);
        pnumService.insert(pnumBean);
    }
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editpatient(int id,HttpServletRequest request) {
        PatientBean bean = patientService.findById(id);
        request.setAttribute("bean",bean);
        return "/view/hpl/patient/update";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updatepatient(PatientBean bean,HttpServletRequest request) {
        patientService.update(bean);
        List<PatientBean> all = new ArrayList<PatientBean>();
        all.add(patientService.findById(bean.getId()));
        request.setAttribute("list",all);
        return "/view/hpl/patient/list";
    }

    @RequestMapping(value = "/out",method = RequestMethod.GET)
    public String FixOut(PatientBean bean,HttpServletRequest request,HttpServletResponse response) {
        PatientBean patient = patientService.findById(bean.getId());
        if (patient.getOutt().equals("出院")){
            jsAlert("已经出院！","/patient/getlist",response);
        }
        bean.setOutt("出院");
        patientService.update(bean);
        //修改最新的病例状态
        PnumBean nowPnum = pnumService.findByPid(patient.getId());
        nowPnum.setIdentification("以前");
        System.out.println(nowPnum);
        pnumService.update(nowPnum);
        List<PatientBean> all = new ArrayList<PatientBean>();
        all.add(patientService.findById(bean.getId()));
        request.setAttribute("list",all);
        return "/view/hpl/patient/list";
    }

    @RequestMapping(value = "/history",method = RequestMethod.GET)
    public String history(PatientBean bean,HttpServletRequest request) {
        List<PatientBean> history = patientService.getHistory(bean);
        request.setAttribute("list",history);
        return "/view/hpl/patient/pnumList";
    }


}
