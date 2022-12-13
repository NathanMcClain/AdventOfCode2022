import java.io.*;
import java.util.*;

public class AdventOfCode12_2 {
    public static int dest_row;
    public static int dest_col;
    public static int start_row;
    public static int start_col;
    public static int shortest;
    public static int max_row;
    public static int max_col;

    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File(
            "./message.txt");
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
        int[][] heights = new int[input.size()][input.get(0).length()];
        boolean[][] visited = new boolean[input.size()][input.get(0).length()];
        start_row = 0;
        start_col = 0;
        dest_row = 0;
        dest_col = 0;
        shortest = 2000;
        max_row = input.size() - 1;
        max_col = input.get(0).length() - 1;

        for( int i = 0; i < input.size(); i++ )
            {
            String line = input.get(i);
            for( int j = 0; j < line.length(); j++ )
                {
                visited[i][j] = false;
                if( line.charAt(j) == 'S')
                    {
                    start_row = i;
                    start_col = j;
                    heights[i][j] = 0;
                    }
                else if( line.charAt(j) == 'E')
                    {
                    dest_row = i;
                    dest_col = j;
                    heights[i][j] = 26;
                    }
                else
                    {
                    heights[i][j] = line.charAt(j) - 'a';
                    }
                }
            }
        Queue <Grid> q = new PriorityQueue<Grid>();
        for( int i = 0; i < max_row; i++ )
            {
            for( int j = 0; j < max_col; j++ )
                {
                if( heights[i][j] == 0 )
                    {
                    visited[i][j] = true;
                    Grid firstGrid = new Grid(heights,visited,i,j, i, j, dest_row, dest_col, 0);
                    q.add(firstGrid);
                    }
                }
            }
        while( q.size() > 0 )
            {
            Grid grid = q.remove();

            if( grid.IsCorrect() )
                {
                if( grid.GetLength() < shortest )
                    {
                    System.out.println("New shortest: " + grid.GetLength());
                    shortest = grid.GetLength();
                    }
                }
            else
                {
                if( CanMoveUp(grid.GetHeights(), grid.GetVisited(), grid.GetCurRow(), grid.GetCurCol()))
                    {
                    Grid newGrid1 = new Grid(grid.GetHeights(), grid.GetVisited(), grid.GetCurRow(), grid.GetCurCol(), start_row, start_col, dest_row, dest_col, grid.GetLength());
                    newGrid1.AddLength();
                    newGrid1.SetCurRow(newGrid1.GetCurRow() - 1);
                    newGrid1.SetVisited(newGrid1.GetCurRow(), newGrid1.GetCurCol());
                    q.add(newGrid1);
                    }

                if( CanMoveDown(grid.GetHeights(), grid.GetVisited(), grid.GetCurRow(), grid.GetCurCol()) )
                    {
                    Grid newGrid2 = new Grid(grid.GetHeights(), grid.GetVisited(), grid.GetCurRow(), grid.GetCurCol(), start_row, start_col, dest_row, dest_col, grid.GetLength());
                    newGrid2.AddLength();
                    newGrid2.SetCurRow(newGrid2.GetCurRow() + 1);
                    newGrid2.SetVisited(newGrid2.GetCurRow(), newGrid2.GetCurCol());
                    q.add(newGrid2);
                    }

                if( CanMoveLeft(grid.GetHeights(), grid.GetVisited(), grid.GetCurRow(), grid.GetCurCol()) )
                    {
                    Grid newGrid3 = new Grid(grid.GetHeights(), grid.GetVisited(), grid.GetCurRow(), grid.GetCurCol(), start_row, start_col, dest_row, dest_col, grid.GetLength());
                    newGrid3.AddLength();
                    newGrid3.SetCurCol(newGrid3.GetCurCol() - 1);
                    newGrid3.SetVisited(newGrid3.GetCurRow(), newGrid3.GetCurCol());
                    q.add(newGrid3);
                    }

                if( CanMoveRight( grid.GetHeights(), grid.GetVisited(), grid.GetCurRow(), grid.GetCurCol()))
                    {
                    Grid newGrid4 = new Grid(grid.GetHeights(), grid.GetVisited(), grid.GetCurRow(), grid.GetCurCol(), start_row, start_col, dest_row, dest_col, grid.GetLength());
                    newGrid4.AddLength();
                    newGrid4.SetCurCol(newGrid4.GetCurCol() + 1);
                    newGrid4.SetVisited(newGrid4.GetCurRow(), newGrid4.GetCurCol());
                    q.add(newGrid4);
                    }
                }
            }
            System.out.println(shortest);
    }

    public static boolean CanMoveUp( int[][]heights, boolean[][] visited, int cur_row, int cur_col )
        {
        return ( cur_row != 0 && visited[cur_row-1][cur_col] == false && heights[cur_row-1][cur_col] <= heights[cur_row][cur_col] + 1);
        }

    public static boolean CanMoveDown( int[][]heights, boolean[][] visited, int cur_row, int cur_col )
        {
        return ( cur_row != max_row && visited[cur_row + 1][cur_col] == false && heights[cur_row+1][cur_col] <= heights[cur_row][cur_col] + 1 );
        }

    public static boolean CanMoveLeft( int[][]heights, boolean[][] visited, int cur_row, int cur_col )
        {
        return ( cur_col != 0 && visited[cur_row][cur_col-1] == false && heights[cur_row][cur_col-1] <= heights[cur_row][cur_col] + 1 );
        }

    public static boolean CanMoveRight( int[][]heights, boolean[][] visited, int cur_row, int cur_col )
        {
        return ( cur_col != max_col && visited[cur_row][cur_col+1] == false && heights[cur_row][cur_col+1] <= heights[cur_row][cur_col] + 1 );
        }
}

