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
	
	public class FireAc2 {	
		public static void main(String[] args) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String a = br.readLine();
				long raza = Integer.parseInt(a);
				long result =0; 
				long UsedcadranSquares = 0, distantaLaPatrat;
				long razaAux = raza;
				for (long i=0;i<raza;i++){ 
					distantaLaPatrat = raza*raza-i*i; 
					while (razaAux * razaAux  >= distantaLaPatrat){ // defines the bounds of used squares
						if (razaAux>=0){
							razaAux--;
						}
					}
					UsedcadranSquares +=(razaAux+1); // +1 starting from 0
				}
				UsedcadranSquares*=4; 
				System.out.println(UsedcadranSquares);
			}catch (IOException e) {			
				e.printStackTrace();
			}
		}	
	
	}