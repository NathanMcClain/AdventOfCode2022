import java.io.*;
import java.util.*;

public class AdventOfCode3_1 {
    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File("./day3.txt");
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
        int sum = 0;
        for( int i = 0; i < input.size(); i++ )
            {
            char shared = 'a';
            String p1 = input.get(i).substring(0,input.get(i).length()/2);
            String p2 = input.get(i).substring(input.get(i).length()/2,input.get(i).length());
            for( int j = 0; j < p1.length(); j++ )
                {
                if( p2.contains("" + p1.charAt(j)) )
                    {
                    shared = p1.charAt(j);
                    break;
                    }
                }
            int score = 1;
            if( shared >= 'a' && shared <= 'z')
                {
                score += (int)(shared - 'a');
                }
            else if( shared >= 'A' && shared <= 'Z')
                {
                score += 26 + (int)(shared - 'A');
                }
            sum += score;
            }
            System.out.println(sum);
    }
}
