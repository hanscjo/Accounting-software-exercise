package inheritance;

public class DebitAccount extends AbstractAccount{

	
	public void internalWithdraw(double withdrawalInput) {
		double tempBalance = this.balance - withdrawalInput;
		if (! validateValue(tempBalance)) {
			throw new IllegalStateException("Withdrawing this much leaves a negative balance");
		}
		
		this.balance = tempBalance;
		
	}

}
