package com.tka;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {

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

           PrintWriter out =response.getWriter();
		
	    try {
			
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/capgemini", "root", "ganesh");
	                 PreparedStatement ps = c.prepareStatement("insert into employee (employee_id , employee_name , "
	                 		+ "city , mobile , email, password) values (?,?,?,?,?,?);");
			        ps.setInt(1, empid);
			        ps.setString(2, name);
			        ps.setString(3, city);
			        ps.setLong(4, number);
			        ps.setString(5, email);
			        ps.setString(6, pass);
			int check =ps.executeUpdate();
			if(check >0) {
				System.out.println("Successfulyy Register ");
				RequestDispatcher rd = request.getRequestDispatcher("/login.html");
				rd.forward(request, response);
			}
			else {
				System.out.println("Not Register");
			}
			
	    }
	
	    
	    
	    catch(Exception e) {
	    	System.out.println(e.getMessage());
	    out.println(e.getMessage());	
	    }
	}

}
