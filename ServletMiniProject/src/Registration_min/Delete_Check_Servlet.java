package Registration_min;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete_Pass_Check")
public class Delete_Check_Servlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email = req.getParameter("email_Check");
		String pass = req.getParameter("password_Check");
		 

		String query = "Select * from registor where email = '"+email+"' AND password = '"+pass+"'" ;
		System.out.println(query);
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shravan_travels","root","root");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				PreparedStatement ps = con.prepareStatement("DELETE FROM registor WHERE email =?");
				ps.setString(1, email);
				
				ps.executeUpdate();
				
				
				RequestDispatcher rd = req.getRequestDispatcher("Deleted.html");
				rd.forward(req, resp);
				
			}
			
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			pw.println(" <div id=\"error\"> <p >Incurrect User name or Password.</p> </div>");
			
			RequestDispatcher rd = req.getRequestDispatcher("Delete.html");
			rd.include(req, resp);
			
	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		

		
	}
}
