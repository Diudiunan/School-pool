package com.q.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.q.dao.UserDao;
import com.q.entity.Shopping_User;

/**
 * Servlet implementation class DoUserAdd
 */

public class DoUserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

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
		String name = request.getParameter("Name");
		String pwd = request.getParameter("PassWord");
		String sex = request.getParameter("Sex");
		String year = request.getParameter("Birthday");
		String email = request.getParameter("Email");
		String phone = request.getParameter("Phone");
		String address = request.getParameter("Address");
		
		//创建用户实体
		Shopping_User user = new Shopping_User(id, name, pwd, sex, year, null, email, phone, address, 1);
		//加入数据信息到数据库
		if(UserDao.user_insert(user) > 0) {
			response.sendRedirect("/MyShoppingSystem/ser/admin_douserlist");
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alent('用户添加失败！')");
			out.write("location.href='jsp/admin_useradd.jsp'");
			out.write("<script>");
		}
	}

}
