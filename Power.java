import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Power{	
	public static void main(String[] args){
		int N; int M; int Y; String s;
		InputStreamReader isr1 = new InputStreamReader(System.in);
		BufferedReader br1 = new BufferedReader(isr1);
		try{
			s = br1.readLine();
			String[] parts = s.trim().split("\\s+");
			N=Integer.parseInt(parts[0]);
			M=Integer.parseInt(parts[1]);
			Y=Integer.parseInt(parts[2]);					
			//int period = getPeriod(N,M,Y);
			int period  = M;
			int[] elemArra = new int[M];
			for (int i=0;i<M;i++)
				elemArra[i]=0;
			elemArra = getArray(N,M,Y);
			//for (int i=0;i<M;i++)
			//		System.out.println("elem "+elemArra[i]);
			int difLengt=0;
			for (int i=0;i<M;i++){
				if (elemArra[i]==Y){
					difLengt++;
				}				
			}
			if (difLengt!=0){
				int[] diff = new int[difLengt];		
				int contor = 0;
				for (int i=0;i<M;i++){
					if (elemArra[i]==Y){
						diff[contor]=i;
						contor++;
					}				
				}
				//for (int i=0;i<contor;i++)
				//	System.out.println("id where the result is the searched one "+diff[i]);
				boolean done = false;
				int number = 0;
				String result ="";
				while(done==false){
					for (int i=0;i<contor;i++){
						if ((number+diff[i])<M){								
								result += (number+diff[i]);
								result +=" ";									
							}else{
								done = true;
								break;
							}
					}					
					number += M;
				}				
				System.out.println(result);
			}else{
				System.out.println("-1");
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}  
	}
	public static int[] getArray(int N, int M, int Y){
	//	boolean done = false;
		int[] elemArra = new int[M];
		for (int i=0;i<M;i++)
			elemArra[i]=0;
		int X = 1;		
		while (/*done==false && */X<M){
			int elem = getElement(N, M, X, 1, X%M);
			elemArra[X] = elem;			
			X++;
		//	if (elem==0){
		//		done = true;
		//	}						
		}
		return elemArra;
	}
	public static int getElement(int N, int M, int X, int i, int result){		
		for (int k=1;k<N;k++){			
			result = (result*X)%M;						
		}		
		return result;
	}
}