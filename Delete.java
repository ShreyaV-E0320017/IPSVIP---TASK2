package com.shreya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {
	   // SQL query
	   

	   @Override
	   public void doGet(HttpServletRequest req, HttpServletResponse res) 
	         throws ServletException, IOException {

	      // variables
	      PrintWriter out = null;
	      

	      // set content type
	      res.setContentType("text/html");
	      // get Writer
	     out = res.getWriter();
	
	
	
	try{
		  String id = (String) req.getParameter("Enrolment_id");
		  int EnrolID=Integer.parseInt(id);
	        
	        Connection con;
	        PreparedStatement pst;
	        
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENTLIST","root","");
	        
	 
	        String sqlquery="Delete from records where id="+EnrolID;
	        pst=con.prepareStatement(sqlquery);
	    		   
	        
	        pst.executeUpdate();  
	        out.println("RECORDS ARE DELETED SUCCESSFULLY ");
}
	  catch (Exception e)
 {
 out.println("An error occurred."+e);
 }
	   }

}
