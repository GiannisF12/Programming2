import java.util.Random;
class askisi5 {
    public static void main(String[] args) 
    {
        int[][] a=new int[3][3];
        int i,j;
        Random number = new Random();
        for(i=0;i<a.length;i++)
        {
            for(j=0;j<a.length;j++)
            {
                a[i][j]=number.nextInt();
                System.out.println(a[i][j]); 
            }

        }
    }
}