import java.lang.Math;
import java.util.Scanner;
class askisi7
{
    static int number=0;
    public static void main(String []args)
    {
        int a = (int) (Math.random() * 10);
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = scan.nextInt();
        //System.out.println(a);
        int flag=0;
        if(num==a)
        {
            System.out.print("You Won");
        }
        else
        {
            System.out.print("Try Again\n");
            while(flag==0)
            {
                System.out.print("Enter number: ");
                int num2 = scan.nextInt();
                if(num2==a)
                {
                    flag=1;
                    System.out.print("You Won");
                }
                else if(num2>a)
                {
                    System.out.print("Your number is bigger than the random one\n");
                }
                else if(num2<a)
                {
                    System.out.print("Your number is smaller than the random one\n");
                }
            }
        }
    }
}