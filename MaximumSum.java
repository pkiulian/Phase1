
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class MaximumSum {
    public static void main(String[] args) {
        String s ="";
          try{
              int N=0;
              InputStreamReader isr1 = new InputStreamReader(System.in);
              BufferedReader br1 = new BufferedReader(isr1);
              s = br1.readLine();
              N = Integer.parseInt(s.trim());
              N = N+1;
              int [][]M = new int[N][N-1];
             
              M = getMatrix(s, N, isr1, br1); 
             // printMatrix(M,N,N);
              int n=1;
              int m=1;
              int result = 0;
              int max = -1000;
        
              for (int x1=1;x1<N;x1++){            	  
                  for (int y1=0;y1<N-1;y1++){
               // 	  System.out.println(M[x1][y1]+","+M[x1-1][y1]);
                	  M[x1][y1] = M[x1][y1]+M[x1-1][y1];
                  }
              }
           //   printMatrix(M,N,N);
              //System.out.println();
              max = M[1][0];             
              for (int k=1;k<N;k++){
                  for (int i=0;i<N-k;i++){                	  
                	//  System.out.println("k: "+k+" i: "+i);
                	  int t = 0;
                	  for(int j=0;j<N-1;j++){             
                		//  System.out.println(M[i+k][j]+" - "+M[i][j]);
                		  if (t>=0){ t+=M[i+k][j]-M[i][j];}
                		  else{
                			  t=M[i+k][j]-M[i][j];
                		  }
                		  if (max<t) max = t;
                	  }                    	  
                  }                 
               }
              
              
           //   printMatrix(S,N,N);
              result = max;
    
             System.out.println(result);
         
          }catch(IOException e){
                e.printStackTrace();
            }  
    }

    private static int[][] transpose(int[][] M, int n1, int n2) {
        int [][]MT = new int[n2][n1];
        for (int i=0;i<n1;i++){           
            for (int j=0;j<n2;j++){
                MT[j][i] = M[i][j];               
            }
        }
        return MT;
    }

    private static void printMatrix(int[][] M, int n1, int n2) {
         System.out.println();
         for (int i=0;i<n1;i++){
             for (int j=0;j<n2-1;j++){
                 System.out.print(M[i][j]+"  ");
             }
             System.out.println();
         }
    }

    private static int[][] getMatrix(String s, int N, InputStreamReader isr1, BufferedReader br1) throws IOException {               
         int [][]M = new int[N][N-1];
         int k=1;
         while(k<N){
               s = br1.readLine();                              
               String[] parts = s.trim().split("\\s+");
               for (int i=0;i<N-1;i++)
                       M[k][i]=Integer.parseInt(parts[i]);
               k++;
         }
         return M;
    }
}
