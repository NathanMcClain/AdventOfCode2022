import java.io.*;
import java.util.*;

public class AdventOfCode5_1 {
    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File(
            "./day5.txt");
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
        List<List<String>> stacks = new ArrayList<List<String>>();
        for( int i = 0; i < 9; i++ )
            {
            stacks.add(new ArrayList<String>());
            }
        List<String> instructions = new ArrayList<String>();
        for( int i = 0; i < input.size(); i++ )
            {
            String row = input.get(i);

            if( !row.equals("") && row.charAt(1) != '1' && row.charAt(0) != 'm')
                {
                for( int j = 1; j < row.length(); j = j + 4)
                    {
                    if( row.charAt(j) != ' ')
                        {
                        stacks.get((j -1 )/4).add("" + row.charAt(j));
                        }
                    }
                }
            else if( !row.equals("") && row.charAt(0) == 'm')
                {
                instructions.add(row);
                }
            }

        /* Parse instructions */
        for( int i = 0; i < instructions.size(); i++ )
            {
            String[] parts = instructions.get(i).split(" ");
            int countToMove = Integer.parseInt(parts[1]);
            int fromStack = Integer.parseInt(parts[3]);
            int toStack = Integer.parseInt(parts[5]);
            for( int j = 0; j < countToMove; j++ )
                {
                String charToMove = stacks.get(fromStack - 1).get(0);
                stacks.get(fromStack-1).remove(0);
                stacks.get(toStack -1 ).add(0,charToMove);
                }
            }
        System.out.println(stacks);
    }
}
