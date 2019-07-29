import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[] hourglass = new int[16];
        int sum,max=-100;

        //for top row of current hourglass
        for(int row=0;row<=3;row++) 
        {
            //for top column of current hourglass
            for(int col=0;col<=3;col++)
            {
                sum=0;
                //for summation of top row
                sum=sum + arr[row][col] + arr[row][col+1] + arr[row][col+2] 
                //for adding middle element
                + arr[row+1][col+1]
                //for summation of bottom row
                + arr[row+2][col] + arr[row+2][col+1] + arr[row+2][col+2];

                max = Math.max(max,sum); //comparing to get the highest sum
            }
        }
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
