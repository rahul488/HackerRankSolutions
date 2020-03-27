import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) 
    {
        HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
        int counter=1;
        int numberOf_sockpairs=0;
        for(int i=0;i<n;i++)
        {
            if(!hs.containsKey(ar[i]))
            {
                hs.put(ar[i],counter);
            }
            else
            {
                counter=hs.get(ar[i]);
                counter++;
                hs.put(ar[i],counter);
                counter=1;
            }
        }
        for(Map.Entry m:hs.entrySet())
        {
          int m1=(Integer.valueOf(m.getValue().toString())) /2;
          numberOf_sockpairs+=m1;
        }
    return numberOf_sockpairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
