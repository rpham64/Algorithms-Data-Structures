package Search;

public class GuessGame {
	
	private int myNum;
	
	public GuessGame(int num) {
		myNum = num;
	}

	/**
	 * @param num
	 * @return
	 * 		0 if same as myNum
	 * 		1 if num is too low
	 * 		-1 if num is too high
	 */
	public int guess(int num) {
		if (myNum == num) {
			System.out.println("Congrats! You got it!");
			return 0;
		}
		if (myNum > num) {
			System.out.println("My number is higher.");
			return 1;
		} else {
			System.out.println("My number is lower.");
			return -1;
		}
	}
	
}
