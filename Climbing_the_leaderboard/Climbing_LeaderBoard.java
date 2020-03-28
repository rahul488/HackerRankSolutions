import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) 
    {
        int a=scores.length;
        int b=alice.length;

        int res[]=new int[b];
        int rank[]=new int[a];
        rank[0]=1;
        for(int i=1;i<a;i++)
        {
            if(scores[i]==scores[i-1])
            {
                rank[i]=rank[i-1];
            }
            else
            {
                rank[i]=rank[i-1]+1;
            }
        }
        for(int i=0;i<b;i++)
        {
            int aliceScore=alice[i];
            if(aliceScore > scores[0])
            {
                res[i]=1;
            }
            else if(aliceScore < scores[a-1])
            {
                res[i]=rank[a-1]+1;
            }
            else
            {
                int position=binarySearch(scores,aliceScore);
                res[i]=rank[position];
            }
        }
        return res;
    }
    public static int binarySearch(int ar[],int mark)
    {
        int low=0;
        int high=ar.length-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(mark == ar[mid])
            {
                return mid;
            }
            else if(mark < ar[mid] && mark >= ar[mid+1])
            {
                return mid+1;
            }
            else if(mark > ar[mid] && mark < ar[mid-1])
            {
                return mid;
            }
            else if(mark < ar[mid])
            {
                low=mid+1;
            }
            else if(mark > ar[mid])
            {
                high=mid-1;
            }
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
