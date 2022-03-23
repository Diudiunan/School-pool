package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.q.jdbc.JDBC;

public class testjdbc {
	@Test
	public void testJDBC() {
		Connection con = null;
		con = JDBC.getConnection();
		PreparedStatement prs = null;
		String sql = "insert into shopping_user values(?, ?, ?, ?, DATE_FORMAT(?,'%Y-%m-%d'), ?, ?, ?, ?, ?)";
		//String SQL = "SELECT * FROM shopping_user";
		Object[] params = {
				"1424325r35",
				"12345",
				"12345",
				"T",
				"2019/10/19",
				"12345",
				"12345",
				"12345",
				"12345",
				1	
		};
		try {
			prs = con.prepareStatement(sql);
			for(int i=0; i<params.length; i++) {
				prs.setObject(i+1, params[i]);
			}
			//prs = con.prepareStatement(SQL);
			System.out.print(prs.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close_rele_all(con, prs, null);
		}
	}
	
}
