package com.q.servlet;

import java.io.IOException;

import com.q.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterUserIDIsSame extends HttpServlet{
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserIDIsSame() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String UID = request.getParameter("ID");
		int count = UserDao.userid_ifsame(UID);
		if(count==0) {
			response.setStatus(count);
			
		}
	}
}
