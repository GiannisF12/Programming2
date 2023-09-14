public class askisi2
{
  public static void main (String [] args)
  {
    Straightline e1=new Straightline(1,5,8,2);
	Point p1=new Point(2,3);
	Point p2=new Point(5,6);
	Straightline e2=new Straightline(p1,p2);
	
	System.out.println("the first line has length of" + e1.length() + "points");
	
	Point c=e1.getPointA();
	c.x=5;
	System.out.println("the x coordinate of c=" + c.x + "and the x coordinate of d=" + d.x );
	
	
	}
}