import java.util.Random;
public class askisi11 
{
    static void Method()
    {
        int[] array = new int[100];
        System.out.println("Random number array...");
        for (int i = 0; i < array.length; i++) 
        {
            array[i] = new Random().nextInt(100);
        }
  }

   public static void main(String[] args) 
    {
        Method();     
    }
}