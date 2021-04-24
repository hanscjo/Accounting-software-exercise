package inheritance;

public class SavingsAccount2 extends AbstractAccount{
	
	private int maxWithdrawals;
	private int currentWithdrawals;
	private double fee;
	
	public SavingsAccount2(int withdrawals, double fee) {
		super();
		this.maxWithdrawals = withdrawals;
		this.currentWithdrawals = 0;
		this.fee = fee;
	}
	
	public void internalWithdraw(double withdrawalInput) {
		double modifiedWithdrawalInput = withdrawalInput;
		this.currentWithdrawals++;
		if (currentWithdrawals > maxWithdrawals) {
			modifiedWithdrawalInput += this.fee;
		}
		double tempBalance = this.balance - modifiedWithdrawalInput;
		if (! super.validateValue(tempBalance)) {
			throw new IllegalStateException("The withdrawed amount would leave the balance of the accoutn in the negative.");
		}
		this.balance = tempBalance;
		
	}

}
