import java.io.*;
import java.util.*;

public class AdventOfCode7_1 {
    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File(
            "./day7.txt");
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

        List<Integer> folderSize = new ArrayList<Integer>();
        List<String> paths = new ArrayList<String>();
        folderSize.add(0);
        paths.add("/");

        String currentPath = "/";

        for( int index = 2; index < input.size(); index++ )
            {
            String[] parts = input.get(index).split(" ");

            /* Add files in base folder */
            if( Character.isDigit(input.get(index).charAt(0)))
                {
                folderSize.set(getPathIndex(paths,currentPath), folderSize.get(getPathIndex(paths,currentPath))+ Integer.parseInt(parts[0]));
                }
            /* Directories */
            else if( parts[0].equals("dir"))
                {
                folderSize.add(0);
                paths.add(currentPath + "." + parts[1]);
                }
            else /* $ command */
                {
                if( parts[1].equals("cd"))
                    {
                    if( parts[2].equals(".."))
                        {
                        currentPath = updateCurrentFolder(currentPath);
                        }
                    else if( parts[2].equals("/"))
                        {
                        currentPath = "/";
                        }
                    else
                        {
                        currentPath = currentPath + "." + parts[2];
                        }
                    }
                else if( parts[1].equals("ls"))
                    {
                    index++;
                    int sizeToAdd = 0;
                    while( input.get(index).charAt(0) != '$' && index != input.size()-1)
                        {
                        //System.out.println("Getting to here in index " + index);
                        String[] newParts = input.get(index).split(" ");
                        /* We haven't done this ls command before */
                        if(folderSize.get(getPathIndex(paths,currentPath)) == 0)
                            {
                            //System.out.println("Inside if in index " + index);
                            if( Character.isDigit(input.get(index).charAt(0)))
                                {
                                sizeToAdd += Integer.parseInt(newParts[0]);
                                }
                            else
                                {
                                folderSize.add(0);
                                paths.add(currentPath + "." + newParts[1]);
                                //System.out.println("Add new directory: " + currentPath + newParts[1]);
                                }
                            }
                        index++;
                        }
                    index--;
                    /* Make sure we haven't already added this */
                    if( folderSize.get(getPathIndex(paths,currentPath)) != sizeToAdd )
                        {
                        folderSize.set(getPathIndex(paths,currentPath),sizeToAdd);
                        }
                    }
                }
            }
        /* Done parsing everything, need to add folder sizes */
        for( int i = 0; i < folderSize.size(); i++ )
            {
            for( int j = i + 1; j < folderSize.size(); j++)
                {
                if( paths.get(j).contains(paths.get(i)) && i != j)
                    {
                    folderSize.set(i,folderSize.get(i) + folderSize.get(j));
                    }
                }
            }

        /* Loop through all folder sizes to see which are less than 100000 */
        int total = 0;
        for( int i = 0; i < folderSize.size(); i++ )
            {
            //System.out.println(paths.get(i));
            //System.out.println(folderSize.get(i));
            if( folderSize.get(i) <= 100000 )
                {
                total += folderSize.get(i);
                }
            }
        System.out.println(total);

        /* Do stuff here */
    }

    public static int getPathIndex(List<String> paths, String currentPath)
        {
        for( int i = 0; i < paths.size(); i++ )
            {
            if(paths.get(i).equals(currentPath))
                {
                return i;
                }
            }
        System.out.println("Cannot find " + currentPath + " in " + paths);
        return -1; //error
        }

    public static String updateCurrentFolder(String currentPath)
        {
        String retval = "/";
        int index = currentPath.lastIndexOf('.');
        retval = currentPath.substring(0,index);
        //System.out.println("Updating current folder to: " + retval );
        return retval;
        }
}
