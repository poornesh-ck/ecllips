package edu.training.MavenDemo;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employeee {
	public Employeee() {
		super();
	}
	public Employeee(int eid, String ename, Double esal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}
	
	@Id
	int eid;
	String ename;
	Double esal;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Double getEsal() {
		return esal;
	}
	public void setEsal(Double esal) {
		this.esal = esal;
	}
	

}
