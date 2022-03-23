package com.q.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.q.dao.UserDao;

/**
 * Servlet implementation class DoUserDelete
 */

public class DoUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("ID");
		
		//
		if(UserDao.user_delete(id) > 0) {
			response.sendRedirect("/MyShoppingSystem/ser/admin_douserlist?cp="+request.getParameter("Nowpage"));
		}
		else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alent('用户删除失败！')");
			out.write("location.href='jsp/admin_userlist.jsp'");
			out.write("<script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String ids[] = request.getParameterValues("idCchoice");
		for(int i=0; i<ids.length;i++) {
			//
			UserDao.user_delete(ids[i]);
		}
		response.sendRedirect("/MyShoppingSystem/ser/admin_douserlist");
	}

}
