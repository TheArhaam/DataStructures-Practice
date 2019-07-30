import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nd = scanner.nextLine().split(" ");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        //Solution
        int temp;
        //For number of shifts
        for(int i=0;i<d;i++)
        {
            temp = a[0]; //moving first element to temp
            //for a single shift
            for(int j=0;j<n-1;j++){
                a[j] = a[j+1];
            }
            a[n-1]=temp; //moving temp to last element
        }
        scanner.close();

        //displaying
        for(int i=0;i<n;i++)
        {   
            bufferedWriter.write(a[i]+" ");
        }
        
        bufferedWriter.close();
    }
}
