package inheritance;

public class CreditAccount extends AbstractAccount{

	private double creditLine;
	
	
	public CreditAccount(double creditLine) {
		super();
		this.setCreditLine(creditLine);
	}
	
	public void internalWithdraw(double withdrawalInput) {
		double tempBalance = this.balance - withdrawalInput;
		if (tempBalance < 0) {
			if (Math.abs(tempBalance) > creditLine) {
				throw new IllegalStateException("The account would surpass the creditline from this withdrawal.");
			}
		}
		this.balance = tempBalance;
	}
	
	public void setCreditLine(double creditLine) {
		if (! super.validateValue(creditLine)) {
			throw new IllegalArgumentException("Credit line has to be a non-negative number");
		}
		if (this.balance < 0) {
			if (Math.abs(balance) > creditLine) {
				throw new IllegalStateException("The supplied creditline is too small for the current balance of the account.");
			}
		}
		this.creditLine = creditLine;
	}
	
	public double getCreditLine() {
		return this.creditLine;
	}

}
