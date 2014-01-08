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

public class FinancialManagement{
	public static void main(String [] str){
		double result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{			
			for (int i=0;i<12;i++){
				result+=(Double.parseDouble(br.readLine().trim()));
			}
			System.out.println("$"+(result/12));			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}