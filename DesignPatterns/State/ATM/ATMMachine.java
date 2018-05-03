package DesignPatterns.State.ATM;

/**
 * Context class.
 * 
 * Contains the State references and methods that change the ATM machine's current state.
 * 
 * @author rpham
 *
 */
public class ATMMachine {

	private static final int CASH_AMOUNT = 2000;
	
	private ATMState currentState;  // Current state of ATM machine.
	
	// ATMState subclasses
	private ATMState hasCardState;
	private ATMState noCardState;
	private ATMState hasPinState;
	private ATMState noCashState;
	
	private int totalCash;  // Amount of cash in ATM.
	
	public ATMMachine() {
		// Initialize ATMState subclasses
		hasCardState = new HasCardState(this);
		noCardState = new NoCardState(this);
		hasPinState = new HasPinState(this);
		noCashState = new NoCashState(this);
		
		setState(noCardState);  // Set default state to NoCardState.
		
		totalCash = CASH_AMOUNT;
	}
	
	public void insertCard() {
		currentState.insertCard();
	}
	
	public void ejectCard() {
		currentState.ejectCard();
	}
	
	public void insertPin(int pin) {
		currentState.insertPin(pin);
	}
	
	public void withdrawCash(int amountToWithdraw) {
		currentState.withdrawCash(amountToWithdraw);
	}
	
	public void setState(ATMState state) {
		currentState = state;
		
		// Print initial message depending on state.
		if (state instanceof NoCardState) {
			System.out.println("Please insert your card.");
		} else if (state instanceof HasCardState) {
			System.out.println("Please input your PIN number.");
		} else if (state instanceof HasPinState) {
			System.out.println("Please specify how much money you would like to withdraw.");
		} else if (state instanceof NoCashState) {
			System.out.println("Sorry. This ATM machine has no cash.");
		}
	}
	
	public int getCash() {
		return totalCash;
	}
	
	public void setCash(int cash) {
		totalCash = cash;
	}
	
	public ATMState getHasCardState() {
		return hasCardState;
	}

	public ATMState getNoCardState() {
		return noCardState;
	}

	public ATMState getHasPinState() {
		return hasPinState;
	}

	public ATMState getNoCashState() {
		return noCashState;
	}
}
