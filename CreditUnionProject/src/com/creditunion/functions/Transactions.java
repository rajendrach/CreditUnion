package com.creditunion.functions;

import com.creditunion.CUAccounts;

public interface Transactions {
	public void addAccount(String name, String acctOwner, String acctType, double depositAmount, CUAccounts accounts);
	//public CUAccount retrieveAcctDetails();
	public String deposit(int acctNumber, double amount, CUAccounts accounts);
	public String transfer(int fromAcctNumber, int toAcctNumber,double amount, CUAccounts accounts);
	public String withdraw(int acctNumber, double amount, CUAccounts accounts );
}
