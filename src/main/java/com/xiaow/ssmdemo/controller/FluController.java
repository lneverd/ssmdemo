package com.xiaow.ssmdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xiaow.ssmdemo.utils.HttpConn;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/flu")
public class FluController {

	@RequestMapping("/list")
	public String list(HttpServletRequest req) {
		String data;
		List<String> relList = new ArrayList<String>();
		try {
			data=HttpConn.get("http://m.sinovision.net/newpneumonia.php");

			Document document = Jsoup.parse(data);
			Elements elements = document.getElementsByClass("number-tag");
			
			for (Element e : elements) {
				//System.out.println(e.html());//��ȡdiv���������
				relList.add(e.html());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("mgqz", relList.get(0));
		req.setAttribute("mgsw", relList.get(1));
		req.setAttribute("mgzy", relList.get(2));
		req.setAttribute("xq", relList.get(3));
		req.setAttribute("xy", relList.get(4));
		req.setAttribute("xz", relList.get(5));
		req.setAttribute("lq", relList.get(6));
		req.setAttribute("lz", relList.get(7));
		req.setAttribute("ls", relList.get(8));
		return "view/Hospital/flu/list";
	}
	
	@RequestMapping("/world")
	public String world(HttpServletRequest req) {
		String data;
		List<String> relList = new ArrayList<String>();
		List<String> qzList = new ArrayList<String>();
		List<String> swList = new ArrayList<String>();
		List<String> zyList = new ArrayList<String>();
		try {
			data= HttpConn.get("http://m.sinovision.net/newpneumonia.php");

			Document document = Jsoup.parse(data);
			
			Elements els = document.getElementsByClass("main-block");
			Elements els1 = new Elements();
			Elements els2 = new Elements();
			for(Element e:els) {
				els2.add(e.getElementsByClass("prod").first());
			}
			
			
			for(Element e:els2) { 
				String area = null;
				String confirm = null;
				String dead = null;
				String cured_notag = e.getElementsByClass("cured-notag").html();
				if(!cured_notag.isEmpty()) {
				area = "'"+e.getElementsByClass("area").html()+"'";
				relList.add(area);
			 
				confirm = e.getElementsByClass("confirm").html(); 
				qzList.add(confirm);
			 
				dead = e.getElementsByClass("dead").html(); 
				swList.add(dead);
			  
				zyList.add(cured_notag);
				//System.out.println(area+','+confirm+','+dead+','+cured_notag);
				}
			}
			 
			req.setAttribute("area", relList);
			req.setAttribute("qz", qzList);
			req.setAttribute("sw", swList);
			req.setAttribute("zy", zyList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return "view/Hospital/flu/world";
	}
	
	@RequestMapping("/us")
	public String us(HttpServletRequest req) {
		String data;
		List<String> relList = new ArrayList<String>();
		List<String> qzList = new ArrayList<String>();
		List<String> swList = new ArrayList<String>();
		try {
			data=HttpConn.get("http://m.sinovision.net/newpneumonia.php");

			Document document = Jsoup.parse(data);
			
			Elements els = document.getElementsByClass("main-block");
			Elements els1 = new Elements();
			Elements els2 = new Elements();
			
			for(Element e:els) {
				els2.addAll(e.getElementsByClass("prod-city-block"));
				els1.addAll(e.getElementsByClass("prod tags"));
			}
			
			for(Element e : els1) {
				String area = "'"+e.getElementsByClass("area").html()+"'";
				String qz = e.getElementsByClass("confirm").html();
				String sw = e.getElementsByClass("dead").html();
				sw=sw.replace("&nbsp;", "0");
				relList.add(area);
				qzList.add(qz);
				swList.add(sw);
				System.out.println(area+','+qz+','+sw);
			}
			
			for(Element e : els2) {
				String area = "'"+e.getElementsByClass("city-area").html()+"'";
				String qz = e.getElementsByClass("confirm").html();
				String sw = e.getElementsByClass("dead").html();
				
				sw=sw.replace("&nbsp;", "0");
				relList.add(area);
				qzList.add(qz);
				swList.add(sw);
				System.out.println(area+','+qz+','+sw);
			}
	
			 
			req.setAttribute("area", relList);
			req.setAttribute("qz", qzList);
			req.setAttribute("sw", swList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return "view/hpl/flu/us";
	}
}
