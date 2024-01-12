package edu.prodapt.demos;
import java.util.*;
import java.sql.*;

public class Function {
	static Scanner sc= new Scanner(System.in);
	public static void createEmployee(Connection con) throws SQLException {
		System.out.println("Enter Employee Id:");
		int id=sc.nextInt();
		System.out.println("Enter Employee Name:");
		String name=sc.next();
		System.out.println("Enter Employee Department:");
		String dept=sc.next();
		System.out.println("Enter Employee Salary:");
		double sal=sc.nextDouble();
		try {
			PreparedStatement ps=con.prepareStatement("insert into employeedb values(?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setString(3, dept);
			ps.setDouble(4, sal);
			ps.executeUpdate();
			System.out.println("Employee created successfuly");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void serachEmployee(Connection con)throws Exception {
		System.out.println("Enter EmployeeID");
		int id=sc.nextInt();
		try(PreparedStatement ps=con.prepareStatement("select * from employeedb where Eid=?")){
			
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				credpojo employee=initializeData(rs);
				System.out.println("Employee Details");
				System.out.println("Employee ID:"+employee.geteId());
				System.out.println("Employee Name:"+employee.geteName());
				System.out.println("Employee Department:"+employee.geteDept());
				System.out.println("Employee Salary:"+employee.geteSal());
			}
		
			else
				System.out.println("Employee Not Found with ID:"+id);
				
			
			
		}
	}
	
	public static void updateEmployee(Connection con)throws Exception{
		
		  System.out.println("Enter Employee Id:"); 
		  int id=sc.nextInt();
		  
		  int choice;
		  do {
			  System.out.println("Choose the attribute to update");
			  System.out.println("1.Name");
			  System.out.println("2.Department");
			  System.out.println("3.Salary");
			  String col="";
		  choice=sc.nextInt();
		  switch(choice)
		  {
		  case 1:
			  col="ename";
			  break;
		  case 2:
			  col="edept";
			  break;
		  case 3:
			  col="esal";
			  break;
		  default:
			  System.out.println("Invalid choice");
			  return;
			}
		
		  System.out.println("Enter value to update");
		  String updateval=sc.next();
		  
		
		try (PreparedStatement ps=con.prepareStatement("update employeedb set "+col+" =? where Eid=?")){
			
			ps.setString(1, updateval);
			ps.setInt(2,id);
			
			int temp=ps.executeUpdate();
			if(temp==1) {
			System.out.println("Employee details update succesfully");
			}
			else {
				System.out.println("Employee Not Found with ID:"+id);
				
			}
		}
		
		  }while(choice!=4);
		
	}
	
	public static void deleteEmployee(Connection con)throws SQLException
	{
		System.out.println("Enter Employee Id:");

		int n=sc.nextInt();
		try(PreparedStatement ps=con.prepareStatement("delete from employeedb where Eid=?"))
		{
			ps.setInt(1, n);
			int temp=ps.executeUpdate();
			if(temp==1) 
			System.out.println("Employee Details deleted successfully");
			else
				System.out.println("Employee Not Found with ID:"+n);
				
		}
	}
	
	public static void displayEmployee(Connection con)throws SQLException{
		try(PreparedStatement ps=con.prepareStatement("select * from employeedb")){
			ResultSet rs=ps.executeQuery();
			
			if(!rs.next())
			{
				System.out.println("Empty Database");
				return;
			}
			else {
				System.out.println("Emp Id    |  Emp Name   |  Emp Dept   | Emp Salary");
				System.out.println("--------------------------------------------------");
			do
			{
				credpojo employee=initializeData(rs);
				
				System.out.printf("%-10d| %-12s| %-12s| %-10s",employee.geteId(),employee.geteName(),employee.geteDept(),employee.geteSal());
			    System.out.println();
			}while(rs.next());
			}
				
		}
	}
	
	public static credpojo initializeData(ResultSet rs)throws SQLException{
		int eid=rs.getInt("eid");
		String ename=rs.getString("ename");
		String edept=rs.getString("edept");
		double esal=rs.getDouble("esal");
		return new credpojo(eid,ename,edept,esal);
	}

}
