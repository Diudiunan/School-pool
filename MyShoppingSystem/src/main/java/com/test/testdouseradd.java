package com.test;

import org.junit.Test;

import com.q.dao.UserDao;
import com.q.entity.Shopping_User;

public class testdouseradd {
	@Test
	public void testDoUser() {
		Shopping_User user = new Shopping_User("99993534634", "2222", "3333", "T", "2020/11/03", "4444", "5555", "6666", "7777", 1);
		if(UserDao.user_insert(user)>0) {
			System.out.print("插入成功");
		}else {
			System.out.print("插入失败");
		}
	}
}
