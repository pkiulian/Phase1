import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.*;
import java.util.*; 

public class Eniya {
		public static void main(String[] args){
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s;				
			int result = 2;
			try {
				s = br.readLine();  
				String[] parts = s.trim().split("\\s+");
				int[]vector = new int[parts.length];
				for (int i=0;i<parts.length;i++){
					vector[i]=Integer.parseInt(parts[i]);
				}
				for (int i=0;i<parts.length;i++){
					result *= vector[i];
				}
				System.out.println(result);
			}catch(IOException e){
				e.printStackTrace();		
			}
		}
}