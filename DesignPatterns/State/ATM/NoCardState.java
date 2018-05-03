package DesignPatterns.State.ATM;

public class NoCardState implements ATMState {
	
	private ATMMachine atmMachineContext;

	public NoCardState(ATMMachine context) {
		atmMachineContext = context;
	}
	
	@Override
	public void insertCard() {
		// Inserted card, so change to HasCardState.
		atmMachineContext.setState(atmMachineContext.getHasCardState());
	}

	@Override
	public void ejectCard() {
		System.out.println("No card to eject.");
	}

	@Override
	public void insertPin(int pin) {
		System.out.println("Please insert your card before entering your PIN.");
	}

	@Override
	public void withdrawCash(int amountToWithdraw) {
		System.out.println("Please insert your card before withdrawing cash.");
	}

}
