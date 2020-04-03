import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) 
    {
        int counter=0;
        int n=s.length();
        for(int i=1;i<n;i++)
        {
            List<String> list=new ArrayList<String>();

            for(int j=0;j<n;j++)
            {
                if(i+j <=n)
                {
                    list.add(s.substring(j,i+j));
                }
            }
            int size=list.size();
            for(int k=0;k<size;k++)
            {
                for(int l=k+1;l<size;l++)
                {
                    if(anagram(list.get(k),list.get(l)))
                    {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
      public static Boolean anagram(String s1,String s2)
        {
            int ch1[]=new int[26];
            int ch2[]=new int [26];
            for(int i=0;i<s1.length();i++)
            {
            ch1[s1.charAt(i)-97]++;
            ch2[s2.charAt(i)-97]++;
            }
        for(int i=0;i<26;i++)
        {
            if(ch1[i]!=ch2[i])
            {
                return false;
            }
        }
       
    return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
