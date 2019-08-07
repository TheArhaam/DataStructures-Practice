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

        // Create a new array
        int[] newArray = new int[n];

        for(int i=0;i<n;i++)
        {
            // Find out the final location of the element after d shifts and store it in the new array. Read the newLocation formula carefully
            int newLocation = (i+(n-d))%n;
            newArray[newLocation] = a[i];
        }
        scanner.close();

        //Displaying the new array
        for(int i=0;i<n;i++)
        {   
            bufferedWriter.write(newArray[i]+" ");
        }
        
        bufferedWriter.close();
    }
}