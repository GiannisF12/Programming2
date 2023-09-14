class askisi4 {
    public static void main(String[] args) 
    {
        int[] a=new int[10];
        int i,max=-999999,position=0;
        for(i=0;i<a.length;i++)
        {
            a[i]=i+1;
            if(max<a[i])
            {
                max=a[i];
                position=i;
            }
        }
        System.out.println("max value is: "+max+" in position: "+position); 
    }
}