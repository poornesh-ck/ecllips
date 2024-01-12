package ecommerce.control;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.model.User;
import ecommerce.service.UserService;

/**
 * Servlet implementation class Registercontrol
 */
@WebServlet("/Register")
public class Registercontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registercontrol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("username");
		String d1 =(String)request.getParameter("dob");
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		 Date dob = null;
		try {
			dob =  f.parse(d1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		String ph=request.getParameter("number");
		String s=request.getParameter("invalid");
		User us = new User(uname,dob,ph,email,pass);
		UserService u1=new UserService();
		try {
			u1.userdb(us);
			response.getWriter().println(s);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
