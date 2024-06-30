package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.entity.Employee;

public class  GetAll extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   res.setContentType("text/html");
	            
	        try {
	      	  Class.forName("com.mysql.cj.jdbc.Driver"); 
	      	    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root123");
	      	    PreparedStatement s=con.prepareStatement("select * from product");
	        
	      	    List<Employee> list= new ArrayList<Employee>();
	      	    ResultSet m=s.executeQuery();
	      	    
	      	    while(m.next()) {
	      	    	
	      	    	int ID=m.getInt("ID");
	      	    	String NAME=m.getString("NAME");
	      	    	int PRODUCT_ID =m.getInt("PRODUCT_ID");
	      	    	int PRICE =m.getInt("PRICE");
	      	    	int STOCK =m.getInt("STOCK");
	      	    	String TYPE1 =m.getString("TYPE");
	      	    	Employee e=new Employee(ID, NAME, PRODUCT_ID, PRICE, STOCK, TYPE1);
	      	    	list.add(e);
	      	    }
	      	    
	      	    req.setAttribute("uk",list);
	      	    RequestDispatcher rd=req.getRequestDispatcher("salt.jsp");
	      	    rd.forward(req, res);
}catch(Exception e) {
	
	
}
	}
}
