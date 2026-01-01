package com.tka;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/search")
public class search extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	             String id = req.getParameter("empId");
	             int eid = Integer.parseInt(id);
	           
	             PrintWriter out =resp.getWriter(); 
	              try {
				
	            	  Class.forName("com.mysql.cj.jdbc.Driver");
	  	        	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/capgemini", "root", "ganesh");
	  	        	 PreparedStatement ps = c.prepareStatement("select * from employee where employee_id = ? ;");
	            	  ps.setInt(1, eid);
	  	        	 ResultSet rs = ps.executeQuery();
	  	         
	  	        	 if(rs.next()) {
	  	        		 HttpSession session = req.getSession();
	  	        		 session.setAttribute("empid", rs.getInt(1));
	  	        		 session.setAttribute("name", rs.getString(2));
	  	        		 session.setAttribute("city", rs.getString(3));
	  	        		 session.setAttribute("number", rs.getLong(4));
	  	        		 session.setAttribute("email", rs.getString(5));
	  	        		
	  	        		 RequestDispatcher rd  = req.getRequestDispatcher("profile.jsp");
	  	        		 rd.forward(req, resp);
	  	        		 
	  	        	 }
	  	        	 
	  	        	 
				} catch (Exception e) {
				out.println(e.getMessage());
				}
	              
	              
	              
	}
	
	
	
}
