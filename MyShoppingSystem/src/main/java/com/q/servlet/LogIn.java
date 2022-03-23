package com.q.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.q.dao.UserDao;
import com.q.entity.Shopping_User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogIn extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PASSWORD");
		int count = UserDao.userlogin(id, pwd);
		if(count>0) {
			HttpSession session = request.getSession();
			Shopping_User user = UserDao.login_getuser(id, pwd);
			session.setAttribute("USER", user);
			session.setAttribute("IsLogIn", "T");
			response.sendRedirect("/MyShoppingSystem/web/center_home.html");
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alent('登录失败！')");
			out.write("location.href='/MyShoppingSystem/web/login_user.html'");
			out.write("<script>");
		}
	}
}
