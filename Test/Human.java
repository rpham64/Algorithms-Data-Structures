package Test;

public abstract class Human {

	// Field that's same for all subclasses
	private int numEyes;
	
	// Constructor - Called by all subclasses but cannot instantiate itself
	public Human() {
		numEyes = 2;
		System.out.println("This human has " + numEyes + " eyes");
	}
	
	// Abstract method that must be implemented by all subclasses
	public abstract void goPee();

	// Methods accessible by all subclasses (cannot be implemented differently for each)
	public int getNumEyes() {
		return numEyes;
	}

	public void setNumEyes(int numEyes) {
		this.numEyes = numEyes;
	}
}
