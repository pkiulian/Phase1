import java.util.*; 
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Staircases{
	static long matrix[][] = new long[501][501];
	public static void main(String []args){
		String s="";
		int N;
		try{
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			s = bufferRead.readLine(); 	   
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		N = Integer.parseInt(s);
 		
		for (int i=2;i<=N;i++){
			int k=i-1;
			for (int j=1;j<=N;j++){						
				if (k+j==i && k>j){					
					matrix[i][j]=1+sum(k,j+1,N);
				}else{
					break;
				}
				k--;
			}
		}
		System.out.println(sum(N,0,N));
		//printMatrix(N, N);
		
		
	}
	public static long sum (int n, int m, int N){
		long result = 0;
		int k = m;
		do{
			result+=matrix[n][k];
			k++;
		}while (k<N && matrix[n][k]>0);
		return result;
	}
	public static void printMatrix(int N, int M){
		for (int i=1;i<=N;i++){
			for (int j=1;j<=M;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}	
