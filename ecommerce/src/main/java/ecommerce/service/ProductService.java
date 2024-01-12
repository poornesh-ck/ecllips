package ecommerce.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import ecommerce.model.Cart;
import ecommerce.model.Product;
import ecommerce.repo.DaoClass;

public class ProductService {
	public String addp(Product p) throws SQLException {
		
		
		
			Connection con=DaoClass.getConnection();
		
			PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?)");
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getpName());
			ps.setString(3, p.getpDesc());
			ps.setDouble(4, p.getpPrice());
			ps.setInt(5, p.getpQty());
			int temp=ps.executeUpdate();
			return "Product created";
		
		
		
		
	}
	public  List<Product> viewList() throws SQLException{
		List<Product> l1= new ArrayList<Product>();
		Connection con=DaoClass.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from product");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			l1.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5)));
			
		}
		return l1;
		
		
	}
	public String edit(int id,double price,int pqt)throws SQLException {
		Connection con=DaoClass.getConnection();
		PreparedStatement ps=con.prepareStatement("update  product set price=?, pqty=? where pid=?");
		ps.setDouble(1, price);
		ps.setInt(2, pqt);
		ps.setInt(3, id);
		
		ps.executeUpdate();
		return "djjhd";
		
		
	}
	public String delete(int id) throws SQLException{
		Connection con=DaoClass.getConnection();
		PreparedStatement ps=con.prepareStatement("Delete from product where pid=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		return "djjhd";
		
	}
	public List<Cart> getCartProducts(ArrayList<Cart> cartList) throws SQLException{
		List<Cart> products=new ArrayList<Cart>();
		if(cartList.size()>0) {
			for(Cart item:cartList) {
				Connection con=DaoClass.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from product where pid=?");
				ps.setInt(1, item.getPid());
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Cart row = new Cart();
					row.setPid(rs.getInt("pid"));
					row.setpName(rs.getString("pname"));
					row.setpDesc(rs.getString("pdesc"));
					row.setpPrice(rs.getDouble("price")*item.getQuantity());
					row.setpQty(rs.getInt("pqty"));
					row.setQuantity(item.getQuantity());
					products.add(row);
				}
				
			}
		}
		return products;
	}

	

}
