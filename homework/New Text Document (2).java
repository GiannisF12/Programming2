import java.util.Scanner;
import java.lang.Math;

public class Homework_task2 
{
    public static void main(String[] args)
    {
        int min = 10;
        int max = 99;
        int random_number = (int)(Math.random()  (max - min) + min);
        Scanner n = new Scanner(System.in);
        System.out.println(Give number );
        int number = n.nextInt();
        System.out.println(Random number  +random_number);
        
        String input_given=String.valueOf(number);
        char[] input_givenToArray = input_given.toCharArray();
        int given_digit1=Integer.parseInt(String.valueOf(input_givenToArray[0]));
        int given_digit2=Integer.parseInt(String.valueOf(input_givenToArray[1]));
        
        String input_random=String.valueOf(random_number);
        char[] input_randomToArray = input_random.toCharArray();
        int random_digit1=Integer.parseInt(String.valueOf(input_randomToArray[0]));
        int random_digit2=Integer.parseInt(String.valueOf(input_randomToArray[1]));
        
        if(random_number == number)
        {
            System.out.println(Won 10000 euros);
        }
        else if(given_digit1 == random_digit2 && given_digit2 == random_digit1)
        {
            System.out.println(Won 3000 euros);
        }
        else if(given_digit1 == random_digit2  given_digit2 == random_digit1  given_digit2 == random_digit2  given_digit1 == random_digit1)
        {
            System.out.println(Won 1000 euros);
        }
        else
        {
            System.out.println(Not Won);
        }
    }
}
