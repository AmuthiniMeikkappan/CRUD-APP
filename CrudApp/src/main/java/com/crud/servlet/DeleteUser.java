package com.crud.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.manager.HibernateManager;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userId = Integer.parseInt(req.getParameter("userId"));
		HibernateManager hm = new HibernateManager();
		hm.deleteUser(userId);
		resp.sendRedirect("fetchdata");
	}
}