import java.io.*;
import java.util.*;

public class AdventOfCode11_1 {
    public static void main(String[] args) throws Exception
    {
        // File path is passed as parameter
        File file = new File(
            "./day11.txt");
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

        int monkey_index = 0;

        /* Create Monkeys */
        List<Monkey> monkeys = new ArrayList<Monkey>();
        for( int i = 0; i < input.size(); i++ )
            {
            String line = input.get(i);
            if( line.equals(""))
                {
                monkey_index++;
                continue;
                }
            if( line.charAt(0) == ('M'))
                {

                Monkey newMonkey = new Monkey();
                monkeys.add(newMonkey);
                }
            else
                {
                String stripped_line = line.strip();
                String[] monkeyParts = stripped_line.split(" ");
                if( monkeyParts[0].equals("Starting"))
                    {
                    for( int j = 2; j < monkeyParts.length; j++ )
                        {
                        monkeyParts[j] = monkeyParts[j].replace(",","");
                        monkeys.get(monkey_index).AddItem(Integer.parseInt(monkeyParts[j]));
                        }
                    }
                else if( monkeyParts[0].equals("Operation:"))
                    {
                    monkeys.get(monkey_index).setOperation(stripped_line);
                    }
                else if( monkeyParts[0].equals("Test:"))
                    {
                    monkeys.get(monkey_index).setDivisbleTest(stripped_line);
                    }
                else if( monkeyParts[1].equals("true:"))
                    {
                    monkeys.get(monkey_index).setTrueMonkey(stripped_line);
                    }
                else if( monkeyParts[1].equals("false:"))
                    {
                    monkeys.get(monkey_index).setFalseMonkey(stripped_line);
                    }
                }
            } /* End of creating monkeys */

        for( int rounds = 0; rounds < 20; rounds++ )
            {
            for( int i = 0; i < monkeys.size(); i++ )
                {
                while( monkeys.get(i).getItems().size() >= 1)
                    {
                    int new_worry = monkeys.get(i).applyOperation(monkeys.get(i).getItems().get(0));
                    int monkey_to_throw_to = monkeys.get(i).getMonkeyToThrowTo(new_worry);
                    monkeys.get(monkey_to_throw_to).AddItem(new_worry);
                    monkeys.get(i).RemoveItem();
                    }
                }
            }

        int highest_inspections = 0;
        int second_highest_inspections = 0;
        for( int i = 0; i < monkeys.size(); i++ )
            {
            if( monkeys.get(i).getInspectionNumber() > highest_inspections )
                {
                second_highest_inspections = highest_inspections;
                highest_inspections = monkeys.get(i).getInspectionNumber();
                }
            else if( monkeys.get(i).getInspectionNumber() > second_highest_inspections )
                {
                second_highest_inspections = monkeys.get(i).getInspectionNumber();
                }
            }
        int monkey_business_score = highest_inspections * second_highest_inspections;
        System.out.println(monkey_business_score);

    }
}

class Monkey {
    List<Integer> items;
    String operation;
    int divisible_test;
    int true_monkey;
    int false_monkey;
    int num_inspected;

    public Monkey() {
        items = new ArrayList<Integer>();
        operation = "";
        divisible_test = 1;
        true_monkey = 0;
        false_monkey = 0;
        num_inspected = 0;
    }

    public void AddItem(int item_to_add) {
        items.add(item_to_add);
    }

    public void RemoveItem() {
        items.remove(0);
    }

    public void setOperation( String incoming_operation ) {
        operation = incoming_operation;
    }

    public void setDivisbleTest( String incoming_divisible_test ) {
        String[] divisibleParts = incoming_divisible_test.split(" ");
        divisible_test = Integer.parseInt(divisibleParts[3]);
    }

    public void setTrueMonkey( String trueString ) {
        String[] trueParts = trueString.split(" ");
        true_monkey = Integer.parseInt(trueParts[5]);
    }

    public void setFalseMonkey( String falseString ) {
        String[] falseParts = falseString.split(" ");
        false_monkey = Integer.parseInt(falseParts[5]);
    }

    public List<Integer> getItems() {
        return items;
    }

    public int getInspectionNumber() {
        return num_inspected;
    }

    public int applyOperation(int old_worry) {
        String[] operationParts = this.operation.split(" ");
        int new_worry = 0;
        if( operationParts[4].equals("+"))
            {
            new_worry = old_worry + Integer.parseInt(operationParts[5]);
            }
        else if( operationParts[4].equals("*"))
            {
            if( operationParts[5].equals("old"))
                {
                new_worry = old_worry * old_worry;
                }
            else
                {
                new_worry = old_worry * Integer.parseInt(operationParts[5]);
                }
            }
        num_inspected++;
        return (int)(new_worry/3);
    }

    public int getMonkeyToThrowTo(int worry) {
        if( worry % divisible_test == 0)
            {
            return true_monkey;
            }
        else
            {
            return false_monkey;
            }
        }

}
