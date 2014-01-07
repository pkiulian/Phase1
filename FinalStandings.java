import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FinalStandings{
	public static void main(String[] args){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);		
		try{
			int n = Integer.parseInt(br.readLine().trim());
			ArrayList<Team> teamList = new ArrayList<Team>();
			for (int i=0;i<n;i++){
				String [] str = br.readLine().split("\\s+");
				Team t = new Team();
				t.a = Integer.parseInt(str[0]);
				t.b = Integer.parseInt(str[1]);
				teamList.add(t);
			}
			Collections.sort(teamList, new Comparator<Team>(){
				public int compare(Team t1, Team t2){
					return t2.b-t1.b;
				}
			});			
			for (int i=0;i<teamList.size();i++)
				System.out.println(teamList.get(i).a+" "+teamList.get(i).b);
			
		}catch(IOException e){
			System.out.println("Got an exception "+e.getMessage());
		}
	}
}
class Team{
	int a,b;
}