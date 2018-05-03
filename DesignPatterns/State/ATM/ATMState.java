package DesignPatterns.State.ATM;
/**
 * State class.
 * 
 * Interface containing the possible actions, given the current ATM state.
 * 
 * @author rpham
 *
 */
public interface ATMState {
	
	void insertCard();
	
	void ejectCard();
	
	void insertPin(int pin);
	
	void withdrawCash(int amountToWithdraw);
}
