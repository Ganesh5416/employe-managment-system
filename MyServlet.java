package com.tka;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class MyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("empName");
		String id = request.getParameter("empId");
		int empid = Integer.parseInt(id);
		String city = request.getParameter("city");
		String mob = request.getParameter("mobile");
		long number = Long.parseLong(mob);
		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		System.out.println(name);
		System.out.println(empid);
		System.out.println(city);
		System.out.println(mob);
		System.out.println(email);
		System.out.println(pass);
	}

}
