import java.io.*;
import java.util.*;

public class AdventOfCode6_2 {
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
            String sub = buf.substring(i,i+14);
            char[] letters = sub.toCharArray();
            Arrays.sort(letters);
            String sorted = new String(letters);
            if( sorted.charAt(0) != sorted.charAt(1) && sorted.charAt(1) != sorted.charAt(2) && sorted.charAt(2) != sorted.charAt(3) && sorted.charAt(3) != sorted.charAt(4) && sorted.charAt(4) != sorted.charAt(5) && sorted.charAt(5) != sorted.charAt(6) && sorted.charAt(6) != sorted.charAt(7) && sorted.charAt(7) != sorted.charAt(8) && sorted.charAt(8) != sorted.charAt(9) && sorted.charAt(9) != sorted.charAt(10) && sorted.charAt(10) != sorted.charAt(11) && sorted.charAt(11) != sorted.charAt(12) && sorted.charAt(12) != sorted.charAt(13))
                {
                index = i + 14;
                break;
                }
            }
        System.out.println(index);
    }
}
