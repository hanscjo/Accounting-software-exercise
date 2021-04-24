package inheritance;

public abstract class AbstractAccount implements Account{

	protected double balance;
	
	public AbstractAccount() {
		this.balance = 0;
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
		internalWithdraw(withdrawalInput);
	}
	
	public abstract void internalWithdraw(double withdrawalInput);

	public double getBalance() {
		return this.balance;
	}
	
	public boolean validateValue(double value) {
		return value >= 0;
	}

}
