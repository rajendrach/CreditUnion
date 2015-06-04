package com.creditunion;

import java.util.HashSet;
import java.util.Set;

public class CUAccount {
	private String Name;
	private String AcctType;
	private String AcctOwner;
	private double AcctBal;
	private int AcctNumber;
	
	public Set<Integer> sampleSet = new HashSet<Integer>();

	public int getAcctNumber() {
		return AcctNumber;
	}
	public void setAcctNumber(int acctNumber) {
		AcctNumber = acctNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAcctType() {
		return AcctType;
	}
	public void setAcctType(String acctType) {
		AcctType = acctType;
	}
	public String getAcctOwner() {
		return AcctOwner;
	}
	public void setAcctOwner(String acctOwner) {
		AcctOwner = acctOwner;
	}
	public double getAcctBal() {
		return AcctBal;
	}
	public void setAcctBal(double acctBal) {
		AcctBal = acctBal;
	}
}
