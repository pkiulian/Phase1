import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.text.*;

public class LonesomeKnight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);	
		String s;
		int k = 0;
		int N=12;
		int [][]table = new int[N][N];
		char []alphabet ={'a','b','c','d','e','f','g','h'};
		int []numbers = {2,3,4,5,6,7,8,9};
		table = init(table, N, N);
		//printMatrix(table, N, N);
		
		try{	
			s = br.readLine().trim();
			k=Integer.parseInt(s);
			int caluti = k;
			int[] result = new int[caluti];
			while (k>0){
				s = br.readLine().trim();
				int col = 0;
				int line = 0;
				for (int i=0;i<2;i++){				
					if (i==0){
						col = (int) s.charAt(i)-97+2;
						//System.out.println("col: "+col);
					}else{
						line = Character.getNumericValue(s.charAt(i))+1;
						//System.out.println("line: "+line);
					}
				}							
				table[line][col] = table[line][col]+1;
				k--;
			}
			
//			printMatrix(table, N, N);
			int contor = 0;
		//	k = caluti;
			//while (k>0){	
			//	System.out.println("contor "+contor);
				for (int i = 2; i < N - 2; i++) {
					for (int j = 2; j < N - 2; j++) {
						int[] v = new int[8];
						//System.out.println("bla");
						if (table[i][j] != 0 && table[i][j] != 1) {						
							v[0] = table[i - 1][j + 2];						
							v[1] = table[i - 2][j + 1];
							v[2] = table[i - 2][j - 1];
							v[3] = table[i - 1][j - 2];
							v[4] = table[i + 1][j + 2];
							v[5] = table[i + 1][j - 2];
							v[6] = table[i + 2][j - 1];
							v[7] = table[i + 2][j + 1];
					
							for (int p=0;p<8;p++){
								if (v[p]!=0){
								//	System.out.println("v["+p+"]: "+v[p]);
									result[contor]++;
								}
							}
							contor++;
						}						
					}
				}
				
		//		contor++;
		//		k--;
		//	}
			for (int i=0;i<caluti;i++){
				System.out.println(result[i]);
			}
		}catch(IOException e){
			e.printStackTrace();
		} 

		
		
	}

	private static void printMatrix(int[][] table, int n1, int n2) {
		for (int i=0;i<n1;i++){
			for (int j=0;j<n2;j++){
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static int[][] init(int[][] table, int n1, int n2) {		
			for (int i=2;i<n1-2;i++){
				for (int j=2;j<n2-2;j++){
					table[i][j] = 1;
				}
			}
		return table;
	}

}
