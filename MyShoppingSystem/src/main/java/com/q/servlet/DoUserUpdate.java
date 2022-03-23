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
 * Servlet implementation class DoUserUpdate
 */
public class DoUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userid = request.getParameter("id");
		String nowpage = request.getParameter("nowpage");
		//
		Shopping_User user = UserDao.searchbyid(userid);
		request.setAttribute("user", user);
		request.setAttribute("nowpage", nowpage);
		request.getRequestDispatcher("/jsp/admin_userupdate.jsp").forward(request, response);
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
		String birthday = request.getParameter("Birthday");
		String email = request.getParameter("Email");
		String phone = request.getParameter("Phone");
		String address = request.getParameter("Address");
		String status = request.getParameter("Status");
		
		int rstatus = 1;
		if(status!=null) {
			rstatus = Integer.parseInt(status);
		}
		//创建用户实体
		Shopping_User user = new Shopping_User(id, name, pwd, sex, birthday, null, email, phone, address, rstatus);
		
		//加入数据信息到数据库
		if(UserDao.updatebyid(user) > 0) {
			response.sendRedirect("/MyShoppingSystem/ser/admin_douserlist?cp="+request.getParameter("Nowpage"));
		}else {
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write("alent('用户添加失败！')");
			out.write("location.href='jsp/admin_douserupdate?id="+id+"'");
			out.write("<script>");
		}
	}

}
