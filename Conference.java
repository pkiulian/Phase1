import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Conference{
	public static void main(String[] args){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try{
			int n=Integer.parseInt(br.readLine());
			ArrayList<Integer> a = new ArrayList<Integer>();
			ArrayList<Integer> b = new ArrayList<Integer>();			
			for (int i=0;i<n;i++){
				String[] s = (br.readLine()).split("\\s+");
				int av = Math.min(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				int bv = Math.max(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				boolean noRepetition = true;
				for (int j=0;j<i;j++){
					if (av==a.get(j) && bv==b.get(j)){
						noRepetition = false;
						break;
					}
				}
				if (noRepetition){
					a.add(av);
					b.add(bv);					
				}
			}
			ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
			matrix = getMatrixWithDiffLineSizes(a, b);
			matrix = orderEachLine(matrix);
		    printListMatrix(matrix);
			int result = getFinalResult(matrix);
			System.out.println(result);
			
		}catch(IOException e){
			System.out.println("Got an exception");
		}
	}
	// this to work on still!! Only this function
	static int getFinalResult(ArrayList<ArrayList<Integer>> matrix){
		int result = 0;
		int line =0;
		int curr =0;
		int []mask = new int[matrix.size()];
		while(line<matrix.size()-1){
			if (mask[line]==0)
				curr = matrix.get(line).get(1);
			line++;
			if ((matrix.get(line-1).get(0)<matrix.get(line).get(0) && matrix.get(line-1).get(1)>matrix.get(line).get(1) && mask[line]==0)||(curr==matrix.get(line).get(0))){
				mask[line]=0; //in
				curr = matrix.get(line).get(1);
				mask[line-1]=1; //out;
				line++;
			}
			if (line>=matrix.size())
				break;
		}
		System.out.println();
		for (int i=0;i<mask.length;i++){
			System.out.print(mask[i]+" ");
			if (mask[i]==0)
				result++;
		}		
		System.out.println();			
		return result;
	}
	
	static ArrayList<ArrayList<Integer>> orderEachLine(ArrayList<ArrayList<Integer>> matrix){
		for (int i=0;i<matrix.size();i++){
			Collections.sort(matrix.get(i));
		}
		return matrix;
	}
	static void printListMatrix(ArrayList<ArrayList<Integer>> matrix){
		System.out.println();
		for (int i=0;i<matrix.size();i++){
			for (int j=0;j<matrix.get(i).size();j++){
				System.out.print(matrix.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	static ArrayList<ArrayList<Integer>> getMatrixWithDiffLineSizes(ArrayList<Integer> a, ArrayList<Integer> b){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int min;
		int[] mask = new int[a.size()];
		while (checkedAllFinished(mask)==false){
			min = getMin(a, mask);
			ArrayList<Integer> line = new ArrayList<Integer>();			
			line = getLine(a, b, min);
			mask = setMask(a, min, mask);
			result.add(line);
		}
		return result;
	}
	
	static int[] setMask(ArrayList<Integer> a, int min, int[] mask){
		for (int i=0;i<a.size();i++){
			if (a.get(i)==min){				
				mask[i]=1;  			
			}
		}
		return mask;
	}
	
	static ArrayList<Integer> getLine(ArrayList<Integer> a, ArrayList<Integer> b, int min){
		ArrayList<Integer> line = new ArrayList<Integer>();
		line.add(min);		
		for (int i=0;i<a.size();i++){
			if (a.get(i)==min){				
				line.add(b.get(i));
			}
		}
		return line;
	}
	static int getMin(ArrayList<Integer> a, int[] mask){
		int min = 30001;
		for (int i=0;i<a.size();i++){
			if (min>a.get(i) && mask[i]==0){
				min=a.get(i);
			}
		}
		return min;
	}
	static boolean checkedAllFinished(int[] mask){
		for (int i=0;i<mask.length;i++){
			if (mask[i]==0)
				return false;
		}
		return true;
	}
}


/**
Tests:

8
1 9
4 7
7 11
1 11
10 11
9 10
8 9
8 11
result should be 3.

5
3 10
1 3
1 5
6 7
4 11


9
1 9
4 7
7 11
1 11
10 11
9 10
8 9
8 11
8 9
should be 3

5
3 4
1 5
6 7
4 5
1 3
3

7
1 90
91 125
129 200
3 130
140 150
160 162
201 202
5


*/