package learn;

import com.dbConnection.registerdb;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet
{
  
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, java.io.IOException
  {
    Connection con = null;
    PreparedStatement st = null;
    PreparedStatement name = null;
    try
    {
      res.setContentType("text/html");
      ServletContext ctx = getServletContext();
      String userPassFromDb = "";
      
      String userid = req.getParameter("userid");
      String pass = req.getParameter("pass");
      System.out.print("1");
      
      con = registerdb.getConnection();
      System.out.print("2");
      st = con.prepareStatement("SELECT pass FROM `register` WHERE user_id= '" + userid + "'");
      name = con.prepareStatement("SELECT uname FROM `register` WHERE user_id= '" + userid + "'");
      
      System.out.print("3");
      
      ResultSet rs = st.executeQuery();
      ResultSet sr = name.executeQuery();
      
      System.out.print("4");
      
      if ((rs.next()) && (sr.next()))
      {
        System.out.print("5");
        
        userPassFromDb = rs.getString(1);
        String n = sr.getString(1);
        System.out.print(userPassFromDb);
        System.out.print(n);
        
        if ((pass.equals(userPassFromDb)) && (pass != "")) {
          HttpSession session = req.getSession();
          session.setAttribute("name", n);
          session.setAttribute("email", userid);
          
          RequestDispatcher view = ctx.getRequestDispatcher("/question.jsp");
          
          view.forward(req, res);

        }
        else
        {
          req.setAttribute("msg", "you are not valid user please try again");
          RequestDispatcher view = ctx.getRequestDispatcher("/login.jsp");
          view.forward(req, res);
        }
      }
      else
      {
        req.setAttribute("msg", "you are not valid user please try again");
        RequestDispatcher view = ctx.getRequestDispatcher("/login.jsp");
        view.forward(req, res);
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