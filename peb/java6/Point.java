import java.util.Scanner;
public class Point 
{
    public static void main(String[] args) 
    {
        int[][] a=new int[10][100];

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter x:");
        int i = scan.nextInt();
        System.out.println("Enter y:");
        int j = scan.nextInt();
        scan.close();

        System.out.println(a[i][j]);
    }



}