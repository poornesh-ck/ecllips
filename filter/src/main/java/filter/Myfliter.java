package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DocumentFilter;

public class Myfliter  extends HttpFilter{
	Connection con =null;
	
	public void init(FilterConfig config) throws ServletException {
		 
		String drivercls=config.getInitParameter("dClass");
		String url=config.getInitParameter("url");
		String uname=config.getInitParameter("userName");
		String pass=config.getInitParameter("password");
		
		try {
			Class.forName(drivercls);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url,uname,pass);
			System.out.println("connection success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String pass=req.getParameter("password");
		String fname=req.getParameter("fname");
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select fname,password from employees where fname= ?;");
			ps.setString(1,fname );
			ResultSet rs=  ps.executeQuery();
			//System.out.println(rs.next());
			if(rs.next()) {
				if(pass.equals(rs.getString(2))) {
					//res.getWriter().println("welcome "+uname);
					
					chain.doFilter(req, res);
					//System.out.println("sjwsjs");
					
				}
				else {
					res.setContentType("text/html");
					req.getRequestDispatcher("index.html").include(req, res);
					//System.out.println("sjwsjs");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//chain.doFilter(req, res);
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
