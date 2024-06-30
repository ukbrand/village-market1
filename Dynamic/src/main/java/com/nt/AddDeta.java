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

import com.mysql.cj.jdbc.Driver;

public class AddDeta extends HttpServlet {

   @Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
   
	   
	   
	   int ID = Integer.parseInt(req.getParameter("t1"));
	   String NAME = req.getParameter("t2");
	   int PRODUCT_ID = Integer.parseInt(req.getParameter("t3"));
	   int PRICE = Integer.parseInt(req.getParameter("t4"));	   
	   int STOCK = Integer.parseInt(req.getParameter("t5"));    
	   String TYPE1 = req.getParameter("t6");
	    System.out.println(ID);
	    System.out.println(NAME);
	    System.out.println(PRODUCT_ID);
	    System.out.println(PRICE);
	    System.out.println(STOCK);
	    System.out.println(TYPE1);
	   res.setContentType("text/html");
	    PrintWriter pw = res.getWriter();
	    
	    pw.write("Hello<br>");
	    pw.write("<h1>Data Add Successfully<br></h1>");
	    pw.close();
  try {
	  Class.forName("com.mysql.cj.jdbc.Driver"); 
	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root123");
	    PreparedStatement s=con.prepareStatement("INSERT INTO product(ID, NAME, PRODUCT_ID, PRICE, STOCK, TYPE) values (?,?,?,?,?,?)");
	    s.setInt(1,ID); 
	    s.setString(2,NAME);
	    s.setInt(3,PRODUCT_ID);
	    s.setInt(4, PRICE);
	    s.setInt(5,STOCK);
	    s.setString(6,TYPE1);
	    s.executeUpdate();
   }catch(Exception e) {
	   
   }
}}
