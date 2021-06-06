package com.xiaow.ssmdemo.controller;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseController {
	
	public void respJson(String json, HttpServletResponse resp) {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = null;
		try {
			pw = resp.getWriter();
			pw.print(json);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pw != null) {
					pw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// alert
	public String jsAlert(String msg, String url, HttpServletResponse resp) {
		respJson("<script>alert('" + msg + "');window.location.href='" + url + "'</script>", resp);
		return null;
	}
	
	// 打印JSON
	public String outRespJson(Object obj, HttpServletResponse resp) {
		String json = obj instanceof String ? (String) obj : new Gson().toJson(obj);
		respJson(json, resp);
		return null;
	}
	
	public String getUploadPath(HttpServletRequest req) {
		return req.getRealPath("/upload2") + "/";
	}

}
