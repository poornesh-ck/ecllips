package ecommerce.model;

public class Product {
	int pid;
	String pName;
	String pDesc;
	
	Double pPrice;
	int pQty;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public Double getpPrice() {
		return pPrice;
	}
	public void setpPrice(Double pPrice) {
		this.pPrice = pPrice;
	}
	public int getpQty() {
		return pQty;
	}
	public void setpQty(int pQty) {
		this.pQty = pQty;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pName=" + pName + ", pDesc=" + pDesc + ", pPrice=" + pPrice + ", pQty=" + pQty
				+ "]";
	}
	public Product(int pid, String pName, String pDesc, Double pPrice, int pQty) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.pDesc = pDesc;
		this.pPrice = pPrice;
		this.pQty = pQty;
	}
	public Product() {
		super();
	}
	

}
