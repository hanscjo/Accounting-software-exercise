package inheritance;

public class BSU extends SavingsAccount{
	
	private double depositLimit;
	private double depositedValue;

	public BSU(double interestRate, double depositLimit) {
		super(interestRate);
		this.depositLimit = depositLimit;
	}
	
	double getTaxDeduction() {
		return depositedValue * 0.2;
	}
	
	public void deposit(double balanceInput) {
		if ((this.depositedValue + balanceInput) > depositLimit) {
			throw new IllegalStateException("The deposited value breaks the annual limit of deposit for this account.");
		}
		super.deposit(balanceInput);
		this.depositedValue += balanceInput;
	}
	
	public void withdraw(double withdrawalInput) {
		if (withdrawalInput > this.depositedValue) {
			throw new IllegalStateException("One may not withdraw more than what has been deposited this year.");
		}
		super.withdraw(withdrawalInput);
		this.depositedValue -= withdrawalInput;
	}
	
	void endYearUpdate() {
		super.endYearUpdate();
		this.depositedValue = 0;
	}

}
