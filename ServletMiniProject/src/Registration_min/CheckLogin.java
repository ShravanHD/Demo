    package Registration_min;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Login2")
public class CheckLogin extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		System.out.println("login page");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String query = "Select Name,Email,Password from registor where (email like '"+ email+"' AND password like '"+pass+"'); ";

		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shravan_travels","root","root");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			
			while(rs.next()) 
			{
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				
				pw.print("<div id=\"name\"><p style=\"margin: 10px;\">Hello "+rs.getString(1)+"</p></div>");
				
				RequestDispatcher rd = req.getRequestDispatcher("Home_Page.html");
				rd.include(req, resp);	
				pw.close();
			}
			
			resp.setContentType("text/html");
			
			PrintWriter pw = resp.getWriter();
			
			pw.println(" <div id=\"error\"> <p >Incurrect User name or Password.</p> </div>");
			
			
			RequestDispatcher rd = req.getRequestDispatcher("Login_mini.html");
			rd.include(req, resp);
		}
		catch(IllegalStateException e)
		{
			System.out.println("data not found");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
