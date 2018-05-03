package DesignPatterns.State.ATM;

public class TestATM {

	public static void main(String[] args) {
		ATMMachine machine = new ATMMachine();
		machine.insertCard();
		machine.ejectCard();
		machine.insertCard();
		machine.insertCard();
		machine.insertPin(1234);
		machine.withdrawCash(2000);
	}
}
