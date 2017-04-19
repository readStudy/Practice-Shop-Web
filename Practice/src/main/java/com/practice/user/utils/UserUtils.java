package com.practice.user.utils;

import javax.servlet.http.HttpSession;

import com.practice.user.model.User;

public class UserUtils {
	private static final String LOGINED_USER = "loginedUser";
	
	public static User getInSession(HttpSession session) {
		return (User)session.getAttribute(LOGINED_USER);
	}
	public static void logout(HttpSession session){
		session.invalidate();
	}
	public static void putInSession(HttpSession session, User user){
		session.setAttribute(LOGINED_USER, user);
	}
}
