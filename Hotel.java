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

public class Hotel{
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String a = br.readLine();
			int n = Integer.parseInt(a);
			int [][]mat = new int[n][n];
			int index=0;
			
			// mirrored wrt result			
			for (int k=0;k<n;k++){
				for (int i=0,j=k;i<=k;i++,j--){									
						mat[i][j]=++index;					
				}
				if (k==n-1){
					for (int i=1;i<n;i++){
						for (int j=n-i;j>=1;j--){
							if (i!=j)
								mat[i][j]=++index;
						}
					}
				}
			}			
			for (int i=0;i<n;i++){
				for (int j=0;j<n;j++){
					System.out.print(mat[i][j]+"   ");
				}
				System.out.println();
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}


