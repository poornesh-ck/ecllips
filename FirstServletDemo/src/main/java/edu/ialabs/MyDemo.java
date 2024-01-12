package edu.ialabs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyDemo extends HttpServlet

{
	
	public void process(HttpServletRequest req,HttpServletResponse res)throws IOException {
		String uName = req.getParameter("userName");
		PrintWriter out= res.getWriter();
		out.println("Hi Heloo Welcome "+uName+" J2EE World");
		out.println("<h1> MEENDUM VARUGA!!! </h1>");
		
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		
		try {
			process(req,res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		
		try {
			process(req,res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
