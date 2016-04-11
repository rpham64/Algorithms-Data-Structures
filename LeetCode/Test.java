package LeetCode;

public class Test {

	static int solvePuzzle(int num) {
        
        int numOfHoles = 0;
        
        while (num > 0) {
            
            int lastDigit = num % 10;
            int amount = 0;
            
            switch (lastDigit) {
                
                case 1:
                case 2:
                case 3:
                case 5:
                case 7: 
                	amount = 0;
                	break;
                case 0:
                case 4:
                case 6:
                case 9:
                	amount = 1;
                	break;
                case 8:
                	amount = 2;
                	break;
                
            }
            
            numOfHoles += amount;
            
            num /= 10;
        }

        return numOfHoles;
    }
	
	static String doesCircleExist(String commands) {
		
		char[] listOfCommands = commands.toCharArray();

        // Input Check: L or R
        if (commands.equals("L") || commands.equals("R")) return "YES";

        // Initial positions
        int x = 0;
        int y = 0;
        int direction = 0;	// North
        
        for (int i = 0; i < listOfCommands.length; i++) {
            
            char move = listOfCommands[i];
            
            // If move is left or right, change direction
            if (move == 'R') {
            	direction = (direction + 1) % 4;
            } else if (move == 'L') {
            	direction = (direction + 3) % 4;
            }
            
            else {
            	
            	if (direction == 0) {
            		y++;
            	} else if (direction == 1) {
            		x++;
            	} else if (direction == 2) {
            		y--;
            	} else {
            		x--;
            	}
            	
            }
            
        }
        
        if (x == 0 && y == 0) return "YES";
        
        return "NO";
    }
	
	public static void main(String[] args) {
		
		String test = "hello";
		String[] letters = test.split("");
		
		for (String letter : letters) {
			System.out.println(letter);
		}
		
//		System.out.println("Check: " + letters.toString());
		
	}
	
}
