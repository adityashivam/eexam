package learn;

import com.dbConnection.registerdb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Leaderboard
  extends HttpServlet
{
  
  public void service(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    Connection con = null;
    PreparedStatement st = null;
    PrintWriter out = res.getWriter();
    
    try
    {
      con = registerdb.getConnection();
      st = con.prepareStatement("SELECT * FROM marks ORDER BY score desc");
      ResultSet rs = st.executeQuery();
      int r = 1;
      String k = " ";
      String d = "yyyy/mm/dd";
      


      out.println("Rank    " + k + " | MARKS    " + k + " | DATE-TIME    " + d + " | USER ID   " + k);
      out.println("----------------------------------------------------------------------");
      
      while (rs.next())
      {
        out.println("Rank => " + r + " | MARKS => " + rs.getString(2) + " | DATE-TIME => " + rs.getString(3) + " | USER ID => " + rs.getString(1));
        r++;
      }
      

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally {
      registerdb.closeConnection(con, st);
    }
  }
}