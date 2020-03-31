import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) 
    {
        long x=s.length();
        long counter=0;
        long total_counter=0;
        for(int i=0;i<x;i++)
        {
            if(s.charAt(i) == 'a')
            {
                counter++;
            }
        }
            long r=n/x;
            total_counter+=counter*r;

            long remaining_char=n%x;

            for(int i=0;i<remaining_char;i++)
            {
                 if(s.charAt(i) == 'a')
                {
                total_counter++;
                }
            }
    return total_counter;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
