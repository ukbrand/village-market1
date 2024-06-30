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

public class Update extends HttpServlet {

	

	 protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		 ID, NAME, PRODUCT_ID, PRICE, STOCK, TYPE
	 	   
		    int ID = Integer.parseInt(req.getParameter("ID"));
            String NAME = req.getParameter("NAME");
            int PRODUCT_ID = Integer.parseInt(req.getParameter("PRODUCT_ID"));
            int PRICE = Integer.parseInt(req.getParameter("PRICE"));
            int STOCK = Integer.parseInt(req.getParameter("STOCK"));
            String TYPE = req.getParameter("TYPE");

	 	    res.setContentType("text/html");
	 	    PrintWriter pw = res.getWriter();
	 	    
	 	    pw.write("Hey");
	 	    pw.write("Update successfully<br>");
	 	    pw.close();
	   try {
	 	    Class.forName("com.mysql.cj.jdbc.Driver"); 
	 	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root123");
	 	    PreparedStatement s=con.prepareStatement("UPDATE product SET NAME = ?,PRODUCT_ID = ?,PRICE=?,STOCK=?,TYPE=? WHERE ID = ?");
	 	    s.setString(1,NAME);
	 	    s.setInt(2,PRODUCT_ID);
	 	    s.setInt(3,PRICE);
	 	    s.setInt(4,STOCK);
	 	    s.setString(5,TYPE);
	 	    s.setInt(6,ID);
	 	    s.executeUpdate(); 
	    }catch(Exception e) {
	 	   
	    }
	 }}
