import java.io.*;
import java.util.*;
import java.lang.Math;

public class AdventOfCode9_1 {
    public static int head_row;
    public static int head_col;
    public static int tail_row;
    public static int tail_col;
    public static int grid_length;

    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File(
            "./day9.txt");
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

        grid_length = 1000;

        int[][] grid = new int[grid_length][grid_length];
        head_row = 500;
        head_col = 500;
        tail_row = 500;
        tail_col = 500;
        grid[tail_row][tail_col] += 1;

        for( int i = 0; i < input.size(); i++ )
            {
            String[] parts = input.get(i).split(" ");
            String direction = parts[0];
            int num = Integer.parseInt(parts[1]);
            boolean moved = false;
            /* Move right */
            for( int j = 0; j < num; j++ )
                {
                if( direction.equals("R")&& head_col != grid_length - 1 )
                    {
                    head_col++;
                    }
                else if( direction.equals("L") && head_col != 0)
                    {
                    head_col--;
                    }
                else if( direction.equals("U") && head_row != 0)
                    {
                    head_row--;
                    }
                else if( direction.equals("D") && head_row != grid_length - 1 )
                    {
                    head_row++;
                    }
                moved = moveTail(grid, direction);
                if( moved )
                    {
                    grid[tail_row][tail_col] += 1;
                    }
                }

            /*
            System.out.println("===========");
            for( int row = 0; row < grid_length; row++ )
                {
                for( int col = 0; col < grid_length; col++ )
                    {
                    if( row == head_row && col == head_col )
                        {
                        System.out.print("H");
                        }
                    else if( row == tail_row && col == tail_col)
                        {
                        System.out.print("T");
                        }
                    else
                        {
                        System.out.print(".");
                        }
                    }
                System.out.println();
                }
            */
            }
        int visited = getNumberVisited(grid);
        System.out.println(visited);
    }

    public static boolean moveTail( int[][] grid, String direction )
        {
        boolean moved = false;
        if( ( Math.abs(head_row - tail_row) == 2 && head_col == tail_col ) || ( Math.abs(head_col - tail_col) == 2 && head_row == tail_row ) )
            {
            /* Move left/right */
            if( head_row == tail_row )
                {
                if( head_col > tail_col )
                    {
                    tail_col++;
                    moved = true;
                    }
                else if( head_col < tail_col)
                    {
                    tail_col--;
                    moved = true;
                    }
                }
            /* Move up/down */
            else if( head_col == tail_col )
                {
                if( head_row > tail_row )
                    {
                    tail_row++;
                    moved = true;
                    }
                else if( head_row < tail_row)
                    {
                    tail_row--;
                    moved = true;
                    }
                }
            }
        else if( ( Math.abs(head_row - tail_row) == 2 && Math.abs(head_col - tail_col ) == 1 ) || ( Math.abs(head_col - tail_col) == 2 && Math.abs( head_row - tail_row ) == 1 ) )
            {
            /* Head is too far away up/down */
            if( Math.abs(head_row - tail_row) == 2 )
                {
                /* head below tail */
                if( head_row > tail_row )
                    {
                    tail_row = head_row - 1;
                    tail_col = head_col;
                    moved = true;
                    }
                else if( head_row < tail_row )
                    {
                    tail_row = head_row + 1;
                    tail_col = head_col;
                    moved = true;
                    }
                }
            else if( Math.abs(head_col - tail_col) == 2 )
                {
                /* Head to the right of tail */
                if( head_col > tail_col )
                    {
                    tail_col = head_col - 1;
                    tail_row = head_row;
                    moved = true;
                    }
                else if( head_col < tail_col )
                    {
                    tail_col = head_col + 1;
                    tail_row = head_row;
                    moved = true;
                    }
                }
            }
        else
            {
            /* No need to move */
            moved = false;
            }
        return moved;
        }

    public static int getNumberVisited( int[][] grid )
        {
        int visited = 0;
        for( int i = 0; i < grid_length; i++ )
            {
            for( int j = 0; j < grid_length; j++ )
                {
                if( grid[i][j] != 0 )
                    {
                    visited++;
                    }
                }
            }
        return visited;
        }
}
