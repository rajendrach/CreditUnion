package com.creditunion;

import java.util.Random;

import com.creditunion.functions.Transactions;

public class CUTransactionsImpl implements Transactions {
	CUAccountTypes acctTypes = new CUAccountTypes();

	
	@Override
	public void addAccount(String name, String acctOwner, String acctType,
			double depositAmount, CUAccounts accounts) {
		CUAccount newAccount = 	new CUAccount();
	       newAccount.setName(name);
	       newAccount.setAcctOwner(acctOwner);
	       if("checkingIndividual".equals(acctType)){
	       newAccount.setAcctType(acctTypes.CHECKING_INDIVIDUAL_ACCOUNT);
	       }else if("checkingJoint".equals(acctType)){
	           newAccount.setAcctType(acctTypes.CHECKING_JOINT_ACCOUNT);  
	       }else if("moneyMarket".equals(acctType)){
	           newAccount.setAcctType(acctTypes.MONEY_MARKET_ACCOUNT);
	       }
	       newAccount.setAcctBal(depositAmount);
	       Random randomGenerator = new Random();
	       int acctNumber = randomGenerator.nextInt(2000000000);
	       newAccount.setAcctNumber(acctNumber);
	       accounts.getAccountNumbers().add(acctNumber);
	       accounts.getAccounts().add(newAccount);
	       accounts.getAccountsMap().put(acctNumber, newAccount);
	}

	@Override
	public String deposit(int acctNumber, double amount, CUAccounts accounts) {
		CUAccount cuAccount = accounts.getAccountsMap().get(acctNumber);
		if(cuAccount !=null){
		double newAmount = cuAccount.getAcctBal() + amount;
		cuAccount.setAcctBal(newAmount);
		return "Success : Deposit of"+amount+" is completed";
		}else{
			return "Failure: No Account Found";
		}
	}

	@Override
	public String transfer(int fromAcctNumber, int toAcctNumber, double amount,
			CUAccounts accounts) {
		CUAccount fromAcct = accounts.getAccountsMap().get(fromAcctNumber);
		CUAccount toAcct = accounts.getAccountsMap().get(toAcctNumber);
		if(fromAcct != null && toAcct != null){
			if(fromAcct.getAcctBal()< amount){
				return "Failure : No Sufficient Funds";
			}else{
				double newfromAcctBal = fromAcct.getAcctBal() - amount;
				double newtoAcctBal = toAcct.getAcctBal() + amount;
				toAcct.setAcctBal(newtoAcctBal);
				fromAcct.setAcctBal(newfromAcctBal);
				return "Success";
			}
		}else{
		return "Failure : Either From Acct or To Acct doesnt exist";
		}
	}

	@Override
	public String withdraw(int acctNumber, double amount, CUAccounts accounts) {
		CUAccount cuAccount = accounts.getAccountsMap().get(acctNumber);
		if(cuAccount.getAcctType().equals("CIA") || cuAccount.getAcctType().equals("MMA"))
		{
			if (amount> 250){
				return "Failure:Amount Should Not Exceed 250 for an individual account ";
				//Exception e = new Exception("Amount Should Not Exceed 250 for an individual account");
				//throw e;
			}else{
				if(cuAccount.getAcctBal() < amount){
					return "Failure : No Sufficient Funds";
				}else{
				double newBalance = cuAccount.getAcctBal() - amount;
				cuAccount.setAcctBal(newBalance);
				return "Success";
				}
			}
		}
		if(cuAccount.getAcctBal() < amount){
			return "Failure : No Sufficient Funds";
		}else{
		double newBalance = cuAccount.getAcctBal() - amount;
		cuAccount.setAcctBal(newBalance);
		return "Success";
		}
		
	}

}
