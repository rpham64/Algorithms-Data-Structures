package DesignPatterns.State.ATM;

public class HasPinState implements ATMState {
	
	private ATMMachine atmMachineContext;
	
	public HasPinState(ATMMachine context) {
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
		System.out.println("A correct PIN has already been inserted and confirmed.");
	}

	@Override
	public void withdrawCash(int amountToWithdraw) {
		int currentCash = atmMachineContext.getCash();
		
		if (currentCash < amountToWithdraw) {
			System.out.println("Sorry, but this ATM machine does not have enough cash. Please try again later.");
		} else {
			// Able to withdraw cash, so subtract amount from total cash and eject card.
			atmMachineContext.setCash(atmMachineContext.getCash() - amountToWithdraw);
			System.out.println("Please collect your cash. Thank you.");
		}
		
		// ATM transaction complete, so eject card.
		ejectCard();
	}

}
