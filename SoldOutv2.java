import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SoldOutv2 {
	public static void main(String[] args){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			String s = br.readLine();
			String nk[]= s.split("\\s+");
			int n = Integer.parseInt(nk[0]);
			int k = Integer.parseInt(nk[1]);
			int m = n/2;
			if (n>2){
				if (k<=m){				
					int a = (Math.max(k,n-k));
					a = a-2;
					System.out.println(a);
				}else{										
					int a = (Math.max(k,n-k));
					a = a-3;
					System.out.println(a);
				}
			}
			else{
				System.out.println("0");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
