package com.creditunion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CUAccounts {
	private List<CUAccount> accounts = new ArrayList<CUAccount>();
	private List<Integer> accountNumbers = new ArrayList<Integer>();
	public List<Integer> getAccountNumbers() {
		return accountNumbers;
	}
	public void setAccountNumbers(List<Integer> accountNumbers) {
		this.accountNumbers = accountNumbers;
	}
	private Map<Integer, CUAccount> accountsMap = new HashMap<Integer,CUAccount>();
	public List<CUAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<CUAccount> accounts) {
		this.accounts = accounts;
	}
	public Map<Integer, CUAccount> getAccountsMap() {
		return accountsMap;
	}
	public void setAccountsMap(Map<Integer, CUAccount> accountsMap) {
		this.accountsMap = accountsMap;
	} 
	
}
