package Registration_min;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Registor_mini")
public class Registration_min_Servlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("number"));
		String pass = req.getParameter("password");
		String gender = req.getParameter("gender");
		
		String query = "Select Email,Password from registor where email like '"+ email+"'; ";
		
		//store data in data base
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
				
				pw.println(" <div id=\"error\"> <p >User already exist.</p> </div>");
				
				
				
				RequestDispatcher rd = req.getRequestDispatcher("Registration_min.html");
				rd.include(req, resp);
			}
			
			resp.setContentType("text/html");
			
			PrintWriter pww = resp.getWriter();
			
			pww.print("<div id=\"name\"><p style=\"margin: 10px;\">Hello "+name+"</p></div>");
			
			PreparedStatement ps = con.prepareStatement("insert into registor values (?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setLong(3, phone);
			ps.setString(4, pass);
			ps.setString(5, gender);
			
			System.out.println(name+email+phone+pass+gender);
			ps.executeUpdate();
			
			RequestDispatcher rd1 = req.getRequestDispatcher("Home_Page.html");
			rd1.include(req, resp);
				
			
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			System.out.println("Dont worry Shravan is there to handle exception");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}
}                                                                    
