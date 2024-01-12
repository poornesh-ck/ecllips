package edu.in;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet(
		urlPatterns = { "/login" }, 
		initParams = { 
				@WebInitParam(name = "dclass", value = "com.mysql.cj.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/prodapt"), 
				@WebInitParam(name = "uname", value = "root"), 
				@WebInitParam(name = "pass", value = "root")
		})
public class login extends HttpServlet {
	Connection con =null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
				String drivercls=config.getInitParameter("dclass");
				String url=config.getInitParameter("url");
				String uname=config.getInitParameter("uname");
				String pass=config.getInitParameter("pass");
				try {
					Class.forName(drivercls);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					con=DriverManager.getConnection(url,uname,pass);
					System.out.println("ddddddddddddd232323");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PreparedStatement ps;
		String email=req.getParameter("email");
		String pwd=req.getParameter("password");
		
		try {
			ps = con.prepareStatement("select password from employees where email=? ");
			ps.setString(1, req.getParameter("email"));
			//ps.setString(2, req.getParameter("password"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(2).equals(pwd)) 
				res.getWriter().println("Login Succesful");
				RequestDispatcher rd = req.getRequestDispatcher("index.html");
				rd.include(req, res);
				res.getWriter().println("<!DOCTYPE html>\r\n"
						+ "\r\n"
						+ "<html>\r\n"
						+ "\r\n"
						+ "<head>\r\n"
						+ "\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "\r\n"
						+ "<title>login</title>\r\n"
						+ "\r\n"
						+ "</head>\r\n"
						+ "\r\n"
						+ "<body><center><form action=\"./login\" method=\"post\">\r\n"
						+ "\r\n"
						+ "    <table>\r\n"
						+ "\r\n"
						+ "        <tr><td ><h2>Login</h2></td></tr>\r\n"
						+ "\r\n"
						+ "<tr><td><label>E-mail</label> </td><td></label><input type=\"text\" name=\"email\" placeholder=\"enter email-id\"></td></tr>\r\n"
						+ "\r\n"
						+ "<tr><td><label>Password</label></td> <td><input type=\"password\" name=\"password\" placeholder=\"Password\"></td></tr>\r\n"
						+ "\r\n"
						+ "<tr><td ><input type=\"submit\" name=\"Login\"></td> </tr>\r\n"
						+ "\r\n"
						+ "</table>\r\n"
						+ "\r\n"
						+ " \r\n"
						+ "\r\n"
						+ "</form>\r\n"
						+ "\r\n"
						+ "</center>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "\r\n"
						+ "</html>");
				res.getWriter().println("Login Succesful");
				}
			else {
				    res.getWriter().println("unsucefful");
					RequestDispatcher rd = req.getRequestDispatcher("Register.html");
					rd.forward(req, res);
					
					
				}
				
		}
			
			
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
	}

}
