package learn;

import com.dbConnection.registerdb;
import java.io.IOException;
import java.sql.PreparedStatement;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Questions extends HttpServlet
{
  public Questions() {}
  
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {    String rr = "CREATE TABLE IF NOT EXISTS marks(uname VARCHAR(200),score VARCHAR(20),date VARCHAR(200))";

    Connection con = null;
    PreparedStatement st = null;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Calendar cal = Calendar.getInstance();
    
    HttpSession session = req.getSession();
    PrintWriter out = res.getWriter();
    try
    {
      con = registerdb.getConnection();
      PreparedStatement create = con.prepareStatement(rr);
      create.executeUpdate();
      String name = (String)session.getAttribute("email");
      String ans1 = req.getParameter("ans1");
      String ans2 = req.getParameter("ans2");
      String ans3 = req.getParameter("ans3");
      String ans4 = req.getParameter("ans4");
      String ans5 = req.getParameter("ans5");
      System.out.print(ans5);
      int c = 0;
      if (ans1.equals("Bay of Bengal"))
        c++;
      if (ans2.equals("Ganga plains"))
        c++;
      if (ans3.equals("End of June"))
        c++;
      if (ans4.equals("Bay of Bengal"))
        c++;
      if (ans5.equals("Mid-October"))
        c++;
      String query = "insert into marks values (?,?,?)";
      
      st = (PreparedStatement)con.prepareStatement(query);
      st.setString(1, name);
      st.setInt(2, c);
      st.setString(3, dateFormat.format(cal.getTime()));
      st.executeUpdate();
      out.println("Your score  = " + c);

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