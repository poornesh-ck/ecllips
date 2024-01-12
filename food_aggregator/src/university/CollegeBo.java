package university;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import food_aggregator.Item;

public class CollegeBo {
	Connection_db DB=new Connection_db();
	
	public void addItem(College item) throws Exception {
		Connection con=DB.getConnection();
	    College.createItems(); 
		PreparedStatement ps =con.prepareStatement("insert into college values (?,?,?,?,?,?,?)");
		ps.setString(1, item.getName());
		ps.setString(2, item.getWebsite());
		ps.setString(3, item.getMobile());
		ps.setString(4, item.getFounder());
		ps.setInt(5, item.getNumberOfDept());
		ps.setString(6, item.getLocation());
		ps.setDate(7, (java.sql.Date) item.getStartingDate());
		
		
		
		
		ps.executeUpdate();
	}
	
	
	public List<College>findCollege(List<String>nameList) throws Exception{
		Connection con=DB.getConnection();
		List<College> TypeList=new  ArrayList<>();
		PreparedStatement ps =con.prepareStatement("select * from college where name=?");
		for(String s:nameList) {
			ps.setString(1,s);
		}
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			TypeList.add(new College(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getDate(7)));;
		}
		return TypeList;
	}
	public List<College>findCollege(String location)throws Exception{
		Connection con=DB.getConnection();
		List<College> TypeList=new  ArrayList<>();
		PreparedStatement ps =con.prepareStatement("select * from college where type=?");
		ps.setString(1,location);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			TypeList.add(new College(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getDate(7)));
		}
		return TypeList;
	}
	public List<College>findCollege(Date startingDate) throws Exception{
		Connection con=DB.getConnection();
		List<College> TypeList=new  ArrayList<>();
		PreparedStatement ps =con.prepareStatement("select * from college where type=?");
		ps.setDate(1,(java.sql.Date) startingDate);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			TypeList.add(new College(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getDate(7)));
		}
		return TypeList;
		
	}

}
