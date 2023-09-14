class Didiastatos {
  public static void main(String[] args) {
    int[][] A;
 
    A = new int[10][10];
 
    for (int i=0;i<10;i++)
    {
        for (int j=0;j<10;j++)
        {
            A[i][j]= 0;
            System.out.println("A["+i+"]"+"["+j+"]= "+A[i][j]);
        }
    }
  }
}