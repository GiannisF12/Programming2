import java.util.Scanner;
public class askisi9 {
  static void myMethod()
  {
    int i;
    double sum=0.0;
    Scanner input=new Scanner(System.in);
    double[] a=new double[3];
    for(i=0;i<a.length;i++)
    {
      a[i]=input.nextDouble();
      sum=sum+a[i];
    }
    input.close();
    System.out.println("sum:"+sum);
  }

  public static void main(String[] args) {
    myMethod();
  }
}
