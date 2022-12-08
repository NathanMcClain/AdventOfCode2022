import java.io.*;
import java.util.*;

public class AdventOfCode2_1 {
    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File("./day2.txt");
        List<String> input = new ArrayList<String>();

        // Creating an object of BufferedReader class
        BufferedReader br = new BufferedReader(new FileReader(file));

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
        int score = 0;
        int a = 0;
        int b = 1;
        int c = 2;
        for( int i = 0; i < input.size(); i++)
            {
            int first = 0;
            int second = 0;
            String[] parts = input.get(i).split(" ");
            char adjusted = (char)(parts[1].charAt(0) - 23);
            first = parts[0].charAt(0) - 'A';
            second = adjusted - 'A';
            if( first == second )
                {
                score += 3;
                }
            if( ( first + 1 ) % 3 == second )
                {
                score += 6;
                }
            score += second + 1;
            //System.out.println(score);
            }
        System.out.println(score);
    }
}
