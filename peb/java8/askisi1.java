import java.util.Random;
import java.util.Scanner;
public class askisi1 
{
    public static void main(String[] args)
    {
        int count=0,min=1,max=49;
        for(int i=0;i<5;i++)
        {
            Scanner scan=new Scanner(System.in);
            System.out.print("Enter Number: ");
            int input=scan.nextInt();

            Random r =new Random();
            int guess= r.nextInt(max-min) + min;

            if(input==guess)
            {
                count++;
                System.out.println("Found 1 Number");
            }
            else
            {
                System.out.println("Not Found");
            }
        }

        if(count==6)
        {
            System.out.println("You Won.");
        }
        else
        {
            System.out.println("You lost.");
        }
        System.out.println("Your Score is " +count+"/6.");
    }
    
}
