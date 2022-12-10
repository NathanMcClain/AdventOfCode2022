import java.io.*;
import java.util.*;
import java.lang.Math;

public class AdventOfCode10_2 {
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

    int running_idx = 0;
    int image_center = 1;
    after_score[0] = 1;
    for( int row = 0; row < 6; row++)
        {
        for( int col = 0; col < 40; col++)
            {
            if( running_idx == 0 )
                {
                image_center = 1;
                }
            else
                {
                image_center = after_score[running_idx-1];
                }

            if( Math.abs(image_center - (running_idx%40)) <= 1)
                {
                System.out.print("#");
                }
            else
                {
                System.out.print(".");
                }
            if( running_idx != 0 )
                {
                after_score[running_idx] = after_score[running_idx-1] + nums_add[running_idx];
                }
            else
                {
                after_score[running_idx] = 1;
                }
            running_idx++;
            }
        System.out.println();
        }
    }
}
