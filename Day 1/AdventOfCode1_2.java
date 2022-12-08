import java.io.*;
import java.util.*;

public class AdventOfCode1_2 {
    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File(
            "./day1.txt");
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

          List<Integer> total = new ArrayList<Integer>();
          int running_total = 0;
          for( int i = 0; i < input.size(); i++ )
            {
            if( input.get(i).equals("") )
              {
              total.add(running_total);
              running_total = 0;
              }
            else
              {
              running_total += Integer.parseInt(input.get(i));
              }
            }
          Collections.sort(total);
          int top3 = total.get(total.size()-1) + total.get(total.size()-2) + total.get(total.size() - 3 );
          System.out.println(top3);
    }
}
