package edu.prodapt.demos;

public class credpojo {

	private int eId;
	private String eName;
	private String eDept;
	private double eSal;
	
	public credpojo(int eId, String eName, String eDept, double eSal) {
		
		this.eId = eId;
		this.eName = eName;
		this.eDept = eDept;
		this.eSal = eSal;
	}
	
	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteDept() {
		return eDept;
	}

	public void seteDept(String eDept) {
		this.eDept = eDept;
	}

	public double geteSal() {
		return eSal;
	}

	public void seteSal(double eSal) {
		this.eSal = eSal;
	}

	
	

}
