import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TR1 {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			
			int[] A = new int[30000];
			int N,Ts, Te, Res, Curr, i;
			N = Integer.parseInt(br.readLine());
			
			for (i=0;i<A.length;i++)
				A[i]=30001;
			
			for(i=0;i<N;i++){
				String[] s = (br.readLine()).split("\\s+");
				Ts = Math.min(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				Te = Math.max(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				if (A[Ts]>Te) {					
					A[Ts]=Te; 
					System.out.println("Ts: "+Ts+" A[Ts] "+A[Ts]);			
				};
								
			}
			
			Res=0; Curr=0;
			
			while(Curr<A.length){
				if (A[Curr]!=30001)
					System.out.println("Curr "+Curr+ " A[Curr]: "+A[Curr]);
				if (A[Curr]==30001){
					Curr++;
				}else{
					Curr=A[Curr]+1;
					Res++;
				}
			}
			System.out.println(Res);
			
		} catch (IOException e) {
			System.out.println("exception");
		}

	}

}
