import java.io.*;
import java.util.*;

public class AdventOfCode10_1 {
    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File(
            "./day10.txt");
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

        int[] nums_add = new int[input.size() * 2];
        int[] after_score = new int[input.size() * 2];
        int command_index = 0;
        for( int i = 0; i < input.size(); i++ )
            {
            if(input.get(i).equals("noop"))
                {
                nums_add[command_index] = 0;
                command_index++;
                }
            else
                {
                String[] parts = input.get(i).split(" ");
                int add_val = Integer.parseInt(parts[1]);
                nums_add[command_index] = 0;
                command_index++;
                nums_add[command_index] = add_val;
                command_index++;
                }
            }
        for( int i = 0; i < nums_add.length; i++ )
            {
            System.out.println(nums_add[i]);
            }


        int running_total = 0;
        for( int i = 0; i < nums_add.length; i++ )
            {
            if( i == 19 || i == 59 || i == 99 || i == 139 || i == 179 || i == 219 )
                {
                int score = ( i + 1 ) * after_score[i-1];
                String score_str = "" + score;
                System.out.println("Score after cycle " + ( i + 1 ) + ": " + score_str);
                running_total += score;
                }

            if( i != 0 )
                {
                after_score[i] = after_score[i-1] + nums_add[i];
                }
            else
                {
                after_score[i] = 1;
                }
            }
        System.out.println("Total: " + running_total );
    }
}
