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

public class Update extends HttpServlet {
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
			String Stud_name =(String) req.getParameter("Stud_name");
	        String Enrolment_id =(String) req.getParameter("Enrolment_id");
	        int EnrolID=Integer.parseInt(Enrolment_id);
	       String BalanceView = (String) req.getParameter("View_balance");
	       int View_balance=Integer.parseInt(BalanceView);
	       String fees = (String) req.getParameter("Tuition_fees");
	       int fee=Integer.parseInt(fees);    	       
	       String Status = (String) req.getParameter("Status");
	       int show=Integer.parseInt(Status);
	        
	        Connection con;
	        PreparedStatement pst;
	        
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentlist","root","");
	        
	 
	        String sqlquery="Update records set Stud_name =?,View_balance =?, Tuition_fees =? where id="+EnrolID;
	        pst=con.prepareStatement(sqlquery);
	    		   
	      
	        pst.setString(1, Stud_name);
	        pst.setInt(2, EnrolID);
	        pst.setInt(3,View_balance);
	        pst.setInt(4, fee);
	        pst.setInt(5, show);
	        pst.executeUpdate();  
	        out.println("updated");
}
	  catch (Exception e)
    {
    out.println("An error occurred."+e);
    }
	   }
}
