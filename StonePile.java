import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class StonePile {
	public static void main(String[] args){
		int resultFinal = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String a = br.readLine();
			int []vector = new int[N]; 	
			String[] tokens = a.trim().split("\\s+"); 
			int SUMA = 0;
			int target = 0;
			for (int i=0;i<N;i++){
				vector[i] = Integer.parseInt(tokens[i]);
				SUMA = SUMA+vector[i];
			}
			
			int n1 = 0;
			int n2 = 0;
			if (N%2 == 0){
				n1=N/2;
				n2=N-n1;
			}else if (N%2!=0){
				n1=(N-1)/2;
				n2= N-n1;
			}			
			int []v1 = new int[n1];
			int []v2 = new int[n2];
			for (int i=0;i<n1;i++){
				v1[i]=vector[i];
			}			
			int k=0;
			for (int i=n1;i<N;i++){				
				v2[k] = vector[i];
				k++;
			}
			int sizeSuma1 = (int) Math.pow(2, n1);
			int sizeSuma2 = (int) Math.pow(2, n2);
			int []s1 = new int[sizeSuma1];
			int []s2 = new int[sizeSuma2];
			s1 = createSuma(v1, n1);
//			for(int i=0;i<s1.length;i++){
//				System.out.println("s1: "+s1[i]);
//			}
			s2 = createSuma(v2, n2);
//			for(int i=0;i<s2.length;i++){
//				System.out.println("s2: "+s2[i]);
//			}
			target = SUMA/2;			
			int min1 = 0x7fffffff;
			int r1=0;
			int kr1 = 0;
			for (int i=0;i<s1.length;i++){
				for(int j=0;j<s2.length;j++){
					r1= s1[i]+s2[j];
					if (min1 > Math.abs(target-r1)){
						min1 = Math.abs(target-r1);
						//System.out.println(" r1 "+r1);
						kr1 = r1;						
						if (min1==0) break;							
					}
				}
				if (min1==0) break;
			}
		//	System.out.println("target "+target);					
		//	System.out.println("min1 "+min1);
			int r2=0;
			int kr2 = 0;
			int min2 = 9999999;
			for (int i=0;i<s1.length;i++){
				for(int j=0;j<s2.length;j++){
					r2 = s1[i]+s2[j];
					//System.out.println("r2: "+r2);
					if (min2 > Math.abs(target-r2) && kr1+r2==SUMA ){
						min2 = Math.abs(target-r2);
					//	System.out.println("r2: "+r2+" kr1 "+kr1);
						kr2 = r2;						
						if (min2==0) break;							
					}
				}
				if (min2==0) break;
			}
			//System.out.println("min2 "+min2);
			resultFinal = min1+min2;
			System.out.println(resultFinal);		
		} catch (NumberFormatException e) {		
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

	private static int[] createSuma(int[] v1, int n1) {
		
		int n = (int)Math.pow(2, n1);
		int []result = new int[n];			
		String bin = "";
		int sumforZ = 0;	
		for(int i=0;i<n;i++){
			bin = ConvertToBinary(i, v1.length);
			//System.out.println("bin: "+bin);
			sumforZ = 0;			
			for (int j=0; j<n1; j++){
				if (bin.charAt(j)=='0')
					sumforZ = sumforZ + v1[j];				
			}
			result[i] = sumforZ;
		}
		
		return result;
	}

	private static String ConvertToBinary(double i, int N) {
		String result = "";		
		while (i>=1){
			String n = Integer.toString((int)i%2);
			result = result + n;
			i = i/2;
		}		
		result = RevertString(result);
		while(result.length()<N){
			result = 0+""+result;
		}
		return result;		
	}
	
	private static String RevertString(String source) {
		String dest ="";
	 	int i, len = source.length();		    
	    for (i = (len - 1); i >= 0; i--){
	      dest= dest+source.charAt(i);
	    }
	    return dest.toString();
	}	

	
}
