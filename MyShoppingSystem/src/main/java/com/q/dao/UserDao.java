package com.q.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.q.entity.Shopping_User;
import com.q.jdbc.JDBC;

public class UserDao {
	
	/**
	 * (注册)插入详细数据
	 * @param con
	 * @param user
	 * @return
	 */
	public static int user_insert(Shopping_User user) {
		int status = 0;
		Connection con = null;
		con = JDBC.getConnection();
		PreparedStatement prs = null;
		String sql = "insert into shopping_user values(?, ?, ?, ?, DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?, ?)";
		Object[] params = {
				user.getUSER_ID(),
				user.getUSER_NAME(),
				user.getUSER_PASSWORD(),
				user.getUSER_SEX(),
				user.getUSER_BIRTHDAY(),
				user.getUSER_IDENITY_CODE(),
				user.getUSER_EMAIL(),
				user.getUSER_PHONE(),
				user.getUSER_ADDRESS(),
				user.getUSER_STATUS()
				
		};
		System.out.print(params);
		try {
			prs = con.prepareStatement(sql);
			for(int i=0; i<params.length; i++) {
				prs.setObject(i+1, params[i]);
			}
			status = prs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close_rele_all(con, prs, null);
		}
		return status;
	}
	
	/**
	 * 管理员查询用户表
	 * @param nowpage
	 * @param page_count
	 * @param keyword
	 * @return
	 */
	public static ArrayList<Shopping_User> user_select_all(int nowpage, int page_count, String keyword){
		ArrayList<Shopping_User> list = new ArrayList<Shopping_User>();
		//
		ResultSet rs = null;
		//
		Connection con = JDBC.getConnection();
		PreparedStatement prs = null;
		
		String sql = "";
		try {
			if(keyword!=null) {
				sql = "select * from shopping_user where user_name like ? order by USER_BIRTHDAY desc limit ?, ?";
				prs = con.prepareStatement(sql);
				prs.setString(1, "%"+keyword+"%");
				prs.setInt(2, (nowpage-1)*page_count);
				prs.setInt(3, page_count);
			}else {
				sql = "select * from shopping_user order by USER_BIRTHDAY desc limit ?, ?";
				prs = con.prepareStatement(sql);
				prs.setInt(1, (nowpage-1)*page_count);
				prs.setInt(2, page_count);
			}
			rs = prs.executeQuery();
			while(rs.next()) {
				Shopping_User user = new Shopping_User(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("USER_BIRTHDAY"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_PHONE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS")
						);
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close_rele_all(con, prs, rs);
		}
		return list;
	}
	
	/**
	 * 获取用户表页数
	 * @param count
	 * @return
	 */
	public static int[] totalpage(int count, String keyword) {
		int arr[] = {0, 1};
		
		Connection con = JDBC.getConnection();
		PreparedStatement prs = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			if(keyword!=null) {
				sql = "select count(*) from shopping_user";
				prs = con.prepareStatement(sql);
				prs.setString(1, "%"+keyword+"%");
			}else {
				sql = "select count(*) from shopping_user";
				prs = con.prepareStatement(sql);
			}
			rs = prs.executeQuery();
			
			while(rs.next()) {
				arr[0] = rs.getInt(1);
				arr[1] = arr[0]/count + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close_rele_all(con, prs, rs);
		}
		return arr;
	}
	
	/*
	 * 管理员账号管理id查询
	 */
	public static Shopping_User searchbyid(String userid){
		Shopping_User user = null;
		//
		ResultSet rs = null;
		//
		Connection con = JDBC.getConnection();
		PreparedStatement prs = null;
		
		try {
			String sql = "select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')CHANGE_BIRTHDAY from Shopping_User m where user_id=?";
			prs = con.prepareStatement(sql);
			prs.setString(1, userid);
			rs = prs.executeQuery();
			while(rs.next()) {
				user = new Shopping_User(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("CHANGE_BIRTHDAY"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_PHONE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close_rele_all(con, prs, rs);
		}
		return user;
	}
	
	/*
	 * 账户信息修改
	 */
	public static int updatebyid(Shopping_User user) {
		int status = 0;
		Connection con = null;
		con = JDBC.getConnection();
		PreparedStatement prs = null;
		String sql = "update SHOPPING_USER set USER_NAME=?, USER_PASSWORD=?, USER_SEX=?, USER_BIRTHDAY=DATE_FORMAT(?, '%Y-%m-%d'), USER_IDENITY_CODE=?, USER_EMAIL=?, USER_PHONE=?, USER_ADDRESS=?, USER_STATUS=? where USER_ID=?";
		Object[] params = {
				user.getUSER_NAME(),
				user.getUSER_PASSWORD(),
				user.getUSER_SEX(),
				user.getUSER_BIRTHDAY(),
				user.getUSER_IDENITY_CODE(),
				user.getUSER_EMAIL(),
				user.getUSER_PHONE(),
				user.getUSER_ADDRESS(),
				user.getUSER_STATUS(),
				user.getUSER_ID()
				
		};
		try {
			prs = con.prepareStatement(sql);
			for(int i=0; i<params.length; i++) {
				prs.setObject(i+1, params[i]);
			}
			status = prs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close_rele_all(con, prs, null);
		}
		return status;
	}
	
	/**
	 * 删除账户
	 * @param id
	 * @return
	 */
	public static int user_delete(String id) {
		int status = 0;
		Connection con = null;
		con = JDBC.getConnection();
		PreparedStatement prs = null;
		String sql = "delete from SHOPPING_USER where USER_ID=? and USER_STATUS!=2";
		Object[] params = {id};
		try {
			prs = con.prepareStatement(sql);
			for(int i=0; i<params.length; i++) {
				prs.setObject(i+1, params[i]);
			}
			status = prs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close_rele_all(con, prs, null);
		}
		return status;
	}
	
	
	//用户注册申请
	
	/**
	 * 用于登录注册时id查重
	 * @param id
	 * @return
	 */
	public static int userid_ifsame(String id) {
		int nosame = 0;
		Connection con = null;
		con = JDBC.getConnection();
		PreparedStatement prs = null;
		ResultSet rs = null;
		String sql = "select * from SHOPPING_USER where USER_ID=?";
		try {
			prs = con.prepareStatement(sql);
			prs.setString(1, id);
			rs = prs.executeQuery();
			if(!rs.next()) {
				nosame = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close_rele_all(con, prs, rs);
		}
		return nosame;
	}
	
	/*
	 * 用户注册
	 */
	public static int registeruser_insert(String id, String pwd) {
		int status = 0;
		Connection con = null;
		con = JDBC.getConnection();
		PreparedStatement prs = null;
		String sql = "INSERT INTO SHOPPING_USER (USER_ID, USER_PASSWORD, USER_STATUS) VALUES(?,?,?)";
		try {
			prs = con.prepareStatement(sql);
			prs.setString(1, id);
			prs.setString(2, pwd);
			prs.setInt(3, 1);
			status = prs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close_rele_all(con, prs, null);
		}
		return status;
	}
	
	/*
	 * 账户登录判断
	 */
	public static int userlogin(String id, String pwd) {
		int count = 0;
		Connection con = null;
		con = JDBC.getConnection();
		PreparedStatement prs = null;
		ResultSet rs = null;
		String sql = "select count(*) from SHOPPING_USER where USER_ID=? and USER_PASSWORD=?";
		try {
			prs = con.prepareStatement(sql);
			prs.setString(1, id);
			prs.setString(2, pwd);
			rs = prs.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close_rele_all(con, prs, rs);
		}
		return count;
	}
	
	/*
	 * 登陆后获取用户信息
	 */
	public static Shopping_User login_getuser(String id, String pwd) {
		Shopping_User user = null;
		//
		ResultSet rs = null;
		//
		Connection con = JDBC.getConnection();
		PreparedStatement prs = null;
		
		try {
			String sql = "select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')CHANGE_BIRTHDAY from Shopping_User m where user_id=? and USER_PASSWORD=?";
			prs = con.prepareStatement(sql);
			prs.setString(1, id);
			prs.setString(2, pwd);
			rs = prs.executeQuery();
			while(rs.next()) {
				user = new Shopping_User(
						rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("CHANGE_BIRTHDAY"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_PHONE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close_rele_all(con, prs, rs);
		}
		return user;
	}
}
