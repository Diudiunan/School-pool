package com.q.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LoginUserFilter implements Filter{
	
	public void destroy() {
		
	}
	
	public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		
		HttpSession session = req.getSession();
		String id = req.getParameter("ID");
		String pwd = req.getParameter("PASSWORD");
		String code = req.getParameter("vcode");
		String syscode = (String)session.getAttribute("code");
		PrintWriter out = res.getWriter();
		String RSTR = "请检查";
		if(!code.equals(syscode)||id==""||pwd=="") {
			out.write("<script>");
			if(!code.equals(syscode)) {
				RSTR += " 验证码 ";
			}
			if(id==""){
				RSTR += " 账号 ";
			}
			if(pwd=="") {
				RSTR += " 密码 ";
			}
			out.write(String.format("alert('%s');",RSTR));
			out.write("location.href='/MyShoppingSystem/web/login_user.html';");
			out.write("</script>");
			return;
		}else {
			chain.doFilter(req, res);
		}
	}
	
	public void init(FilterConfig config) throws ServletException {
		
    }
}