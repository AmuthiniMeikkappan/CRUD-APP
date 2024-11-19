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

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String  name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String date = req.getParameter("dob");
			String gender = req.getParameter("gender");
			String mobile = req.getParameter("mobile");
			String address = req.getParameter("address");
			
			Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		
			User user = new User(name,email,password,dob,gender,mobile,address);
			HibernateManager hm = new HibernateManager();
			hm.addUser(user);
			resp.sendRedirect("fetchdata");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
