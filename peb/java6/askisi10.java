import java.util.Scanner;
public class askisi10 {
  static int Method(int input,int value)
  {
    if(input>value)
    {
        input=0;
        System.out.println("input>value");
    }
    return input;
  }

  public static void main(String[] args) 
  {
    int i;
    Scanner scan=new Scanner(System.in);
    int[] input=new int[3];
    System.out.println("Enter Value:");
    int value=scan.nextInt();
    for(i=0;i<input.length;i++)
    {
        System.out.println("Enter "+i+" of array:");
        input[i]=scan.nextInt();
        Method(input[i],value);
    }
    scan.close();
  }
}