class askisi6 {
    public static void main(String[] args) 
    {
        int[][] a=new int[3][3];
        int i,j,sum=0;
        for(i=0;i<a.length;i++)
        {
            for(j=0;j<a.length;j++)
            {
                a[i][j]=i+1;
                sum=sum+a[i][j];
            }
        }
        System.out.println(sum); 
    }
}