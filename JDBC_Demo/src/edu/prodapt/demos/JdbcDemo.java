package edu.prodapt.demos;

import java.sql.*;
import java.util.*;

public class JdbcDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt", "root", "root");
//	 Statement stmt = con.createStatement();
	 //int temp = stmt.executeUpdate("insert into student values ("+sid+" ,'name',+"+marks+")");
//	System.out.println("Student inserted Success");
	 	/*ResultSet rs = stmt.executeQuery("select * from student where sname='XYZ'");
	 	System.out.println("SID  Name  Marks");
	 	System.out.println("-----------------------------");
	 	while(rs.next())
	 	{
	 		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt("marks"));
	 	}*/
	 	
//	 	System.out.println("Enter the student id");
//	 	int sid=sc.nextInt();
//	 	System.out.println("Enter the name");	
//	 	String sname= sc.next();
	 	System.out.println("Enter the marks");
	 	int marks= sc.nextInt();
	 	//System.out.println("Enter the name");
	 	//String snamef=sc.next();
	 	
	 	PreparedStatement ps = con.prepareStatement("delete from student where marks=?");
	 	//PreparedStatement ps = con.prepareStatement("DELETE * FROM student WHERE sname=?");
	 	//ps.setString(2, snamef);
	 	//ResultSet rs = ps.executeQuery();
	 	//ps.setInt(1, sid);
	 	//ps.setString(2, sname);
	 	ps.setInt(1, marks);
	 	ps.executeUpdate();
	 	
	 	
	 	
	 	
	 	
	 	
	 	
		/*
		 * while(rs.next()) {
		 * System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)); }
		 */
	 	
		
		}
		catch(ClassNotFoundException| SQLException e)
		{
			System.out.println(e);
		}
		
		
	}

}
