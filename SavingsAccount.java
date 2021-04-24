package inheritance;

public class SavingsAccount implements Account {
	
	private double balance;
	private double interestRate;
	
	public SavingsAccount(double interestRate) {
		this.setInterestRate(interestRate);
		this.balance = 0;
	}
	
	void endYearUpdate() {
		this.balance += this.balance*this.interestRate;
	}
	
	public void deposit(double balanceInput) {
		if (! (validateValue(balanceInput))) {
			throw new IllegalArgumentException("The deposited value cannot be negative");
		}
		this.balance += balanceInput;
	}

	public void withdraw(double withdrawalInput) {
		if (! validateValue(withdrawalInput)) {
			throw new IllegalArgumentException("The withdrawed amount cannot be negative");
		}
		
		double tempBalance = this.balance - withdrawalInput;
		if (! validateValue(tempBalance)) {
			throw new IllegalStateException("Withdrawing this much leaves a negative balance");
		}
		
		this.balance = tempBalance;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public boolean validateValue(double value) {
		return value >= 0;
	}
	
	public void setInterestRate(double interestRate) {
		if (! (validateValue(interestRate))) {
			throw new IllegalArgumentException("The set interest-rate cannot be negative");
		} 
		this.interestRate = interestRate;
	}

}
