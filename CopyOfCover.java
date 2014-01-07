/**Important! start and end of a seg. can't take the same value*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CopyOfCover {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			int[] b = new int[n];
			int maxConsidered = 0;
			
			ArrayList<Pair> segments = new ArrayList<Pair>(); 
			int m = n;
			for (int i = 0; i < n; i++) {
				String[] s = (br.readLine()).split("\\s+");
				a[i] = Math.min(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				b[i] = Math.max(Integer.parseInt(s[0]), Integer.parseInt(s[1]));	
				Pair p = new Pair();
				p.a = a[i];
				p.b = b[i];
				segments.add(p);	
				if (maxConsidered < b[i])
					maxConsidered = b[i];
			}
			
			
			if (m > 1) {	
				int[] mask = new int[maxConsidered+1];					
				mask =  setMask(mask, segments, maxConsidered);		
				System.out.println();
				for (int i=0;i<mask.length;i++)
					System.out.print(mask[i]+" ");
				System.out.println();
				int max =0;
				for (int i=0;i<mask.length;i++){
					if (max<mask[i]){
						max=mask[i];
					}
				}
				if (max>0){
					System.out.println(n-max+1);
				}else {
					System.out.println(n);
				}
			} else {
				int count = 1;
				System.out.println(count);
			}
		} catch (IOException e) {
			System.out.println("exception");
		}
	}

	private static int[] setMask(int[] mask, ArrayList<Pair> segments, int maxConsidered) {
		for (int i=0;i<segments.size();i++){
			for (int j=segments.get(i).a;j<=segments.get(i).b;j++)
			mask[j]++;			
		}
		return mask;
	}	
}


class Pair{
	public int a;
	public int b;
	public int getA(){
		return a;
	}
	public int getB(){
		return b;
	}
}