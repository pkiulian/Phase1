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

public class UralSteakes {
	public static void main(String[] args) {
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String a = br.readLine();
			String[] tokens = a.trim().split("\\s+");
			int n1 = tokens.length;
			int []vector = new int[n1]; 	
			for (int i=0;i<n1;i++){
				vector[i] = Integer.parseInt(tokens[i]);				
			}
			int n = vector[0];
			int k = vector[1];
			int m = 2;
			if (k>=n){ System.out.println(2);}else{
			int [][]mask = new int[n][m];
			for (int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					mask[i][j]=0;
				}
			}
			while (finishedMatrix(mask, n, m)==false){
				for  (int i=0;i<n;i++){
					while(lineFinished(mask, n, m, i)==false){
						int value = 0;
						for (int j=0;j<m;j++){
							for (int t=0;t<n;t++){
								if (value<k && mask[t][j]==0){
									mask[t][j] =1;
									value++;
								}
							}
						}
						result++;
					}
				}
			}
			System.out.println(result);
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

	private static boolean finishedMatrix(int[][] mask, int n, int m) {
		for (int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if (mask[i][j]==0) return false;
			}
		}
		return true;
	}
	private static boolean lineFinished(int[][]mask, int n, int m, int i){
		for(int j=0;j<m;j++){
			if (mask[i][j]==0) return false;
		}
		return true;
	}

}
