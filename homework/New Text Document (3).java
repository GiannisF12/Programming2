import java.util.Scanner;
import java.lang.Math;

public class Homework_task2v2 
{
    public static void main(String[] args)
    {
        int min = 10;
        int max = 99;
        int random_number = (int)(Math.random() * (max - min) + min);
        
        Scanner input = new Scanner( System.in );
        int number;
        int flag = 0;
        do 
        {
            System.out.println( "Enter Number:" );
            number = input.nextInt();
            if(number > 9 && number < 100)
            {
                flag = 1;
            }
        } 
        while (flag == 0); 
       
        System.out.println("Generated Number: " +random_number);
        
        int given_digit1= number % 10;
        int given_digit2= number / 10;
        
        int random_digit1= random_number % 10;
        int random_digit2= random_number / 10;
        
        if(random_number == number)
        {
            System.out.println("Won 10000 Euros");
        }
        else if(given_digit1 == random_digit2 && given_digit2 == random_digit1)
        {
            System.out.println("Won 3000 Euros");
        }
        else if(given_digit1 == random_digit2 || given_digit2 == random_digit1 || given_digit2 == random_digit2 || given_digit1 == random_digit1)
        {
            System.out.println("Won 1000 Euros");
        }
        else
        {
            System.out.println("Not Won");
        }
    }
}

