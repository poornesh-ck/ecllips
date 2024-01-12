package ecommerce.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DaoClass {

	public static Connection getConnection() {
		
        Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt", "root", "hr");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return con;
		
		
	}

}
