import java.io.*;
import java.util.*;

public class AdventOfCode8_1 {
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

        for( int i = 0; i < input.size(); i++ )
            {
            for( int j = 0; j < input.get(i).length(); j++ )
                {
                if( isVisibleFromLeft(heights,i,j) || isVisibleFromTop(heights,i,j) || isVisibleFromRight(heights,i,j) || isVisibleFromBottom(heights,i,j,input) )
                    {
                    visible++;
                    }
                }
            }
        System.out.println(visible);
    }

    public static boolean isVisibleFromLeft( int[][] heights, int row, int col )
        {
        boolean retVal = true;
        for( int i = 0; i < col; i++ )
            {
            if( heights[row][i] >= heights[row][col])
                {
                retVal = false;
                }
            }
        if( col == 0 )
            {
            retVal = true;
            }
        return retVal;
        }

    public static boolean isVisibleFromTop( int[][] heights, int row, int col )
        {
        boolean retVal = true;
        for( int i = 0; i < row; i++ )
            {
            if( heights[i][col] >= heights[row][col])
                {
                retVal = false;
                }
            }
        if( row == 0 )
            {
            retVal = true;
            }
        return retVal;
        }

    public static boolean isVisibleFromRight( int[][] heights, int row, int col )
        {
        boolean retVal = true;
        for( int i = heights[0].length -1 ; i > col; i-- )
            {
            if( heights[row][i] >= heights[row][col])
                {
                retVal = false;
                }
            }
        if( col == heights[0].length - 1)
            {
            retVal = true;
            }
        return retVal;
        }

    public static boolean isVisibleFromBottom( int[][] heights, int row, int col, List<String> input )
        {
        boolean retVal = true;
        for( int i = input.size() - 1; i > row; i-- )
            {
            if( heights[i][col] >= heights[row][col])
                {
                retVal = false;
                }
            }
        if( row == input.size() - 1)
            {
            retVal = true;
            }
        return retVal;
        }
}
