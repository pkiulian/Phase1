import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class KindSpirits{
	public static void main(String []args){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();		
		try{
			int N = Integer.parseInt(br.readLine().trim());
			ArrayList<Integer> level = new ArrayList<Integer>();
			ArrayList<Integer> nodeNumber = new ArrayList<Integer>();
			String str = br.readLine().trim();
			int i=0, count=1;
			while (i<N){				
				if (!str.equals("*")){					
					int K = Integer.parseInt(str);					
					for (int j=0;j<K;j++){
						String strA = br.readLine().trim();						
						ArrayList<Integer> list = new ArrayList<Integer>();
						String[] s = strA.split("\\s+");
						for(int t=0;t<s.length;t++){
							list.add(Integer.parseInt(s[t]));						
						}
						mat.add(list);					
						level.add(i+1);
						nodeNumber.add(count);
						count++;
					}					
					i++;
					if (i==N)
						break;
				}
				str = br.readLine().trim();						
			}
			level.add(level.get(level.size()-1));
			printVariableMatrix(mat, level, nodeNumber);			
			count++;			
			//System.out.println("level.size() "+level.size());
			int result = ComputeResult(mat, level, nodeNumber, count);
		}catch(IOException e){
			//System.out.println("Got an exception "+e.getMessage());
		}
	}
	
	public static int ComputeResult(ArrayList<ArrayList<Integer>> mat, ArrayList<Integer> level, ArrayList<Integer> nodeNumber, int count){		
		int result=0, MAX = 99999;
		int n = nodeNumber.get(nodeNumber.size()-1);
		//System.out.println("n: "+n);
		int[] v = new int[n+1];
		for (int i=0;i<v.length;i++){
			v[i]=MAX;
		}
		ArrayList<ArrayList<Integer>> mtr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[][] matrice = new int[n][n];
		list.add(0);
		v[0]=0;			//source
		mtr.add(list);
		list = new ArrayList<Integer>();
		for (int i=0;i<mat.size();i++){
			if (i==0){
					list.add(i+1);
				}else if (level.get(i)!=level.get(i-1)&& i>0){
					mtr.add(list);
					list = new ArrayList<Integer>();	
					list.add(i+1);					
				}else if (level.get(i)==level.get(i-1)&& i>0){
					list.add(i+1);
			}
			if (i==mat.size()-1)
				mtr.add(list);						
		}
		
		for (int i=0;i<mtr.size();i++){
			for (int j=0;j<mtr.get(i).size();j++){
				//System.out.print(mtr.get(i).get(j)+" ");
			}
			//System.out.println();
		}
		
		int indexV = 0;
		for (int i=0;i<mat.size();i++){	
			//System.out.println("i+1: "+(i+1));
			if (level.get(i)!=level.get(i+1) && i<mat.size()-1){											
				//System.out.println("A "+indexV);		
				for(int j=0;j<mat.get(i).size();j+=2){
					if (mat.get(i).get(j)!=0){					
						v[i+1]=Math.min(v[i+1], (v[mtr.get(indexV).get(mat.get(i).get(j)-1)]+mat.get(i).get(j+1)));
					}
				}
				indexV++;
				//System.out.println();
				for (int t=0;t<v.length;t++){
						//System.out.print(v[t]+" ");
				}
				//System.out.println();
			} else if (level.get(i)==level.get(i+1) && i<mat.size()-1){
				for(int j=0;j<mat.get(i).size();j+=2){
					if (mat.get(i).get(j)!=0){					
						v[i+1]=Math.min(v[i+1], (v[mtr.get(indexV).get(mat.get(i).get(j)-1)]+mat.get(i).get(j+1)));
					}
				}
				//System.out.println("B "+indexV);
				//System.out.println();
				for (int t=0;t<v.length;t++){
						//System.out.print(v[t]+" ");
				}
				//System.out.println();
			}
			if (i==mat.size()-1){
				for(int j=0;j<mat.get(i).size();j+=2){
					if (mat.get(i).get(j)!=0){						
						v[i+1]=Math.min(v[i+1], (v[mtr.get(indexV).get(mat.get(i).get(j)-1)]+mat.get(i).get(j+1)));
					}
				}				
				//System.out.println("C "+indexV);
				//System.out.println();
				for (int t=0;t<v.length;t++){
						//System.out.print(v[t]+" ");
				}
				//System.out.println();
			}
		}
		//System.out.println();
		for (int i=0;i<v.length;i++){
			//System.out.print(v[i]+" ");
		}
		
		int MIN = 999999;
		for (int i=level.size()-1;i>0;i--){
			if (level.get(i)!=level.get(i-1)){
				break;
			}else{
				////System.out.println("checked: "+v[i]);
				if (MIN>v[i])
					MIN = v[i];
			}
		}
		System.out.println(MIN);
		
		return result;
	}
	public static void printMatrix(int[][] result, int n){
		//System.out.println();
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				//System.out.print(result[i][j]+" ");
			}
			//System.out.println();
		}
		//System.out.println();
	}
	
	/**The first line printed is the level */
	public static void printVariableMatrix(ArrayList<ArrayList<Integer>> mat, ArrayList<Integer> level, ArrayList<Integer> nodeNumber){
		//System.out.println();
		for (int i=0;i<mat.size();i++){
			//System.out.print(level.get(i)+" ");
			for (int j=0;j<mat.get(i).size();j++){
				//System.out.print(mat.get(i).get(j)+" ");
			}
			//System.out.print(nodeNumber.get(i)+" ");
			//System.out.println();
		}
		//System.out.println();
		
	}
}

/*

3
2
1 15 0
1 5 0
*
3
1 -5 2 10 0
1 3 0
2 40 0
*
2
1 1 2 5 3 -5 0
2 -19 3 -20 0
das
*/
