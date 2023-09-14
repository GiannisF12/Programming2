import java.util.Random;
class askisi2 {
    public static void main(String[] args) 
    {
        int[] a=new int[10];
        int i;
        Random number = new Random();
        //int num2 = scan.nextInt();
        for(i=0;i<a.length;i++)
        {
            //a[i]=i+1;
            a[i]=number.nextInt();
            System.out.println(a[i]); 
        }
    }
}