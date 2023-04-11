package Registration_min;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update_data")
public class Update_Servlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("number"));
		String pass = req.getParameter("password");
		String gender = req.getParameter("gender");
		String old_email = req.getParameter("old_email");
		
		try
		{
			System.out.println("Updading...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shravan_travels","root","root");
			
			
			PreparedStatement ps = con.prepareStatement("update registor set name = ? ,phone = ?,password = ?, Gender = ? where email= ?");
			ps.setString(1, name);
			
			ps.setLong(2, phone);
			ps.setString(3, pass);
			ps.setString(4, gender);
			ps.setString(5, old_email);
			
			
			ps.executeUpdate();
			
			
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			
			pw.println("Youer data updated");
			pw.println("old email : "+old_email);
			pw.println(" name : "+ name);
			pw.println(" email : "+ email);
			pw.println(" mobile no : "+ phone);
			pw.println(" Gender : "+ gender);
			
			RequestDispatcher rd = req.getRequestDispatcher("Home_Page.html");
			rd.include(req, resp);
			
		}

		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
