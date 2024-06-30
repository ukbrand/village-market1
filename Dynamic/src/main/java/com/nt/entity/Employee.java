package com.nt.entity;

public class Employee {

	private int ID; 
	private String NAME;
	private int PRODUCT_ID;
	private int PRICE;
	private int STOCK;
	private String TYPE1;
 
	
	
	 
	
	public Employee(int iD, String nAME, int pRODUCT_ID, int pRICE, int sTOCK, String tYPE1) {
		super();
		ID = iD;
		NAME = nAME;
		PRODUCT_ID = pRODUCT_ID;
		PRICE = pRICE;
		STOCK = sTOCK;
		TYPE1 = tYPE1;
	}




	public int getID() {
		return ID;
	}




	public void setID(int iD) {
		ID = iD;
	}




	public String getNAME() {
		return NAME;
	}




	public void setNAME(String nAME) {
		NAME = nAME;
	}




	public int getPRODUCT_ID() {
		return PRODUCT_ID;
	}




	public void setPRODUCT_ID(int pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}




	public int getPRICE() {
		return PRICE;
	}




	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}




	public int getSTOCK() {
		return STOCK;
	}




	public void setSTOCK(int sTOCK) {
		STOCK = sTOCK;
	}




	public String getTYPE1() {
		return TYPE1;
	}




	public void setTYPE1(String tYPE1) {
		TYPE1 = tYPE1;
	}




	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", NAME=" + NAME + ", PRODUCT_ID=" + PRODUCT_ID + ", PRICE=" + PRICE + ", STOCK="
				+ STOCK + ", TYPE1=" + TYPE1 + "]";
	}




	




//	@Override
//	public boolean equals(Object obj) {
//		Employee e = (Employee) obj;
//		if (this.id == e.id && this.name == e.name && this.sal == e.sal)
//			return true;
//		else
//			return false;
//
//	}
	
	 
}
