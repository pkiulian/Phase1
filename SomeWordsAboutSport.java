import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.text.*;

public class SomeWordsAboutSport{
	public static void main(String[] args){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);		
		String s;
		int N;
		try {
			s = br.readLine();
			N = Integer.parseInt(s.trim());
			int [][]matrix = new int[N][N];			
			for (int i=0;i<N;i++){	
				s = br.readLine();			
				String[] line = s.trim().split("\\s+");
				for (int j=0;j<N;j++){
					matrix[i][j]=Integer.parseInt(line[j]);
				}
			}
			//printMatrix(matrix, N);
			for (int k=0;k<N;k++){
				int j=0;
				for (int i=k;i>=0;i--){
					System.out.print(matrix[i][j]+" ");
					j++;
				}
			}
			//System.out.println();
			int t=1;
			int k= 0;
			for (int i=N-1;i>=0;i--){				
				k=N-1; 
				//System.out.println("t:"+t+" i:"+i);
				for (int j=t;j<N;j++){										
					System.out.print(matrix[k][j]+" ");	
					k--;
				}
				t++;
			}
		}catch(IOException e){
            e.printStackTrace();
        }  
	}
	public static void printMatrix(int [][]matrix, int N){	
		for (int i=0;i<N;i++){
			for (int j=0;j<N;j++){			
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
