package com.crud.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.entity.User;
import com.crud.manager.HibernateManager;

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userId = Integer.parseInt(req.getParameter("userId"));
		String  name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		
		User user = new User(userId,name,email,password,mobile,address);
		HibernateManager hm = new HibernateManager();
		hm.addUser(user);
		resp.sendRedirect("fetchdata");
	}
}
