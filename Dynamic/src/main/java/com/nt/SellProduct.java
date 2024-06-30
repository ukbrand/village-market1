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

public class SellProduct extends HttpServlet{


	 protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		 ID, NAME, PRODUCT_ID, PRICE, STOCK, TYPE
	 	   
		   int ID = Integer.parseInt(req.getParameter("ID"));          
           int STOCK = Integer.parseInt(req.getParameter("STOCK"));          

	 	    res.setContentType("text/html");
	 	    PrintWriter pw = res.getWriter();
	 	    
	 	    pw.write("Hey");
	 	    pw.write("Sell successfully<br>");
	 	    pw.close();
	   try {
	 	    Class.forName("com.mysql.cj.jdbc.Driver"); 
	 	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root123");
	 	    PreparedStatement s=con.prepareStatement("UPDATE product SET STOCK=STOCK-? WHERE ID = ?");	 	    
	 	    s.setInt(1,STOCK);	 
	 	    s.setInt(2,ID);
	 	    s.executeUpdate(); 
	    }catch(Exception e) {
	 	   
	    }
	 }}

