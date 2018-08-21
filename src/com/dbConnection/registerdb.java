package com.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class registerdb
{
  
  
  public static Connection getConnection()
  {
    Connection con = null;
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exams","root","root");

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return con;
  }
  
  public static void closeConnection(Connection con, PreparedStatement pst)
  {
    try {
      if (con != null) {
        con.close();
      }
      if (pst != null) {
        pst.close();
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}