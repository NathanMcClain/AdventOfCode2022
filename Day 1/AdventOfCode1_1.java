import java.io.*;
import java.util.*;

public class AdventOfCode1_1 {
    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File(
            "./day1test.txt");
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

          int most = 0;
          int running_total = 0;
          for( int i = 0; i < input.size(); i++ )
            {
            if( input.get(i).equals("") )
              {
              if( running_total > most )
                {
                most = running_total;
                }
              running_total = 0;
              }
            else
              {
              running_total += Integer.parseInt(input.get(i));
              }
            }
          System.out.println(most);
    }
}
