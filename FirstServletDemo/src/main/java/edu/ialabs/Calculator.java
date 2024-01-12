package edu.ialabs;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet
 {
	
		
		public void process(HttpServletRequest req,HttpServletResponse res)throws IOException {
			PrintWriter out= res.getWriter();
			String number1 = req.getParameter("n1");
			String number2 = req.getParameter("n2");
			int n1= Integer.parseInt(number1);
			int n2=Integer.parseInt(number2);
			String result=null;
			String calop=req.getParameter("op");
			
			switch(calop) {
			case "add":
				result="<center>The sum of two values is"+(n1+n2);break;
			case "sub":
				result="<center>The sum of two values is"+(n1-n2);break;
			case "mul":
				result="<center>The sum of two values is"+(n1*n2);break;
			case "div":
				result="<center>The sum of two values is"+(n1/n2);break;	
			
			}
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "</head>\r\n"
					+ "<body style=\"background-color:  cyan;\">\r\n"
					+ "	<center>\r\n"
					+ "<h1>Vanakkam!!!</h1>\r\n"
					+ "<form action=\"./myCal\" method=\"post\">\r\n"
					+ "	<label>Number 1</label><input type=\"number\" name=\"n1\" placeholder=\"Enter first number\"><br><br>\r\n"
					+ "	<label>Number 2</label><input type=\"number\" name=\"n2\"  placeholder=\"Enter second number\"><br>\r\n"
					+ "	<br>\r\n"
					+ "	<input type=\"radio\" value=\"add\" name=\"op\" >Addition\r\n"
					+ "\r\n"
					+ "<input type=\"radio\" value=\"sub\" name=\"op\" >Subtraction\r\n"
					+ "<input type=\"radio\" value=\"mul\" name=\"op\" >Multiplication\r\n"
					+ "<input type=\"radio\" value=\"div\" name=\"op\" >Division<br>\r\n"
					+ "\r\n"
					+ "<input type=\"submit\"  value=\"Calculate\"   ><br><br>\r\n"
					+ "</form>\r\n"
					+ "</center>\r\n"
					+ "</body>\r\n"
					+ "</html>"+result);
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
