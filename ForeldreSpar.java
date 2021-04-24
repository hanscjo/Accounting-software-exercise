package inheritance;

public class ForeldreSpar extends SavingsAccount{
	
	private int maxWithdrawals;
	private int currentWithdrawals;

	public ForeldreSpar(double interestRate, int maxWithdrawals) {
		super(interestRate);
		this.maxWithdrawals = maxWithdrawals;
		this.currentWithdrawals = maxWithdrawals;
	}
	
	public void withdraw(double withdrawalInput) {
		if (! (currentWithdrawals > 0)) {
			throw new IllegalStateException("There are no remaining withdrawals for this year.");
		}
		super.withdraw(withdrawalInput);
		this.currentWithdrawals--;
	}
	
	int getRemainingWithdrawals() {
		return this.currentWithdrawals;
	}
	
	void endYearUpdate() {
		super.endYearUpdate();
		this.currentWithdrawals = maxWithdrawals;
	}

}
