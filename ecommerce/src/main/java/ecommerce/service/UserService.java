package ecommerce.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.model.Product;
import ecommerce.model.User;
import ecommerce.repo.DaoClass;

public class UserService {
	public String userdb(User u) throws SQLException {
		Connection con=DaoClass.getConnection();
		
		PreparedStatement ps=con.prepareStatement("insert into userdb values(?,?,?,?,?,?)");
		ps.setString(1, u.getUsername());
	    java.sql.Date d1=new java.sql.Date(u.getDob().getTime());

        ps.setDate(2,d1);
		
		ps.setString(3, u.getNumber());
		ps.setString(4, u.getEmail());
		ps.setString(5, u.getPassword());
		ps.setString(6, "invalid");
		int temp=ps.executeUpdate();
		return "Product created";
	} 
	public  List<User> uList() throws SQLException{
		List<User> l1= new ArrayList<User>();
		Connection con=DaoClass.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from userdb ");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			l1.add(new User(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			
		}
		return l1;
		
		
	}
	public String Udelete(String uname) throws SQLException{
		Connection con=DaoClass.getConnection();
		PreparedStatement ps=con.prepareStatement("Delete from userdb where username=?");
		PreparedStatement p=con.prepareStatement("Delete from activeuser where username=?");
		ps.setString(1, uname);
		p.setString(1, uname);
		ps.executeUpdate();
		p.executeUpdate();
		return "djjhd";
		
	}
	public String updatedb(String uname) throws SQLException {
		Connection con=DaoClass.getConnection();
		PreparedStatement ps=con.prepareStatement("Insert into activeuser(username,dob,number,email,password) select username,dob,number,email,password from userdb where username=?");
		ps.setString(1, uname);
		ps.executeUpdate();
		return "djjhd";
		
	}
	public String udb(String uname) throws SQLException {
		Connection con=DaoClass.getConnection();
		PreparedStatement ps=con.prepareStatement("Delete from activeuser where username=?");
		ps.setString(1, uname);
		ps.executeUpdate();
		return "djjhd";
		
	}
	public Boolean is_valid(String email,String pass) throws SQLException {
		Connection con=DaoClass.getConnection();
		PreparedStatement ps=con.prepareStatement("select password from activeuser where email=? ");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			if(rs.getString(1).equals(pass)) {
				return true;
				
			}
		}
		return false;
		
	}
	

	public List<Product> custsearch(String pname) throws SQLException {

		Connection con=DaoClass.getConnection();

	        PreparedStatement ps =con.prepareStatement("select * from product where pname=?");

	        ps.setString(1, pname);

	        ResultSet rs=ps.executeQuery();

	        List<Product> prolist=new ArrayList<>();

	        while(rs.next()) {

	            prolist.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));

	        }

	        System.out.println(prolist);

	        

	        return prolist;

	        

	        

	    }
	

}

