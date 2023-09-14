public class Straightline
{
  private Point a,b;
  
  public Straightline (int x1, int y1,int x2,int y2)
  {
    this.a=new Point(x1,y1);
	  this.b=new Point(x2,y2);
  }
  
  public Straightline(Point a, Point b)
  {
    this.a=new Point(a.x,a.y);
	  this.b=new Point(b.x,b.y);
  }
  
  public double length()
  {
    double d1=a.x-b.x;
	  double d2=a.y-b.y;
	  double valueoflength=Math.sqrt(d1*d1+d2*d2);
	  return valueoflength;
  }
  
  public getPointA()
  {
    Point first=new Point(a.x,a.y);
	  Point first =a;
	return first;
  }
  public getPointB()
  {
    Point second=new Point(b.x,b.y);
	  return second;
  }
  public String toString()
  {
    return "line from" + a.toString() + "to" + b.toString();
  }
 }