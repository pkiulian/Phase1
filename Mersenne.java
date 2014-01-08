import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.*;
import java.util.*; 

public class Mersenne {
		public static void main(String[] args){
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s;	
			int t;	
			try {
				s = br.readLine();
				t = Integer.parseInt(s.trim());
				int []N = new int[t];
				int []nr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38};
				int []result = {2,3,5,7,13,17,19,31,61,89,107,127,521,607,1279,2203,2281,3217,4253,4423,9689,9941,11213,19937,21701,23209,44497,86243,110503,132049,216091,756839,859433,1257787,1398269,2976221,3021377,6972593};
				for (int i=0;i<t;i++){
					s = br.readLine().trim();  
					N[i] = Integer.parseInt(s);					
				}
				for (int i=0;i<t;i++){
					for (int j=0;j<nr.length;j++)
					if (N[i]==nr[j]){
						System.out.println(result[j]);
						break;
					}
				}				
			}catch(IOException e){
				e.printStackTrace();		
			}
		}
}