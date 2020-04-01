import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) 
    {
        int n=topic.length;
        BigInteger[] bi=new BigInteger[n];
        for(int i=0;i<topic.length;i++)
        {
           bi[i]=new BigInteger(topic[i],2);
        }

        int maxTopic=0;
        int teamCount=0;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                BigInteger b=bi[i].or(bi[j]);
                int bit_Count=b.bitCount();

                if(bit_Count > maxTopic)
                {
                    maxTopic=bit_Count;
                    teamCount=1;
                }
                else if(bit_Count == maxTopic)
                {
                    teamCount++;
                }
            }
        }
        int res[]={maxTopic,teamCount};
        return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

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
