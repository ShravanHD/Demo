package Registration_min;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		HttpSession session = req.getSession();
		String email = (String)session.getAttribute("myemail");
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.print("your email is :"+email);
		
		//invalidating the session
		session.invalidate();
		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
	}
}
