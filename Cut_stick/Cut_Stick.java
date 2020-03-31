import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) 
    {
        Arrays.sort(arr);
        List<Integer> list=new ArrayList<Integer>();
        int curr_ele=arr[0];
        int stick_left=arr.length;
        list.add(arr.length);
        int counter=0;
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(curr_ele == arr[i])
            {
                counter++;
            }
            else
            {
                stick_left-=counter;
                counter=1;
                list.add(stick_left);
                curr_ele=arr[i];
            }
        }
        int x[]=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            x[i]=list.get(i);
        }
        return x;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

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
