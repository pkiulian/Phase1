import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.text.*;

public class Problem1585{
  public static void main(String[] args){
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    int N; String s;
    try{
	s = br.readLine().trim();
	N=Integer.parseInt(s);
	String b;
	int e=0;
	int m=0;
	int l=0;
	char ch;
	for(int i=0;i<N;i++){
	  b = br.readLine();
	  ch=b.charAt(0);
	  if (ch=='E'){
	    e++;
	  } else if (ch=='M'){
	    m++;
	  } else if (ch == 'L'){
	    l++;
	  } 
	}
	if (e>m && e>l) System.out.println("Emperor Penguin");
	if (m>e && m>l) System.out.println("Macaroni Penguin");
	if (l>m && l>e) System.out.println("Little Penguin");
	
    }catch(IOException e){
	e.printStackTrace();
    }  
  }
}