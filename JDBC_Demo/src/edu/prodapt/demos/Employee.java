package edu.prodapt.demos;
import java.util.*;
import java.sql.*;
public class Employee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root");
			boolean key=true;
			while(key) {
				System.out.println("---Select Option---");
				System.out.println("1.Create Employee");
				System.out.println("2.Read Employee");
				System.out.println("3.Update Employee");
				System.out.println("4.Delete Employee");
				System.out.println("5.Display Employee");
				int n=sc.nextInt();
				switch(n) {
				case 1:
					Function.createEmployee(con);
					break; 
				case 2: 
					Function.serachEmployee(con); 
					break;
				 case 3: 
					 Function.updateEmployee(con); 
				 	break; 
				 case 4: 
					 Function.deleteEmployee(con);
				 break; 
				  case 5: Function.displayEmployee(con); break;
				 
					 
				default:
					key=false;
					System.out.println("Exiting...");	
					break;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
