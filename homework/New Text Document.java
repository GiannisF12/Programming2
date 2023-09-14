import java.util.Scanner;
import java.lang.Math;

public class Homework_task1 
{
    public static void main(String[] args)
    {
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("Dwse a");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        
        System.out.println("Dwse b");
        int b = input.nextInt();
        
        System.out.println("Dwse c");
        int c = input.nextInt();
        
        float d = b^2 - (4*a*c);
        
        if(d>0)
        {
            double x1 = (-b + Math.sqrt(d))/2*a;
            double x2 = (-b - Math.sqrt(d))/2*a;
            System.out.println("Duo Rizes: "+x1+" kai "+x2);
        }
        else if(d == 0)
        {
            double x = (-b)/2*a;
            System.out.println("Diplh Riza "+x);
        }
        else
        {
            System.out.println("Den uparxoun rizes");
        }
    }
}
