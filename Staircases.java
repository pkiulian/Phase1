import java.util.*; 
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * @author peca
 *
 */
public class Staircases{	
	public static void main(String []args){
		long matrix[][] = new long[501][501];
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
 		matrix = computeMatrix(matrix, N);					
		System.out.println(sum(matrix, N,0,N));
			
	}
	
	private static long[][] computeMatrix(long[][] matrix, int N) {
		for (int i=2;i<=N;i++){
			int k=i-1;
			for (int j=1;j<=N;j++){						
				if (k+j==i && k>j){					
					matrix[i][j]=1+sum(matrix, k,j+1,N);
				}else{
					break;
				}
				k--;
			}
		}
		return matrix;
	}

	public static long sum (long[][] matrix, int n, int m, int N){
		long result = 0;
		int k = m;
		do{
			result+=matrix[n][k];
			k++;
		}while (k<N && matrix[n][k]>0);
		return result;
	}
}	
