import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class ScientificConferenceTree{
		
	static int getFinalResult(ArrayList<Integer> SumsV){
		int finalResult = 0;
		boolean init = false;
		boolean start = true;
		int count =1;
		int[]maskA = new int[SumsV.size()];						
		for (int i=0;i<SumsV.size();i++){
			if (SumsV.get(i)==1 && start){	
				count =1;
				init = true;
				start = false;															
			}else if (SumsV.get(i)==0){
				start=true;
				init = false;
			}
			if (SumsV.get(i)==1 && !start && !false){
				maskA[i]=count;
				count++;
				count%=2;					
			}
			init =false;
		}			
		for (int i=0;i<maskA.length;i++){				
			if (maskA[i]==1)
				finalResult++;
		}	
		return finalResult;
	}
			
	static public boolean completed(ArrayList<Integer> SumsV){
		for (int i=0;i<SumsV.size();i++)
			if (SumsV.get(i)>1)
				return false;		
		return true;
	}
	
	public static void printArray(ArrayList<Integer> list){	
		System.out.println("print Array");
		for (int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}
	}
	
	public static ArrayList<Integer>  getAtomIntervals(ArrayList<Segment> segments){
		ArrayList<Integer> result = new ArrayList<Integer>();
		int minInf = Integer.MIN_VALUE;
		int maxInf = Integer.MAX_VALUE;
		result.add(minInf);
		for (int i=0;i<segments.size();i++){
			if (!result.contains(segments.get(i).getA()))
				result.add(segments.get(i).getA());
			if (!result.contains(segments.get(i).getB()))
				result.add(segments.get(i).getB());
		}
		result.add(maxInf);
		Collections.sort(result);
		return result;
	}
	
	public static boolean existsInSegments(ArrayList<Segment> segments, Segment s){
		for (int i=0;i<segments.size();i++){
			if (s.getA()==segments.get(i).getA() && s.getB()==segments.get(i).getB())
				return true;
		}
		return false;
	}
	
	public static void printSegments(ArrayList<Segment>  segments){
		System.out.println("Segments: ");
		Iterator<Segment> iterator = segments.iterator(); 
		while (iterator.hasNext()){
			Segment s = iterator.next();
			System.out.println(s.getA()+" "+s.getB());  
      }
	}
	
	public static int[] getVectorForTree(ArrayList<Integer>  atomIntervals){
		int[] result = new int[atomIntervals.size()-2];
		for (int i=1;i<atomIntervals.size()-1;i++){
			result[i-1]=atomIntervals.get(i);
		}
		return result;
	}
	
	public static void printVector(int[] v){
		System.out.println("vector");
		for (int i=0;i<v.length;i++){
			System.out.print(v[i]+" ");
		}		
		System.out.println();
	}
	
	public static void main(String[] args){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<Segment> segments = new ArrayList<Segment>();		
		Segment s = new Segment();
		try{
			int n=Integer.parseInt(br.readLine());
			for (int i=0;i<n;i++){
				String[] str = (br.readLine()).split("\\s+");
				int a = Math.min(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
				int b = Math.max(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
				s = new Segment(a,b);
				if (!existsInSegments(segments, s)){
					segments.add(s);
				}
			}								
			ArrayList<Integer>  atomIntervals = getAtomIntervals(segments);			
			int[] v = new int[atomIntervals.size()-2];			
			v = getVectorForTree(atomIntervals);			
			ArrayList<ArrayList<Integer>> list2D = new ArrayList<ArrayList<Integer>>();			
			list2D = getTheArrays(v, segments);
			/**STEP 1*/
			int[] count = new int[100000];			
			int positionForMax = -1;	
			int max = 1;		
			printMultiDimList(list2D);
			while(!doneList(list2D)){					
				max = 1;
				for (int i=0;i<list2D.size();i++){				
					for (int j=0;j<list2D.get(i).size();j++){
						count[list2D.get(i).get(j)]++;
					}					
				}
				for (int i=0;i<count.length;i++)
					if (max<count[i]){
						max = count[i];					
						positionForMax = i;
					}				
				if (doneList(list2D)){
					break;
				}else{					
					for (int i=0;i<list2D.size();i++){
						for (int j=0;j<list2D.get(i).size();j++){
							if(list2D.get(i).get(j)==positionForMax){
								list2D.get(i).remove(j);
								j--;
							}
						}
					}
					count = new int[100000];
				}
			}								
			/**STEP 2*/
			ArrayList<Integer> vec = new ArrayList<Integer>();
			for (int i=0;i<list2D.size();i++){
				if (list2D.get(i).size()==1){				
					vec.add(1);		
				}else{
					vec.add(0);
				}
			}						
			/**STEP 3*/		
			int finalResult = getFinalResult(vec);							
			System.out.println(finalResult);
		}catch(IOException e){
			System.out.println("Got an exception");
		}
	}
		
	
	public static boolean doneList(ArrayList<ArrayList<Integer>> list2D){
		for (int i=0;i<list2D.size();i++)
			if (list2D.get(i).size()>1)
				return false;
		return true;
	}
	
	public static void printMultiDimList(ArrayList<ArrayList<Integer>> list2D){
		System.out.println("list2D");
		for (int i=0;i<list2D.size();i++){
			for (int j=0;j<list2D.get(i).size();j++){
				System.out.print(list2D.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> getTheArrays(int[] v, ArrayList<Segment> segments){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i=0;i<v.length-1;i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j=0;j<segments.size();j++){
				if (v[i]>=segments.get(j).getA() && v[i+1]<=segments.get(j).getB()){
					list.add(j);
				}
			}
			result.add(list);
		}
		return result;
	}
	
}

class Segment{
	private int a;
	private int b;
	public Segment(){}
	public Segment(int a, int b){
		this.a = a;
		this.b = b;
	}
	public int getA(){
		return this.a;
	}
	public int getB(){
		return this.b;
	}
	public void setA(int a){
		this.a = a;
	}
	public void setB(int b){
		this.b = b;
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
should be 3

7
1 90
91 125
129 200
3 130
140 150
160 162
201 202
should be 5


http://www.iis.sinica.edu.tw/~dtlee/dtlee/CRCbook_chapter18.pdf
http://www.dgp.utoronto.ca/people/JamesStewart/378notes/22intervals/
http://homepage.cs.uiowa.edu/~sriram/21/spring07/code/tree.java
*/