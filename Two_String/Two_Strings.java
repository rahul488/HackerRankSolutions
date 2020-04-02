import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    static String twoStrings(String a, String b){
        int a_freq[]=new int[26];
       
        for(int i=0;i<a.length();i++)
        {
            a_freq[((int)a.charAt(i))-97]++;
        }
        for(int i=0;i<b.length();i++)
        {
            if(a_freq[((int)b.charAt(i))-97]!=0)
            {
                return "YES";
            }
        }
            return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s1 = in.next();
            String s2 = in.next();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
    }
}
