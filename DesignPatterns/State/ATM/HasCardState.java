package DesignPatterns.State.ATM;

public class HasCardState implements ATMState {
	
	private ATMMachine atmMachineContext;
	
	public HasCardState(ATMMachine context) {
		atmMachineContext = context;
	}

	@Override
	public void insertCard() {
		System.out.println("Cannot insert more than one card at a time.");
	}

	@Override
	public void ejectCard() {
		System.out.println("Your card has been ejected.");
		
		// Change state to NoCardState.
		ATMState noCardState = atmMachineContext.getNoCardState();
		atmMachineContext.setState(noCardState);
	}

	@Override
	public void insertPin(int pin) {
		if (pin == 1234) {
			// Valid PIN, so change to HasPinState.
			ATMState hasPinState = atmMachineContext.getHasPinState();
			atmMachineContext.setState(hasPinState);
		} else {
			// Invalid PIN. Eject card.
			System.out.println("PIN number is incorrect. Ejecting card.");
			ejectCard();
		}
	}

	@Override
	public void withdrawCash(int amountToWithdraw) {
		System.out.println("Please insert a valid PIN before withdrawing cash.");
	}
}
