import java.io.*;
import java.util.*;

public class AdventOfCode6_1 {
    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File(
            "./day6.txt");
          List<String> input = new ArrayList<String>();

        // Creating an object of BufferedReader class
        BufferedReader br
            = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null)
          {
            // Print the string
            input.add(st);
          }

        /* Do stuff here */
        String buf = input.get(0);
        int index = 0;
        for( int i = 0; i < buf.length(); i++ )
            {
            boolean right = true;
            String sub = buf.substring(i,i+4);
            char[] letters = sub.toCharArray();
            Arrays.sort(letters);
            String sorted = new String(letters);
            if( sorted.charAt(0) != sorted.charAt(1) && sorted.charAt(1) != sorted.charAt(2) && sorted.charAt(2) != sorted.charAt(3) )
                {
                index = i + 4;
                break;
                }
            }
        System.out.println(index);
    }
}
