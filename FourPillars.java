package com.oops;

//ABSTRACTION
//Abstract class representing a Bank Account
abstract class BankAccount {
	// Abstract methods to get account number and IFSC code
	abstract long getaccNum();
	abstract String getifscNum();
 
	// Abstract methods for deposit and withdrawal
	abstract void depositMoney();
	abstract void withdrawMoney();
}


//INHERITANCE
//Subclass representing a Saving Bank Account
class SavingBank extends BankAccount {
	
	//ENCAPSULATION	
	// Private attributes for account number and IFSC code
	private long accNum;
 	private String ifscNum;
 
 	// Constructor to initialize account number and IFSC code
 	public SavingBank(long accNum, String ifscNum) {
     this.accNum = accNum;
     this.ifscNum = ifscNum;        
 	}
 
 	// Implementation of abstract methods to get account number and IFSC code
 	public long getaccNum() {
     return accNum;
 	}
 
 	public String getifscNum() {
     return ifscNum;
 	}
 
 	// Implementation of abstract methods for deposit and withdrawal
 	public void depositMoney() {
    System.out.println("Money is Deposited in Saving Bank Account");
 	}
 
 	public void withdrawMoney() {
    System.out.println("Money is Withdraw From Saving Bank Account");
 	}
}

//INHERITANCE
//Subclass representing a Current Bank Account
class CurrentBank extends BankAccount {
 
//ENCAPSULATION
	// Attributes for account number and IFSC code
	private long accNum;
 	private String ifscNum;
 
 	// Constructor to initialize account number and IFSC code
 	public CurrentBank(long accNum, String ifscNum) {
    this.accNum = accNum;
    this.ifscNum = ifscNum;
 	}
 
 	// Implementation of abstract methods to get account number and IFSC code
 	public long getaccNum() {
    return accNum;
 	}
 
 	public String getifscNum() {
    return ifscNum;
 	}
 
 	// Implementation of abstract methods for deposit and withdrawal
 	public void depositMoney() {
    System.out.println("Money is Deposited in Current Bank Account");
 	}
 
 	public void withdrawMoney() {
    System.out.println("Money is Withdraw From Current Bank Account");
 	}
}

//Utility class to demonstrate polymorphism
class RBI {
	// Static method to permit banking operations on a BankAccount object
 public static void permit(BankAccount ba) {
	 // Polymorphic behavior: calling methods on BankAccount reference
     System.out.println(ba.getaccNum());
     System.out.println(ba.getifscNum());
     
     ba.depositMoney();// Polymorphism: calling subclass's overridden method
     ba.withdrawMoney();// Polymorphism: calling subclass's overridden method
 }
}

//Class to demonstrate the four pillars of object-oriented programming
class FourPillars {
 public static void main(String[] args) {
	 // Create instances of various bank account types
     SavingBank sb = new SavingBank(1100223344 , "SBFC1122");
     CurrentBank cb = new CurrentBank(2100113344 , "CBFC2233");
  
     
    // Demonstrate polymorphism by passing different types of bank accounts to the RBI
     RBI.permit(sb); // Polymorphism: passing subclass object to method expecting superclass reference
     System.out.println();
     
     RBI.permit(cb); // Polymorphism: passing subclass object to method expecting superclass reference
     System.out.println();
     

 }
}

