import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.text.*;

public class SquareCountry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);	
		String s;
		try{
			s = br.readLine().trim();
			int n=Integer.parseInt(s);
			
			int min=100000;
			int contor = 0;
			int result = 0;
			
			
			//int  n = (int)Math.pow(Math.floor(Math.sqrt((double) nr)),2);
			int []mask = new int[3];
			boolean b = false;
			for (int i=0;i<=(Math.sqrt((double) n));i++){
				for (int j=0;j<=(Math.sqrt((double) n));j++){
					for (int k=0;k<=(Math.sqrt((double) n));k++){							
							if (i*i+j*j+k*k==n){
								contor = 0;
								b = true;
								mask[0]=i;
								mask[1]=j;
								mask[2]=k;					
								for (int z=0;z<3;z++){
									if (mask[z]!=0){
										contor++;
									}
								}
								if(contor<min) min = contor;	
							}
						
					}
				}
			}			
			result = min;
			if (b == false){
				result = 4;
			}													
			
		
			System.out.println(result);			
		}catch(IOException e){
			e.printStackTrace();
		}  
	}

}
