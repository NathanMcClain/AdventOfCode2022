import java.io.*;
import java.util.*;
import java.lang.Math;

public class AdventOfCode9_2 {
    public static int grid_length;
    public static int row_1;
    public static int col_1;
    public static int row_2;
    public static int col_2;
    public static int row_3;
    public static int col_3;
    public static int row_4;
    public static int col_4;
    public static int row_5;
    public static int col_5;
    public static int row_6;
    public static int col_6;
    public static int row_7;
    public static int col_7;
    public static int row_8;
    public static int col_8;
    public static int row_9;
    public static int col_9;

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
        int head_row = grid_length / 2;
        int head_col = grid_length / 2;
        row_1 = head_row;
        col_1 = head_col;
        row_2 = head_row;
        col_2 = head_col;
        row_3 = head_row;
        col_3 = head_col;
        row_4 = head_row;
        col_4 = head_col;
        row_5 = head_row;
        col_5 = head_col;
        row_6 = head_row;
        col_6 = head_col;
        row_7 = head_row;
        col_7 = head_col;
        row_8 = head_row;
        col_8 = head_col;
        row_9 = head_row;
        col_9 = head_col;
        grid[row_9][col_9] += 1;

        for( int i = 0; i < input.size(); i++ )
            {
            String[] parts = input.get(i).split(" ");
            String direction = parts[0];
            int num = Integer.parseInt(parts[1]);
            boolean moved = false;
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
                grid = moveTail(grid, direction, head_row, head_col, row_1, col_1, 1);
                grid = moveTail(grid, direction, row_1, col_1, row_2, col_2, 2);
                grid = moveTail(grid, direction, row_2, col_2, row_3, col_3, 3);
                grid = moveTail(grid, direction, row_3, col_3, row_4, col_4, 4);
                grid = moveTail(grid, direction, row_4, col_4, row_5, col_5, 5);
                grid = moveTail(grid, direction, row_5, col_5, row_6, col_6, 6);
                grid = moveTail(grid, direction, row_6, col_6, row_7, col_7, 7);
                grid = moveTail(grid, direction, row_7, col_7, row_8, col_8, 8);
                grid = moveTail(grid, direction, row_8, col_8, row_9, col_9, 9);
                grid[row_9][col_9] += 1;

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
                            else if( row == row_1 && col == col_1)
                                {
                                System.out.print("1");
                                }
                            else if( row == row_2 && col == col_2)
                                {
                                System.out.print("2");
                                }
                            else if( row == row_3 && col == col_3)
                                {
                                System.out.print("3");
                                }
                            else if( row == row_4 && col == col_4)
                                {
                                System.out.print("4");
                                }
                            else if( row == row_5 && col == col_5)
                                {
                                System.out.print("5");
                                }
                            else if( row == row_6 && col == col_6)
                                {
                                System.out.print("6");
                                }
                            else if( row == row_7 && col == col_7)
                                {
                                System.out.print("7");
                                }
                            else if( row == row_8 && col == col_8)
                                {
                                System.out.print("8");
                                }
                            else if( row == row_9 && col == col_9)
                                {
                                System.out.print("9");
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
            }
        int visited = getNumberVisited(grid);
        System.out.println(visited);
    }

    public static int[][] moveTail( int[][] grid, String direction, int first_row, int first_col, int second_row, int second_col, int second_num )
        {
        if( ( Math.abs(first_row - second_row) == 2 && first_col == second_col ) || ( Math.abs(first_col - second_col) == 2 && first_row == second_row ) )
            {
            /* Move left/right */
            if( first_row == second_row )
                {
                if( first_col > second_col )
                    {
                    second_col++;
                    }
                else if( first_col < second_col)
                    {
                    second_col--;
                    }
                }
            /* Move up/down */
            else if( first_col == second_col )
                {
                if( first_row > second_row )
                    {
                    second_row++;
                    }
                else if( first_row < second_row)
                    {
                    second_row--;
                    }
                }
            }
        else if( ( Math.abs(first_row - second_row) == 2 && Math.abs(first_col - second_col ) == 1 ) || ( Math.abs(first_col - second_col) == 2 && Math.abs( first_row - second_row ) == 1 ) )
            {
            /* Head is too far away up/down */
            if( Math.abs(first_row - second_row) == 2 )
                {
                /* head below tail */
                if( first_row > second_row )
                    {
                    second_row = first_row - 1;
                    second_col = first_col;
                    }
                else if( first_row < second_row )
                    {
                    second_row = first_row + 1;
                    second_col = first_col;
                    }
                }
            else if( Math.abs(first_col - second_col) == 2 )
                {
                /* Head to the right of tail */
                if( first_col > second_col )
                    {
                    second_col = first_col - 1;
                    second_row = first_row;
                    }
                else if( first_col < second_col )
                    {
                    second_col = first_col + 1;
                    second_row = first_row;
                    }
                }
            }
        else if( ( Math.abs(first_row - second_row) == 2 && Math.abs(first_col - second_col ) == 2 ) )
            {
            if( first_row > second_row && first_col > second_col )
                {
                second_row = first_row - 1;
                second_col = first_col - 1;
                }
            else if( first_row < second_row && first_col > second_col )
                {
                second_row = first_row + 1;
                second_col = first_col - 1;
                }
            else if( first_row > second_row && first_col < second_col )
                {
                second_row = first_row - 1;
                second_col = first_col + 1;
                }
            else if( first_row < second_row && first_col < second_col )
                {
                second_row = first_row + 1;
                second_col = first_col + 1;
                }
            }
        else
            {
            /* No need to move */
            }
        if( second_num == 1 )
            {
            row_1 = second_row;
            col_1 = second_col;
            }
        else if( second_num == 2 )
            {
            row_2 = second_row;
            col_2 = second_col;
            }
        else if( second_num == 3 )
            {
            row_3 = second_row;
            col_3 = second_col;
            }
        else if( second_num == 4 )
            {
            row_4 = second_row;
            col_4 = second_col;
            }
        else if( second_num == 5 )
            {
            row_5 = second_row;
            col_5 = second_col;
            }
        else if( second_num == 6 )
            {
            row_6 = second_row;
            col_6 = second_col;
            }
        else if( second_num == 7 )
            {
            row_7 = second_row;
            col_7 = second_col;
            }
        else if( second_num == 8 )
            {
            row_8 = second_row;
            col_8 = second_col;
            }
        else if( second_num == 9 )
            {
            row_9 = second_row;
            col_9 = second_col;
            }
        return grid;
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
