	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.DataInputStream;
	import java.io.FileInputStream;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.text.ParseException;
	import java.util.regex.Pattern;
	import java.util.ArrayList;
	import java.math.BigInteger;
	
	public class FireAc1 {
		public static void main(String[] args) {
			long substraction=0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String a = br.readLine();
				int radius = Integer.parseInt(a);			
				long totalNumberOfsq = 0;
				totalNumberOfsq = (2*radius)*(2*radius);
				int t = 0;
				for(int i=0;i<radius;i++){
					int tmp = 0;
					for(int j=i;j<radius;j++){					
						if (distance(i+1,j+1,radius)>=radius ){
							substraction++;
							tmp++;
							if (i==j){
								t++;
							}
							if(tmp==0) break;
						} else{
							break;
						}
					}
					//System.out.println("tmp: "+tmp+" i "+i);
					if(tmp==0) break;					
				}
				substraction = substraction*2-t;
				
				System.out.println(totalNumberOfsq-4*substraction);
				
				
			}catch (IOException e) {			
				e.printStackTrace();
			}
		}
	
		private static double distance(int i, int j, int radius) {
			double distance =0;
			distance = Math.sqrt(Math.pow(radius-i, 2) + Math.pow(radius-j, 2));
			return distance;
		}
	
	}
