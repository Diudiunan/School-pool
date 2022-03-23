package com.q.servlet;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.q.dao.UserDao;
import com.q.entity.Shopping_User;

/**
 * Servlet implementation class DoUserList
 */
public class DoUserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int nowpage = 1;//
		int page_count = 5;
		//
		String cp = request.getParameter("cp");
		//
		String keyword = request.getParameter("keyword");
		
		if(cp!=null) {
			nowpage = Integer.parseInt(cp);
		}
		int arr[] = UserDao.totalpage(page_count, keyword);
		
		//
		ArrayList<Shopping_User> list = UserDao.user_select_all(nowpage, page_count, keyword);
		System.out.print(list);
		//
		request.setAttribute("userlist", list);
		request.setAttribute("suernumber", arr[0]);
		request.setAttribute("userpage", arr[1]);
		request.setAttribute("nowpage", nowpage);
		if(keyword!=null) {
			request.setAttribute("searchparams", "&keyword"+keyword);
		}
		request.getRequestDispatcher("/jsp/admin_user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
