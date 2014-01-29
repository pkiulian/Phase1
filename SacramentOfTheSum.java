import java.io.*;
import java.util.*;

public class SacramentOfTheSum 
{
   
    public static void SacramentOfTheSum(String args[])
    {
        try{
        int i, j;                   
        Scanner stdin = new Scanner (System.in);
      //  BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int nr1 = stdin.nextInt();
        int v1[] = new int[nr1];
        for (i=0;i<nr1;i++)
        {
            v1[i] = stdin.nextInt();           
        }
        
        int nr2 = stdin.nextInt();       
        int v2[] = new int[nr2];
        for (i=0;i<nr2;i++)
        {
            v2[i] = stdin.nextInt();            
        }
        i=0;
        j=0;
        boolean b=false;
        while((i<nr1)&&(j<nr2))
        {
            if (v1[i]+v2[j]==10000)
            {
                b=true;
                System.out.println("YES");               
                break;
            }
            if (v1[i]+v2[j]<10000)
            {
                i++;
            } 
            else
            {
                j++;
            }         
        }
    //    System.out.println(b);
        if (b==false)
        {
            System.out.println("NO");
        }
        }catch(Exception e)
        {
//            System.out.println(e.getMessage());
//            System.out.println(e.getStackTrace());    
            // wrong ans 10
        }
    }
}
