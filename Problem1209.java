import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.text.*;

public class Problem1209{
	public static void main(String[] args){
		InputStreamReader isr1 = new InputStreamReader(System.in);
		BufferedReader br1 = new BufferedReader(isr1);		
		int N; String s;
		double deltaNUmber;
		try{
			// Reading from the input 
			s = br1.readLine();
			String parts = s.trim();
			N=Integer.parseInt(parts);
			int []result=new int[N];
			long[] numbers = new long[N];
			for(int i=0;i<N;i++){
				s = br1.readLine();				
				numbers[i]=Long.valueOf(s.trim());				
			}
			for(int i=0;i<N;i++){
				numbers[i] = (numbers[i]-1)*2;
				deltaNUmber = 1-4*(0-numbers[i]);
				if (deltaNUmber>=0){
				  double sqrtDelata = Math.sqrt(deltaNUmber);				
				  if (Math.floor(sqrtDelata)==sqrtDelata){
					result[i] = 1;
				  }
				  else{
					result[i] = 0;
				  }
				}else{
					result[i] = 0;
				}
			}				
			for (int i = 0; i < result.length; i++) {
			    System.out.print(result[i]);
			    System.out.print(' ');
			}
		}catch(IOException e){
			e.printStackTrace();
		}  
	}
}