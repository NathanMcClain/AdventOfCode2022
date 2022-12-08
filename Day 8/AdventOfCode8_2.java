import java.io.*;
import java.util.*;

public class AdventOfCode8_2 {
    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File(
            "./day8.txt");
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

        int visible = 0;
        int[][] heights = new int[input.size()][input.get(0).length()];
        for( int i = 0; i < input.size(); i++ )
            {
            for( int j = 0; j < input.get(i).length(); j++ )
                {
                heights[i][j] = Integer.parseInt("" + input.get(i).charAt(j));
                }
            }

        int maxVisScore = 0;
        int curVisScore = 0;
        for( int i = 1; i < input.size() - 1; i++ )
            {
            for( int j = 1; j < input.get(i).length() - 1; j++ )
                {
                curVisScore = visibleLeftScore(heights,i,j) * visibleTopScore(heights,i,j) * visibleRightScore(heights,i,j) * visibleBottomScore(heights,i,j,input);
                if( curVisScore > maxVisScore )
                    {
                    maxVisScore = curVisScore;
                    }
                }
            }
        System.out.println(maxVisScore);
    }

    public static int visibleLeftScore( int[][] heights, int row, int col )
        {
        int score = 0;
        for( int i = col - 1; i >= 0; i-- )
            {
            if( heights[row][i] < heights[row][col])
                {
                score++;
                }
            else
                {
                score++; //can see tree that blocks
                break;
                }
            }
        //System.out.println("Left score: " + score + " idx " + row + "," + col);
        return score;
        }

    public static int visibleTopScore( int[][] heights, int row, int col )
        {
        int score = 0;
        for( int i = row - 1; i >= 0; i-- )
            {
            if( heights[i][col] < heights[row][col])
                {
                score++;
                }
            else
                {
                score++; //can see tree that blocks
                break;
                }
            }
        //System.out.println("Top score: " + score + " idx " + row + "," + col);
        return score;
        }

    public static int visibleRightScore( int[][] heights, int row, int col )
        {
        int score = 0;
        for( int i = col + 1; i < heights[0].length; i++ )
            {
            if( heights[row][i] < heights[row][col])
                {
                score++;
                }
            else
                {
                score++; //can see tree that blocks
                break;
                }
            }
        //System.out.println("Right score: " + score + " idx " + row + "," + col);
        return score;
        }

    public static int visibleBottomScore( int[][] heights, int row, int col, List<String> input )
        {
        int score = 0;
        for( int i = row + 1; i < input.size(); i++ )
            {
            if( heights[i][col] < heights[row][col])
                {
                score++;
                }
            else
                {
                score++; //can see tree that blocks
                break;
                }
            }
        //System.out.println("Bottom score: " + score + " idx " + row + "," + col);
        return score;
        }
}
