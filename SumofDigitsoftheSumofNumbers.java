import java.util.*; 
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SumofDigitsoftheSumofNumbers{	
	public static void main(String []args){
	String s="";
	int N;
	try{
	    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    s = bufferRead.readLine(); 	   
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	N = Integer.parseInt(s); 
	BigInteger a = new BigInteger("55");
    BigInteger b = new BigInteger("36");
    BigInteger result = new BigInteger("1");
    for (int i=0;i<N-1;i++){
		result = result.multiply(a);
	}
	result = result.multiply(b);
	System.out.println(result.toString()); 
    }  
}
