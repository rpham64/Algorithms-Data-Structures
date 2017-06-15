package Test;

public class AbstractTest {

	public static void main(String[] args) {
		
		Human boy = new Male();
		Human girl = new Female();
		
		boy.goPee();
		girl.goPee();
	}
}
