package com.signup;

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


/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class Signup extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		  try
	      {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con=DriverManager.getConnection
	         ("jdbc:mysql://localhost:3306/sakila?autoReconnect=true&useSSL=false","root","1234");
	       
	       Statement stmt=(Statement) con.createStatement();
	        String q1="select * from emp_details where uname="+uname+" and pass="+pass+";";
	        ResultSet rs=((java.sql.Statement) stmt).executeQuery(q1);
	        response.sendRedirect("login.jsp");
	     con.close();
	     }
	     catch(Exception e)
	     { 
	        
	          System.out.println(e);
	     }
	}
}
