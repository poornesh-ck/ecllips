package edu.in;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
 * Servlet implementation class Registration
 */
@WebServlet(
		urlPatterns = { "/reg" }, 
		initParams = { 
				@WebInitParam(name = "dclass", value = "com.mysql.cj.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/prodapt"), 
				@WebInitParam(name = "uname", value = "root"), 
				@WebInitParam(name = "pass", value = "root")
		})
public class Registration extends HttpServlet {
	Connection con =null;
	
	public void init(ServletConfig config) throws ServletException {
		//config = getServletConfig();
		String drivercls=config.getInitParameter("dclass");
		String url=config.getInitParameter("url");
		String uname=config.getInitParameter("uname");
		String pass=config.getInitParameter("pass");
		try {
			Class.forName(drivercls);
			System.out.println("sfs");
			con=DriverManager.getConnection(url,uname,pass);
			System.out.println("ddddddddddddd232323");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		// TODO Auto-generated method stub
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			
			
			PreparedStatement ps =con.prepareStatement("insert into employees values(?,?,?,?,?)");
			ps.setString(1, req.getParameter("fname"));
			ps.setString(2, req.getParameter("lname"));
			ps.setString(3, req.getParameter("email"));
			ps.setString(4, req.getParameter("number"));
			ps.setString(5, req.getParameter("password"));
			int temp=ps.executeUpdate();
			//res.getWriter().println("<h1>Employees registration successful</h1>");
			if(temp>0) {
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.forward(req, res);}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
