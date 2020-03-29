import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) 
    {
        int rev,count=0;
        for(int l=i;l<=j;l++)
        {
           rev= reverse_day(l);
           int Check_day=Math.abs(l-rev)%k;
           if(Check_day == 0)
           {
               count++;
           }
        }
        return count;
    }
    public static int reverse_day(int k)
    {
        int r;
        int rev=0;
        while(k!=0)
        {
            r=k%10;
            rev=rev*10+r;
            k=k/10;
        }
        return rev;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
