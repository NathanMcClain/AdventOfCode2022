import java.io.*;
import java.util.*;

public class AdventOfCode3_2 {
    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File("./day3test.txt");
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
        for( int i = 0; i < input.size(); i = i + 3 )
            {
            char shared = '!';
            String p1 = input.get(i);
            String p2 = input.get(i+1);
            String p3 = input.get(i+2);
            for( int j = 0; j < p1.length(); j++ )
                {
                for( int k = 0; k < p2.length(); k++)
                    {
                    for( int l = 0; l < p3.length(); l++ )
                        {
                        if( p1.charAt(j) == p2.charAt(k) && p2.charAt(k) == p3.charAt(l) )
                            {
                            shared = p1.charAt(j);
                            }
                        if(shared != '!')
                            {
                            break;
                            }
                        }
                    if(shared != '!')
                        {
                        break;
                        }
                    }
                if(shared != '!')
                    {
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
