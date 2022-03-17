package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String contact = request.getParameter("contact");
		
		
		  try
	      {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con=DriverManager.getConnection
	         ("jdbc:mysql://localhost:3306/sakila?autoReconnect=true&useSSL=false","root","1234");
	       
	Statement stmt=(Statement) con.createStatement();
	  String q1="select * from emp_details where uname="+uname+" and pass="+pass+";";
	  String q2="select * from emp_salary where uname="+uname+" and pass="+pass+";";
	        ResultSet rs=stmt.executeQuery(q1);
	        if(rs.next())
	        {

				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("report.jsp");
	          }
	       else
	       {
	    	   response.sendRedirect("login.jsp");
	       }
	     con.close();
	     }
	     catch(Exception e)
	     { 
	        
	          System.out.println(e);
	     }
		
	}


}
