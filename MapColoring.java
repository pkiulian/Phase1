import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class MapColoring{
    static int[] maskColor;
    static int[] visited;
    static int[][] matrix;
    public static void main(String[] args){       
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();	
        String s = "";
        int N=0;

        try{
          InputStreamReader isr1 = new InputStreamReader(System.in);
          BufferedReader br1 = new BufferedReader(isr1);
          s = br1.readLine();
          N = Integer.parseInt(s.trim());  
          int k=0;
          while(k<N){
                s = br1.readLine();               
                ArrayList<Integer> partsList = new ArrayList<Integer>();
                String[] parts = s.trim().split("\\s+");
                partsList.add(k);
                for (int i=0;i<parts.length;i++){
                  if (Integer.parseInt(parts[i])==0){
                    partsList.add(Integer.parseInt(parts[i]));
                  }else{
                    partsList.add(Integer.parseInt(parts[i])-1);
                  }
                }
                arr.add(partsList);
            k++;
          }
	maskColor = new int[N];	
	for (int i=0;i<N;i++)
	  maskColor[i]=-1;
	visited = new int[N];
	matrix = new int[N][N]; // square matrix
	matrix = getAdjMatrix(arr,  N, matrix); // matrix done	
	/*for (int i=0;i<N;i++){
	    for (int j=0;j<N;j++){
		System.out.print(matrix[i][j]);
	    }
	  System.out.println();
	}*/
	if(arr.size()==0){
	  System.out.println("-1");
	}else{ 
	  bfs(matrix, N, maskColor, visited);
	}
        }catch(IOException e){
            e.printStackTrace();
        }                 
    }

public static void bfs(int[][] matrix, int N, int[] maskColor, int[] visited){
	ArrayList<Integer> queue = new ArrayList<Integer>();
	int k = 0;
	queue.add(0); // adding first element;
	maskColor[0]=k%2;
	visited[0]=1;
	while(queue.size()!=0){
	  int u = queue.get(0);	
	  k = (maskColor[u]+1)%2;
	  for (int j=0;j<N;j++){
	      if (matrix[u][j]==1){ 
		  if (visited[j]==0){
		    queue.add(j);    
		    visited[j]=1;    
		   // System.out.println("color :"+(k%2)+" point in discuss: "+j);
		    if ( (maskColor[j]==k%2 || maskColor[j]==-1) && checkParent(j, k, matrix, N, maskColor)==true ) {
			maskColor[j]=k%2;
			//System.out.println(j+" gets color "+(k%2));
		    }
		  }
	      }
	  }
	  queue.remove(0);	
	}
      String result = "-1";
      if (noMinusInColor(maskColor, N)){
	result = "";
	for (int i=0;i<N;i++){
	    result += maskColor[i];
	}
	System.out.println(result);
      }else{   
	System.out.println(result);
      }
}
/** All the parents of t must not have different collor.*/
public static boolean checkParent(int t, int k,  int[][] matrix, int N, int[] maskColor){
    for (int j=0;j<N;j++){
	  if (matrix[t][j]==1)
	      if(maskColor[j]==(k+1)%2 || maskColor[j]==-1) { 
		  //   System.out.println("parent "+j+" of "+t+" is ok ");
		 } else if (maskColor[j]==(k)%2){
		  //System.out.println("parent with same color "+t+" "+j);
		  return false;
	      }    
    }    
    return true;
}
public static boolean noMinusInColor(int[] color, int N){
    for (int i=0;i<N;i++)
	if (color[i]==-1) return false;
    return true;
}

  public static int[][] getAdjMatrix(ArrayList<ArrayList<Integer>> arlocal, int N, int[][] matrix){
      for (int i=0;i<N;i++){
              for (int j=0;j<arlocal.get(i).size()-1;j++){
		  if (i!=arlocal.get(i).get(j)){
		    matrix[i][arlocal.get(i).get(j)]=1; 
		    matrix[arlocal.get(i).get(j)][i]=1; 
		  }
              }        
        }
    return matrix;
  }
  
}