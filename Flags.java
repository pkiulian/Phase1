import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String []args){	
		try{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();		
		int n = Integer.parseInt(input.trim());
		long []F = new long [(n+1)];
		F[0] = 0;
		F[1] = 2;		
		for (int i=2;i<=n;i++){
			F[i]=F[i-1]+F[i-2];
		}
		System.out.println(F[n]);
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
}
