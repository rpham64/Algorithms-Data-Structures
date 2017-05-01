package Strings;

/**
 * You are given a string representing an attendance record for a student. 
 * The record only contains the following three characters:
	
	'A' : Absent.
	'L' : Late.
	'P' : Present.
	A student could be rewarded if his attendance record doesn't contain 
	more than one 'A' (absent) or more than two continuous 'L' (late).
	
	You need to return whether the student could be rewarded according to his attendance record.
	
	Example 1:
	
	Input: "PPALLP"
	Output: True
	
	Example 2:
	
	Input: "PPALLL"
	Output: False
 * 
 * @author Rudolf
 *
 */
public class StudentAttendanceRecordI_551 {

	public boolean checkRecord(String s) {
        
        int numA = 0;
        int indexOfL = 0;
        
        if (s == null || s.length() < 2) return true;
        
        // 1) Count char A and check if numA > 1
        for (char c : s.toCharArray()) {
            if (c == 'A') numA++;
        }
        
        if (numA > 1) return false;
        
        // 2) Check if L's are consecutive (ie. find index of L and check if index+1 and index+2 are L)
        indexOfL = s.indexOf('L');
        
        while (indexOfL >= 0 && indexOfL < s.length() - 2) {
            if (s.charAt(indexOfL + 1) == 'L' && s.charAt(indexOfL + 2) == 'L') {
                return false;
            }
            indexOfL = s.indexOf('L', indexOfL + 1);
        }
        
        return true;
    }
	
    public boolean checkRecord2(String s) {
        return !s.matches(".*A.*A.*") && !s.matches(".*LLL.*");
    }
}
