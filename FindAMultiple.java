
/*this is a good solution but the Time is exceeded for test 34. I might do this in C or C++ in order to work.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class FindAMultiple {
	public static void main(String [] args){
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int []a = new int[N];
		int []b = new int[N+1];
		b[0]=0;	
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			a[i]=number;
			sum  = sum + number;			
			b[i+1]=sum%N;	
		}	
		int []v = new int[2];
		v = getPositionOfEqualValues(a, b);			
		System.out.println(v[1]-v[0]);
		for (int i=v[0]+1;i<=v[1];i++){		
			System.out.println(a[i]);
		}		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int[] getPositionOfEqualValues(int []a, int []b) {
		int []result = new int[2];
		for (int i=0;i<b.length-1;i++){
			for (int j=i+1;j<b.length;j++){
				if (b[i]==b[j]){
					result[0] = i-1;
					result[1] = j-1;
					return result;		
				}					
			}
		}
		return result;
	}
}
