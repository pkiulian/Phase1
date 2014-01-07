

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CopyOfCopyOfCover {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			int[] b = new int[n];
			DataMask.mask = new int[n];
			//int maxConsidered = 0;
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
//				if (maxConsidered < b[i])
//					maxConsidered = b[i];
			}
			
			DataMask.mask =  setMask(DataMask.mask, a, b);
			DataMask.mat = setMat(DataMask.mask, a, b);
							
			if (m > 1) {
				int count = 0;		
				int k=0;
				while (DataMask.mat.size()>0){
					int max = -1;
					int index = -1;
					for (int i=0;i<DataMask.mat.size();i++){
						if (max<DataMask.mat.get(i).size()){
							max = DataMask.mat.get(i).size();
							index = i;
						}					
					}
					if (max==-1 || index==-1)
						break;
					
					for (int i=0;i<DataMask.mat.size();i++){
						if (DataMask.mat.get(i).size()==0){
							DataMask.mat.remove(i);						
							i--;													
						}
					}
					for (int i=0;i<DataMask.mat.size();i++){
						for (int j=0;j<DataMask.mat.get(i).size();j++){
							if (DataMask.mat.get(i).get(j)==index+k){
								DataMask.mat.get(i).remove(j);
								j--;
							}
						}
					}
					for (int i=0;i<DataMask.mat.size();i++){
						if (DataMask.mat.get(i).size()==0){
							DataMask.mat.remove(i);												
							i--;													
						}
					}					
					DataMask.mat.remove(index);		
					k++;
					count++;					
				}											
				System.out.println(n-count);
			} else {
				int count = 1;
				System.out.println(count);
			}
		} catch (IOException e) {
			System.out.println("exception");
		}
	}

	private static ArrayList<ArrayList<Integer>> setMat(int[] mask, int[] a, int[] b) {
		
		int[] maskaux = new int[mask.length];
		int[] aaux = new int[a.length];
		int[] baux = new int[b.length];
		
		int k=0;
		while(checkMask(mask)){
			int max = -1;
			int index = -1;
			for (int i=0;i<mask.length;i++){
				if (mask[i]>max){
					max = mask[i];
					index = i;
				}
			}
			if (max==-1)
				break;
			maskaux[k]=mask[index];
			aaux[k]=a[index];
			baux[k]=b[index];
			mask[index]=-1;
			k++;
		}
				
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < maskaux.length; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();  
			for (int j = 0; j < maskaux.length; j++) {
				if (i != j && aaux[i] != -99999 && baux[i] != -99999 && maskaux[i]>=0 && maskaux[j]>=0) {
					if (aaux[i] > baux[j]) {								
					} 
					if (aaux[i] == baux[j]) {
						list.add(j);
					}
					if (aaux[i] < baux[j] && aaux[i] > aaux[j] && baux[j] <= baux[i]) {
						list.add(j);
					}
					if (aaux[i] > aaux[j] && baux[i] < baux[j]) {
						list.add(j);
					} 
					if (aaux[i] <= aaux[j] && baux[i] >= baux[j]) {
						list.add(j);
					} 
					if (aaux[i] <= aaux[j] && baux[j] > baux[i] && baux[i] > aaux[j]) {
						list.add(j);
					}
					if (baux[i] == aaux[j]) {
						list.add(j);
					}
					if (baux[i] < aaux[j]) {						
					}
				}
			}
			result.add(list);
		}
		return result;
	}

	

	private static boolean checkMask(int[] mask) {
		for (int i=0;i<mask.length;i++)
			if (mask[i]>0)
				return true;
		return false;
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

	public static boolean visitedFunc(int[] visited) {
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				return false;
			}
		}
		return true;
	}
}

class DataMask{
	static int[] mask;
	static ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();   
}
