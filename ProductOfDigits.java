import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class ProductOfDigits
{   

    public static void main(String args[])
    {
        try{
        int x, c;
        String result, s="";
        Scanner stdin = new Scanner (System.in);      
        int nr1 = stdin.nextInt();
        
         if (nr1==0)
        {
            System.out.println("10");  
            System.exit(0);
        }
        String nr1s = new Integer(nr1).toString();     
        BigInteger nr2 = new BigInteger(nr1s);
         if (nr1==1)
             {
                 System.out.println("1");
                 System.exit(0);
             }
//        for(int i=2;i<10;i++)
//        {
//            if (nr1 == i)
//            {
//                System.out.println("1"+i);
//                System.exit(0);
//            }
//        }
 /// ajunge aici
           for (int i=9;i>=2;i--)
           {             
              while (nr1%i==0)
              {
                  nr1 = nr1/i;
                  String I =  new Integer(i).toString();                  
                  s = s+""+I;
              }

              
           }
        StringBuffer ss = new StringBuffer(s);
        ss.reverse();
        if (nr1==1) System.out.println(ss);
        else System.out.println("-1");
        }catch(Exception e)
        {
          //  System.out.println(e);
        }
    }   
}
