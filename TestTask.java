import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class TestTask{
	public static void main(String[] args){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String R = "";
		try{
			int n = Integer.parseInt(br.readLine());
			ArrayList<String> us_registers = new ArrayList<String>();
			ArrayList<String> ps_registers = new ArrayList<String>();

			ArrayList<String> us_login = new ArrayList<String>();
			ArrayList<String> ps_login = new ArrayList<String>();

			ArrayList<String> us_logout = new ArrayList<String>();
			

			String []predf = {"register","login","logout"};
			
			while(n>=0){
				if(n==0)
					break;
				n--;
				String s = br.readLine();
				String []sv = s.split("\\s+");

				if (sv[0].equals(predf[0])){
					if (checkList(us_registers, sv[1])){		
						System.out.println("fail: user already exists");
						
					}else{ 
						us_registers.add(sv[1]);
						ps_registers.add(sv[2]);
						System.out.println("success: new user added");
					
					}
				}
				
				if (sv[0].equals(predf[1])){
					if (!checkList(us_registers, sv[1])){
						System.out.println("fail: no such user");
						
					}else{
						int index = getIndex(us_registers, sv[1]);
						if (!sv[2].equals(ps_registers.get(index))){
							System.out.println("fail: incorrect password");
						
						}else{
							if (checkList(us_login, sv[1])){
								System.out.println("fail: already logged in");
						
							}else{
								us_login.add(sv[1]);
								ps_login.add(sv[2]);								
								for (int i=0;i<us_logout.size();i++){
									if (us_logout.get(i).equals(sv[1])){
										us_logout.remove(i);										
										i--;
									}
								}
								System.out.println("success: user logged in");
						
							}
						}
					}
				}
				
				if (sv[0].equals(predf[2])){
					if (!checkList(us_registers, sv[1])){
						System.out.println("fail: no such user");
						
					}else{
						if (checkList(us_logout, sv[1])){
							System.out.println("fail: already logged out");
						
						}else{
							if (checkList(us_login, sv[1])){
								us_logout.add(sv[1]);							
								for (int i=0;i<us_login.size();i++){
									if (us_login.get(i).equals(sv[1])){
										us_login.remove(i);
										ps_login.remove(i);
										i--;
									}
								}
								System.out.println("success: user logged out");
							}else{
								System.out.println("fail: already logged out");
							}
						}
					}
				}
				
			}
			System.out.println();			
		}catch(IOException e){
			System.out.println("do something with the exception");
		}
	}

	public static boolean checkList(ArrayList<String> list, String str){		
		for (int i=0;i<list.size();i++){
			if (list.get(i).equals(str)){
				return true;
			}
		}
		return false;		
	}

	public static int getIndex(ArrayList<String> list, String str){
		int result=0;
		for (int i=0;i<list.size();i++){
			if (list.get(i).equals(str)){
				return i;
			}
		}		
		return result;
	}
}
