package LeetCode_Medium;

/**
 * There are n bulbs that are initially off. You first turn on 
 * all the bulbs. Then, you turn off every second bulb. On the 
 * third round, you toggle every third bulb (turning on if it's 
 * off or turning off if it's on). For the ith round, you toggle 
 * every i bulb. For the nth round, you only toggle the last bulb. 
 * Find how many bulbs are on after n rounds.

	Example:
	
	Given n = 3. 
	
	At first, the three bulbs are [off, off, off].
	After first round, the three bulbs are [on, on, on].
	After second round, the three bulbs are [on, off, on].
	After third round, the three bulbs are [on, off, off]. 
	
	So you should return 1, because there is only one bulb is on.
 * 
 * @author Rudolf
 *
 */
public class BulbSwitcher_319 {

	/**
     * n = 8
     * 
     * isBulbOn = [off, off, off, off, off, off, off, off]
     * 
     * ROUND 1: [on, on, on, on, on, on, on, on]        
     * ROUND 2: [on, off, on, off, on, off, on, off]    
     * ROUND 3: [on, off, off, off, on, on, on, off]  
     * ROUND 4: [on, off, off, on, on, on, on, on]    
     * ROUND 5: [on, off, off, on, off, on, on, on]    
     * ROUND 6: [on, off, off, on, off, off, on, on]    
     * ROUND 7: [on, off, off, on, off, off, off, on]   
     * ROUND 8: [on, off, off, on, off, off, off, off]  => 2
     */
    public int bulbSwitch(int n) {
        
        /*// Input Check: if n is 0, return 0
        if (n == 0) return 0;
        
        // Base Case: if n is 1, return 1 (only 1 bulb is on)
        if (n == 1) return 1;
        
        // Inductive Step: Assume n>=2
        boolean[] isBulbOn = new boolean[n]; // true = on, false = off
        
        int length = isBulbOn.length;
        
        for (int round = 1; round <= n; round++) {
            
            for (int i = round - 1; i < length; i += round) {
                isBulbOn[i] = !isBulbOn[i];
            }
            
        }
        
        // Count number of "true" in isBulbOn
        int count = 0;
        
        for (boolean isOn : isBulbOn) {
            if (isOn) count++;
        }
        
        return count;*/
        
        return (int) Math.sqrt((long) n);
    }
	
}
