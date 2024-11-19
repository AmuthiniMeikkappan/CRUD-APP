package com.crud.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.entity.User;
import com.crud.manager.HibernateManager;

@WebServlet("/modify")
public class ModifyServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		int userId = Integer.parseInt(req.getParameter("userId"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String date = req.getParameter("dob");
		String gender = req.getParameter("gender");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		
		Date dob = new SimpleDateFormat("yyyy-mm-dd").parse(date);
		
		HibernateManager hm = new HibernateManager();
		User user = new User(userId,name,email,password,dob,gender,mobile,address);
		hm.updateUser(user);
		resp.sendRedirect("fetchdata");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
