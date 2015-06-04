package com.creditunion.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.creditunion.CUAccount;
import com.creditunion.CUAccountTypes;
import com.creditunion.CUAccounts;
import com.creditunion.CUTransactionsImpl;
import com.creditunion.functions.Transactions;



public class CUTransactionsTest {
	Transactions transaction;
	CUAccounts accounts;
	
	

	@Before
	public void setUp() throws Exception {
		 transaction = new CUTransactionsImpl();
		 accounts = new CUAccounts();
		 createDefaultAccount();
		 
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testAddAccount() {
		
		transaction.addAccount("Bofa", "Rajendra", "checking", 1000, accounts);
		
		assertEquals(4, accounts.getAccounts().size());
		
		transaction.addAccount("Bofa", "Ravi", "checkingIndividual", 1000, accounts);
		transaction.addAccount("Bofa", "Rahul", "checkingJoint", 1000, accounts);
		transaction.addAccount("Bofa", "Ajay", "moneyMarket", 1000, accounts);
		//fail("Not yet implemented");
		assertEquals(7, accounts.getAccounts().size());
	}

	
	@SuppressWarnings("deprecation")
	@Test
	public void testDeposit() {
		
		//fail("Not yet implemented");
		transaction.deposit(0002, 1000, accounts);
		assertEquals(1700, (int)accounts.getAccountsMap().get(0002).getAcctBal());
	}
	
	@Test
	public void testTransfer(){
		transaction.transfer(002, 001, 100, accounts);
		assertEquals(600, (int)accounts.getAccountsMap().get(0002).getAcctBal());
		assertEquals(600, (int)accounts.getAccountsMap().get(0001).getAcctBal());

	}
	
	@Test
	public void testWithDraw(){
		String message = transaction.withdraw(001, 300, accounts);
		assertEquals("Failure:Amount Should Not Exceed 250 for an individual account ", message);
	}
	private void createDefaultAccount(){
		CUAccount account1 = new CUAccount();
		CUAccount account2 = new CUAccount();
		CUAccount account3 = new CUAccount();
		account1.setAcctBal(500);
		account1.setAcctNumber(0001);
		account1.setAcctOwner("Ramesh");
		account1.setAcctType(CUAccountTypes.CHECKING_INDIVIDUAL_ACCOUNT);
		account1.setName("Bofa");
		account2.setAcctBal(700);
		account2.setAcctNumber(0002);
		account2.setAcctOwner("Roy");
		account2.setAcctType(CUAccountTypes.CHECKING_JOINT_ACCOUNT);
		account2.setName("Bofa");
		account3.setAcctBal(500);
		account3.setAcctNumber(0003);
		account3.setAcctOwner("John");
		account3.setAcctType(CUAccountTypes.MONEY_MARKET_ACCOUNT);
		account3.setName("Bofa");
		accounts.getAccounts().add(account1);
		accounts.getAccounts().add(account2);
        accounts.getAccounts().add(account3);
        accounts.getAccountsMap().put(001, account1);
        accounts.getAccountsMap().put(002, account2);
        accounts.getAccountsMap().put(003, account3);


	}

}
