import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Maximum
{
   public static void main(String args[])
   {
       int nr, n, j, i, max=0;
       boolean t;
       int [] vn = new int[11];    
       t=true;
       nr=0;
       i=0;
       n=1;
    try
       {
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            while  ((nr<=10)&&(t==true))
            {
                vn[nr] = Integer.parseInt(stdin.readLine());
                if (vn[nr]==0) {t=false;}
                nr++;
       
            }
           
       }catch(Exception e)
        {
            e.getMessage();
	}
       finally
       {
           nr--;
           if(vn[nr]==0)
           {
            for (j=0;j<=nr;j++)
            {
                max=0;
                if ((vn[j]<100000)&&(vn[j]!=0))
                {
                    int [] a = new int[vn[j]+1]; 
                    a[0]=0;
                    a[1]=1;
                    for (i=0;i<=vn[j];i++)
                    {                            
                            if (max<a[i]){max=a[i];}
                            if (2*i<=vn[j])
                            {
                                a[2*i] = a[i];     
                                if (max<a[2*i]){max=a[2*i];}
                            }
                            if(2*i+1<=vn[j])
                            {
                                a[2*i+1] = a[i] + a[i+1];
                                if (max < a[2*i+1]){max=a[2*i+1];}
                            }                                                  
                    }
                   System.out.println(max);
              //     for (i=0;i<=vn[j];i++)
              //     {
              //      System.out.print(a[i]+" ");
              //     }
                } 
               
            }
           }        
       }             
   }
}




