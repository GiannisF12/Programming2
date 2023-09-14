import java.lang.Integer;
public class askisi8{
     public static void main(String []args){
        String txt = "123";
        char txt1=txt.charAt(0);
        char txt2=txt.charAt(1);
        char txt3=txt.charAt(2);
        double i = Double.parseDouble(txt);
        int a=Integer.parseInt(String.valueOf(txt1));
        int b=Integer.parseInt(String.valueOf(txt2));
        int c=Integer.parseInt(String.valueOf(txt3));
        double max=-1;
        if(a<b)
        {
            max=b;
        }
        if(b<c)
        {
            max=c;
        }
        if(c<a)
        {
            max=a;
        }
        System.out.println("The max of the number is: "+max);
        if(i<(max/1000))
        {
            System.out.println(+i+"Smaller than "+max/1000);
        }
        else if(i>(max/1000))
        {
            System.out.println(+i+" Bigger than "+max/1000);
        }
     }
}

//askisi8 kai askisi9 mazi