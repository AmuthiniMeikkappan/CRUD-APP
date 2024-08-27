package com.crud.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crud.entity.User;
import com.crud.manager.HibernateManager;

@WebServlet("/fetchdata")
public class FetchAllUserServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HibernateManager hm = new HibernateManager();
		List<User> userList = hm.getAllUser();
		HttpSession session = req.getSession();
		session.setAttribute("userList", userList);
		resp.sendRedirect("home.jsp");
	}

}
