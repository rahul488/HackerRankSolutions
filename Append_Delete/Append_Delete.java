import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) 
    {
       if(s.equals(t))
       {
           if(k >= s.length()*2 || k % 2 == 0 )
           {
               return "Yes";
           }
           else
           {
               return "No";
           }
       }
       else
       {
           int matching_Character=0;

           for(int i=0;i<Math.min(s.length(),t.length());i++)
           {
               if(s.charAt(i) != t.charAt(i))
               {
                   break;
               }
               matching_Character++;
           }
           int nonmatching_CharacterS=s.length()-matching_Character;
           int nonmatching_CharacterT=t.length()-matching_Character;

           if(nonmatching_CharacterS + nonmatching_CharacterT == k || nonmatching_CharacterS + nonmatching_CharacterT < k && (nonmatching_CharacterS + nonmatching_CharacterT - k)%2 == 0 || s.length() +t.length() <= k) 
           {
               return "Yes";
           }
           else
           {
               return "No";
           }
       }
      
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
