package com.xiaow.ssmdemo.filter;

import com.xiaow.ssmdemo.controller.BaseController;
import com.xiaow.ssmdemo.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserFilter implements Filter {
    @Autowired
    BaseController baseController;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        UserBean userinfo = (UserBean) req.getSession().getAttribute("userinfo");
        if (userinfo == null) {
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<script>");
            out.println("alert('尚未登陆，请先登录')");
            out.println("window.open ('/signin.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
            out.flush();;
            out.close();

        }
        else if(!userinfo.getLevel1().equals("admin")){
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<script>");
            out.println("alert('你没有此权限')");
            out.println("window.open ('/main.html','_top')");
            out.println("</script>");
            out.println("</html>");
            out.flush();;
            out.close();
        }
        else{
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
