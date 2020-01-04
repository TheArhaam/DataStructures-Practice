import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
        List<Integer> resultList = new ArrayList<>();
        List<List<Integer>> sequenceList = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        int lastAnswer = 0,qtype,x,y,sequenceNumber;

        //initializing sequence list
        for(int i=0;i<n;i++)
        {
            sequenceList.add(new ArrayList<>());
        }

        //for traversing the queries
        for(int i=0;i<queries.size();i++)
        {
            // System.out.println("===================");
            // System.out.println("Loop: "+i);
            qtype = queries.get(i).get(0);
            x = queries.get(i).get(1);
            y = queries.get(i).get(2);
            sequenceNumber = ((x^lastAnswer)%n);
            // System.out.println("qtype: "+qtype);
            // System.out.println("x: "+x);
            // System.out.println("y: "+y);
            // System.out.println("sequenceNumber: "+sequenceNumber);

            if(qtype == 1)
            {
                sequenceList.get(sequenceNumber).add(y); //adding y to sequence
                // System.out.println("SequenceList= "+sequenceList);
            }
            else if(qtype == 2)
            {
                subList = sequenceList.get(sequenceNumber);
                //getting the last element of the sequence
                lastAnswer = sequenceList.get(sequenceNumber).get(y%subList.size());
                // System.out.println("LastAnswer= "+lastAnswer);
                resultList.add(lastAnswer);
                // System.out.println("resultList= "+resultList);
            }
        }
        return resultList;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
