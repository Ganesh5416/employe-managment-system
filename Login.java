package com.tka;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	     String email = req.getParameter("email");
	     String pass = req.getParameter("password");
	       
	        PrintWriter out =resp.getWriter();
	     
	
	        try {
				
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/capgemini", "root", "ganesh");
	        	 PreparedStatement ps = c.prepareStatement("select * from employee where email=? and password=?;");
	        	ps.setString(1, email);
	        	ps.setString(2, pass);
	        	
	        	ResultSet rs = ps.executeQuery();
	        	
	        	if(rs.next()) {
	        		System.out.println("Login Successful");
	        	out.println("<h1>Login Successful</h1>");
	        	}
	        	else {
	        		out.println("Invalid Credential");
	        		System.out.println("Invalid Credential");
	        	}
	        	
	        	
	        	
	        	
	        	
			} catch (Exception e) {
			out.println(e.getMessage());
			System.out.println(e.getMessage());
			
			}
	
	        
	        
	        
	        
	        
	        
	}
				
}
