import java.util.concurrent.TimeUnit;

public class Task1 {

	/**
	 * Create diff int, cost int
	 * Calculate difference between E and L
	 * 
	 * Add 2 to cost (default)
	 * If diff is greater than 60, add 3
	 * Subtract 60 from diff
	 * Calculate number of hours. Multiply by cost per hour (4)
	 * Add 4 for leftover
	 * 
	 * @param E
	 * @param L
	 * @return
	 */
	public static int solution(String E, String L) {
		
		int cost = 0;
		int duration;
		
		int EToMins = toMins(E);
		int LToMins = toMins(L);
		
		// Time duration of parking
		duration = LToMins - EToMins;
		
		// Entrance fee
		cost += 2;
		
		// Cost for 1st full or partial hour
		if (duration > 0) {
			cost += 3;
		}
		
		// Check: duration longer than 1 hour
		if (duration <= 60) return cost;
		
		// Calculate cost for each successive full or partial hour ($4/hr)
		duration -= 60;
		
		int hours = duration/60;
		int mins = duration - hours*60;
		
		cost += hours*4;
		
		if (mins > 0 && mins < 60) {
			cost += 4;
		}
		
		return cost;
	}
	
	private static int toMins(String s) {
	    String[] hourMin = s.split(":");
	    int hour = Integer.parseInt(hourMin[0]);
	    int mins = Integer.parseInt(hourMin[1]);
	    int hoursInMins = hour * 60;
	    return hoursInMins + mins;
	}
	
	public static void main(String[] args) {
		
		/*String test = "10:00";
		String test2 = "13:21";
		
		int testMins = toMins(test);
		int test2Mins = toMins(test2);
		
		int diff = test2Mins - testMins;
		
		System.out.println("Test: " + toMins(test));
		System.out.println("Test2: " + toMins(test2));
		
		System.out.println("Diff: " + diff);
		
		System.out.println("# of hours: " + diff/60);
		System.out.println("# of minutes: " + (diff - (diff/60)*60));*/
		
		System.out.println("First: " + solution("10:00", "13:21"));
		System.out.println("Second: " + solution("09:42", "11:42"));
		
	}
	
}