class Grid implements Comparable<Grid>
{
int[][] heights;
boolean[][] visited;
int cur_row;
int cur_col;
int length;
int start_col;
int dest_col;
int start_row;
int dest_row;

public Grid( int[][] incoming_heights, boolean[][] incoming_visited, int incoming_cur_row, int incoming_cur_col, int incoming_start_row, int incoming_start_col, int incoming_dest_row, int incoming_dest_col, int incoming_length )
    {
    heights = incoming_heights;
    visited = incoming_visited;
    start_row = incoming_start_row;
    dest_row = incoming_dest_row;
    start_col = incoming_start_col;
    dest_col = incoming_dest_col;
    for( int i = 0; i < incoming_heights.length; i++ )
        {
        for( int j = 0; j < incoming_heights[0].length; j++)
            {
            heights[i][j] = incoming_heights[i][j];
            visited[i][j] = incoming_visited[i][j];
            }
        }
    cur_row = incoming_cur_row;
    cur_col = incoming_cur_col;
    length = incoming_length;
    }

public boolean IsCorrect()
    {
    return ( visited[dest_row][dest_col] == true && visited[start_col][start_col] == true );
    }

public int GetLength()
    {
    return length;
    }

public int GetCurRow()
    {
    return cur_row;
    }

public int GetCurCol()
    {
    return cur_col;
    }

public boolean[][] GetVisited()
    {
    return visited;
    }

public int[][] GetHeights()
    {
    return heights;
    }

public void SetVisited(int new_row, int new_col)
    {
    visited[new_row][new_col] = true;
    }

public void AddLength()
    {
    length += 1;
    }

public void SetCurRow( int incoming_row )
    {
    cur_row = incoming_row;
    }

public void SetCurCol( int incoming_col )
    {
    cur_col = incoming_col;
    }

// Compare two grid objects by their length
@Override
public int compareTo(Grid incoming_grid) {
    if(this.GetLength() > incoming_grid.GetLength()) {
        return 1;
    } else if (this.GetLength() < incoming_grid.GetLength()) {
        return -1;
    } else {
        return 0;
    }
}
}
