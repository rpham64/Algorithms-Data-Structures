import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Atlassian_2 {

	/*
     * Complete the isPangram function below.
     */
    static String isPangram(String[] strings) {
        /*
         * Write your code here.
         */
         StringBuilder builder = new StringBuilder();
         
         for (String word : strings) {
             if (isPangram(word)) {
                 builder.append("1");
             } else {
                 builder.append("0");
             }
         }
         
         return builder.toString();
    }
    
    private static boolean isPangram(String word) {
        int[] count = new int[26];  // 'a' - '0' = int?
        
        for (int i = 0; i < count.length; ++i) {
            count[i] = 1;
        }
        
        for (char c : word.toCharArray()) {
            if (c < 'a' || c > 'z') continue;
            count[c - 'a']--;
        }
        
        for (int i = 0; i < count.length; ++i) {
            if (count[i] == 1) return false;
        }
        
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        String[] strings = new String[stringsCount];

        for (int stringsItr = 0; stringsItr < stringsCount; stringsItr++) {
            String stringsItem = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
            strings[stringsItr] = stringsItem;
        }

        String res = isPangram(strings);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
