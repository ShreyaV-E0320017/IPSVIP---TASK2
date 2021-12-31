package com.shreya;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
  
// This class can be used to initialize the database connection 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Student extends HttpServlet {
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

      // get form data
      Connection connection = null;
      try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
      Statement statement = connection.createStatement();
      String dbname=req.getParameter("DbCreate");
      String query = "CREATE DATABASE "+ dbname;
      statement.executeUpdate(query);
      out.println("Database is created sucessfully.");
      }
      catch (Exception e)
      {
      out.println("An error occurred."+e);
      }
      }
   

   @Override
   public void doPost(HttpServletRequest req, HttpServletResponse res) 
         throws ServletException, IOException {
      doGet(req, res);
   }
}
