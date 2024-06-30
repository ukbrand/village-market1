package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteData extends HttpServlet{

	
	 @Override
	 protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    
	 	   
	 	   
	 	   int id = Integer.parseInt(req.getParameter("inputField"));
	 	   res.setContentType("text/html");
	 	    PrintWriter pw = res.getWriter();
	 	    
	 	   pw.write("<html><body><a href='index.html' style='display: inline-block; padding: 10px 20px; margin: 10px; background-color: #007BFF; color: white; border-radius: 3px; text-decoration: none; font-size: 16px;'><i class='fas fa-home'></i> Home</a></body></html>");

	 	  pw.write("<html><body><script>alert('Data deleted successfully'); window.location.href = 'index.html';</script></body></html>");

	 	    pw.close();
	   try {
	 	  Class.forName("com.mysql.cj.jdbc.Driver"); 
	 	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root123");
	 	    PreparedStatement s=con.prepareStatement("DELETE FROM product WHERE id = ?");
	 	    s.setInt(1, id); 	 
	 	    s.executeUpdate();
	    }catch(Exception e) {
	 	   
	    }
	 }
}
