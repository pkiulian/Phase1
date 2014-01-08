import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class APlusB {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String input = br.readLine();
			// \ is the short for space. another \ comes because of escape character
			Pattern pat = Pattern.compile("\\s");
			String[] numbers = pat.split(input);
			int a = Integer.parseInt(numbers[0]);
			int b = Integer.parseInt(numbers[1]);
			int sum = a+b;
			System.out.println(sum);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println();	
	}
}
