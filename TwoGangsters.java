import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TwoGangsters{
      public static void main(String[] args){
	String s = "";
	 try{
	    InputStreamReader isr1 = new InputStreamReader(System.in);
	    BufferedReader br1 = new BufferedReader(isr1);
	    s = br1.readLine();
	    String[] parts = s.trim().split("\\s+");
	    int a = Integer.parseInt(parts[0]);
	    int b = Integer.parseInt(parts[1]);
	    
	    int ares = b-1;
	    int bres = a-1;
	    System.out.println(ares+" "+bres);
	 }catch(IOException e){
            e.printStackTrace();
        }     
      }
}