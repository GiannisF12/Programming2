class askisi3 {
    public static void main(String[] args) 
    {
        int[] a=new int[10];
        int i,sum=0;
        for(i=0;i<a.length;i++)
        {
            a[i]=i+1;
            sum=sum+a[i];
        }
        System.out.println(sum); 
    }
}