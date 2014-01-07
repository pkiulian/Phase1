import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


public class Problem1263Elections{
	public static void main(String[] args){
		int N=1; 
		int M=1;
		String s;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try{
			s = br.readLine();
			String[] parts = s.trim().split("\\s+");
			N = Integer.parseInt(parts[0]);
			M = Integer.parseInt(parts[1]);
			int[] vector = new int[M];
			s = br.readLine();
			int index = 0;
			int k=0;
			while(M>k){
				vector[index]=Integer.parseInt(s);				
				index++;
				s = br.readLine();
				k++;
				if (k==M || s.length()==0)
					break;
			}
			double[] sum = new double[N];
			for (int i=0;i<vector.length;i++){
				for (int j=0;j<N;j++){
					if (vector[i]==j+1)
						sum[j]++;
				}
			}					
			for (int i=0;i<N;i++){
				DecimalFormat df = new DecimalFormat("####0.00");
				System.out.println(df.format((sum[i]/(double)M)*100)+"%"); //how to write this only with 2 decimals?
			}
		}catch(IOException e){
			e.printStackTrace();
		}
			
	}
}