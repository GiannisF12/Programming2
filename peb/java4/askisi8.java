import java.lang.Math;
import java.util.Scanner;
class askisi8
{
    static int number=0;
    static void create()
    {
        Scanner scan = new Scanner(System.in);
    }
    static void print()
    {
        System.out.print("Enter number: ");
    }
    static int enter()
    {
        Scanner scan = new Scanner(System.in);
        int num2 = scan.nextInt();
        //scan.close();
        return num2;
    }

    public static void main(String []args)
    {
        int a = (int) (Math.random() * 10);
        create();
        print();
        int num=enter();
        System.out.println(a);
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
                print();
                num=enter();
                if(num==a)
                {
                    flag=1;
                    System.out.print("You Won");
                }
                else if(num>a)
                {
                    System.out.print("Your number is bigger than the random one\n");
                }
                else if(num<a)
                {
                    System.out.print("Your number is smaller than the random one\n");
                }
            }
        }
    }
}