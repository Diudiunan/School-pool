package com.q.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.q.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterUserAdd extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PASSWORD2");
		
		
		
		//加入数据信息到数据库
		if(UserDao.registeruser_insert(id, pwd) > 0) {
			
			response.sendRedirect("/MyShoppingSystem/web/login_user.html");
			
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alent('用户添加失败！')");
			out.write("location.href='/MyShoppingSystem/web/sign_user.html'");
			out.write("<script>");
		}
		//System.out.print("注册响应");
	}
}
