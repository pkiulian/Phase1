/**Important! start and end of a seg. can't take the same value*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;

public class Cover {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			int[] b = new int[n];
			int[] mask = new int[n];		
			Hashtable<Integer,Integer> segments = new Hashtable<Integer,Integer>(); 
			int m = n;
			for (int i = 0; i < n; i++) {
				String[] s = (br.readLine()).split("\\s+");
				a[i] = Math.min(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				b[i] = Math.max(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				for (int j = 0; j < i; j++) {
					if (a[i] == a[j] && b[i] == b[j] && i != j) {
						a[i] = -99999;
						b[i] = -99999;
						m--;
					}
				}
				segments.put(a[i], b[i]);							
			}
			mask =  setMask(mask, a, b);	
			if (m > 1) {												
				int max = 0;
				for(int i=0;i<n;i++){
					if (mask[i]>max)
						max= mask[i];
				}				
				System.out.println(n-(max)+" max "+max);
			} else {
				int count = 1;
				System.out.println(count);
			}
		} catch (IOException e) {
			System.out.println("exception");
		}
	}

	private static int[] firstSet(int[] mask) {
		for (int i=0;i<mask.length;i++){
			if (mask[i]!=-1)
				mask[i]=0;
		}
		return mask;
	}
	

	private static int[] setMask(int[] mask, int[] a, int[] b) {
		for (int i = 0; i < mask.length; i++) {
			for (int j = 0; j < mask.length; j++) {
				if (i != j && a[i] != -99999 && b[i] != -99999 && mask[i]>=0 && mask[j]>=0) {
					if (a[i] > b[j]) {								
					} 
					if (a[i] == b[j]) {
						mask[i]++;
					}
					if (a[i] < b[j] && a[i] > a[j] && b[j] <= b[i]) {
						mask[i]++;
					}
					if (a[i] > a[j] && b[i] < b[j]) {
						mask[i]++;
					} 
					if (a[i] <= a[j] && b[i] >= b[j]) {
						mask[i]++;
					} 
					if (a[i] <= a[j] && b[j] > b[i] && b[i] > a[j]) {
						mask[i]++;
					}
					if (b[i] == a[j]) {
						mask[i]++;
					}
					if (b[i] < a[j]) {						
					}
				}
			}
		}
		return mask;
	}

	private static boolean checkMatrix(int[] v) {
		for (int i=0;i<v.length;i++){
			if (v[i]>0)
				return true;
		}
		return false;
	}

	public static boolean visitedFunc(int[] visited) {
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				return false;
			}
		}
		return true;
	}
}
