package Registration_min;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Pass_Check")
public class Pass_Check extends HttpServlet
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
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				
				pw.println("Your Old data :\n");
				pw.print(" Name : "+rs.getString(1)+"\n");
				pw.print(" Email : "+rs.getString(2)+"\n");
				pw.print(" Phone No : "+rs.getString(3));
				pw.print(" Gender : "+rs.getString(5));
				pw.print(" Password : "+rs.getString(4));
				
				
				RequestDispatcher rd = req.getRequestDispatcher("Update.html");
				req.setAttribute("Name", rs.getString(1));
				rd.include(req, resp);
				System.out.println("hi");
				 
			}
			
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			pw.print("Incorrect UserName or Password...");
			
			RequestDispatcher rd = req.getRequestDispatcher("PasswordCheck.html");
			rd.include(req, resp);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	
}
