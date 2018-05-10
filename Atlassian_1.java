import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Atlassian_1 {

    /*
 * Complete the function below.
 */

    static String mergeStrings(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) return "";
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        char[] result = new char[charsA.length + charsB.length];
        
        // Indices for arrays above.
        int pA = 0;
        int pB = 0;
        int pResult = 0;
        
        while (pA < charsA.length && pB < charsB.length) {
            // Add char at pA
            result[pResult] = charsA[pA];
            pA++;
            pResult++;
            
            // Add char at pB
            result[pResult] = charsB[pB];
            pB++;
            pResult++;
        }
        
        while (pA < charsA.length) {
            // Add char at pA
            result[pResult] = charsA[pA];
            pA++;
            pResult++;
        }
        while (pB < charsB.length) {
            // Add char at pB
            result[pResult] = charsB[pB];
            pB++;
            pResult++;
        }
        
        return new String(result);
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _a;
        try {
            _a = in.nextLine();
        } catch (Exception e) {
            _a = null;
        }
        
        String _b;
        try {
            _b = in.nextLine();
        } catch (Exception e) {
            _b = null;
        }
        
        res = mergeStrings(_a, _b);
        bw.write(res);
        bw.newLine();
        
        bw.close();
    }
}
