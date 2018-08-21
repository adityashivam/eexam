package learn;


import com.dbConnection.registerdb;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends javax.servlet.http.HttpServlet
{
  
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException
  {
    Connection con = null;
    PreparedStatement st = null;
    PrintWriter out = res.getWriter();
    String rr = "CREATE TABLE IF NOT EXISTS register(uname VARCHAR(200),age INT(20),email VARCHAR(200),user_id VARCHAR(30), pass VARCHAR(50))";
    int msg = 0;
    try
    {
      con = registerdb.getConnection();
      
      PreparedStatement create = con.prepareStatement(rr);
      create.executeUpdate();

      res.setContentType("text/html");
      String name = req.getParameter("name");
      String age = req.getParameter("age");
      String email = req.getParameter("email");
      String userid = req.getParameter("userId");
      String pass = req.getParameter("pass");
      ServletContext ctx = getServletContext();
      String qryIsUserExist = "select * from register  r where r.user_id='" + userid + "'";
      PreparedStatement pst = con.prepareStatement(qryIsUserExist);
      ResultSet rs = pst.executeQuery();
      if (rs.next())
      {
        msg = 1;
      }
      
      if (msg != 1)
      {
        String query = "insert into register values (?,?,?,?,?)";
        
        st = con.prepareStatement(query);
        st.setString(1, name);
        st.setString(2, age);
        st.setString(3, email);
        st.setString(4, userid);
        st.setString(5, pass);
        
        int a = st.executeUpdate();
        if (a > 0) {
          msg = 2;
          req.setAttribute("msg", Integer.valueOf(msg));
          RequestDispatcher view = ctx.getRequestDispatcher("/register.jsp");
          view.forward(req, res);
          System.out.println("Data successfully inserted in register table");
          con.commit();
        } else {
          out.print("Registeration Fail");
          
          System.out.println("Data not inserted in register table");
          con.rollback();
        }
        
      }
      else
      {
        req.setAttribute("msg", Integer.valueOf(msg));
        RequestDispatcher view = ctx.getRequestDispatcher("/register.jsp");
        view.forward(req, res);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    } finally {
      System.out.println("Data not inserted in register table");
      
      registerdb.closeConnection(con, st);
    }
  }
}