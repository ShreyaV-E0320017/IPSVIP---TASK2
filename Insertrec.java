package com.shreya;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
  
// This class can be used to initialize the database connection 
import java.io.IOException;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insertrec extends HttpServlet {
   

   @Override
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

      // variables
      PrintWriter out = null;
      

      // set content type
      res.setContentType("text/html");
      // get Writer
     out = res.getWriter();

      // get form data
     
     
  
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
    	        pst = con.prepareStatement("insert into records(Stud_name,Enrolment_id,View_balance,Tuition_fees,Status)values(?,?,?,?,?)");
    	      
    	    		  
    	        pst.setString(1, Stud_name);
    	        pst.setInt(2, EnrolID);
    	        pst.setInt(3,View_balance);
    	        pst.setInt(4, fee);
    	        pst.setInt(5, show);
    	        pst.executeUpdate();  
    	        out.println("Data is inserted successfully");
      }
    	  catch (Exception e)
          {
          out.println("An error occurred."+e);
          }   
     
    	  
   }

   }

   
