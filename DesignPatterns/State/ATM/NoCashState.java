package DesignPatterns.State.ATM;

public class NoCashState implements ATMState {

	private ATMMachine atmMachineContext;
	
	public NoCashState(ATMMachine context) {
		atmMachineContext = context;
	}
	
	@Override
	public void insertCard() {
		System.out.println("No cash available. Please try again later.");
		System.out.println("Your card has been ejected.");
	}

	@Override
	public void ejectCard() {
		System.out.println("No cash available. Please try again later.");
		System.out.println("No card to eject.");
	}

	@Override
	public void insertPin(int pin) {
		System.out.println("No cash available. Please try again later.");
	}

	@Override
	public void withdrawCash(int amountToWithdraw) {
		System.out.println("No cash available. Please try again later.");
	}

}
