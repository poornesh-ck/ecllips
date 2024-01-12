package university;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_db {
	 Connection con;

	public  Connection getConnection() {
		
		// TODO Auto-generated method stub
		
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");
			//System.out.println("connection success");
			
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		
		return con;
	
	
		
				
	}
	public void  closeConnection() {
			
			try {
				
					con.close();
				
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}


