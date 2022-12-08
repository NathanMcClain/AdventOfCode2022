import java.io.*;
import java.util.*;

public class AdventOfCode4_2 {
    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File(
            "./day4.txt");
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

        int overlap = 0;
          for( int i = 0; i < input.size(); i++)
            {
            String[] parts = input.get(i).split(",");
            int firstMin = 0;
            int firstMax = 0;
            int secondMin = 0;
            int secondMax = 0;
            for(int j = 0; j < parts.length; j++ )
                {
                String[] minMax = parts[j].split("-");
                if( j == 0 )
                    {
                    firstMin = Integer.parseInt(minMax[0]);
                    firstMax = Integer.parseInt(minMax[1]);
                    }
                else
                    {
                    secondMin = Integer.parseInt(minMax[0]);
                    secondMax = Integer.parseInt(minMax[1]);
                    }
                }
            if( ( firstMax >= secondMin && firstMax <= secondMax ) ||
                ( secondMax >= firstMin && secondMax <= firstMax ) )
                {
                overlap++;
                }
            }
        System.out.println(overlap);

        /* Do stuff here */
    }
}
