import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.text.*;

public class Problem1877{
	public static void main(String[] args){
		InputStreamReader isr1 = new InputStreamReader(System.in);
		BufferedReader br1 = new BufferedReader(isr1);		
		String s1;
		String s2;
		int nr1;
		int nr2;
		try{
			s1 = br1.readLine().trim();
			s2 = br1.readLine().trim();
			nr1=Integer.parseInt(s1);
			nr2=Integer.parseInt(s2);
			
			if (nr1%2==1 && nr2%2==0){System.out.println("no");}
			if (nr1%2==0 && nr2%2==1){System.out.println("yes");}			
			if (nr1%2==0 && nr2%2==0){System.out.println("yes");}	
			if (nr1%2==1 && nr2%2==1){System.out.println("yes");}								
		}catch(IOException e){
			e.printStackTrace();
		}  
	}
}