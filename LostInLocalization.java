import java.io.*;
public class LostInLocalization {
	public static void main(String[] str){
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
	    try {
	    	//ArrayList<String> list = new ArrayList<String>();
	    	//ArrayList<String> result = new ArrayList<String>();
	    	String string = br.readLine();
	    	//while ((string = br.readLine()).isEmpty()==false){
	    		int n = Integer.parseInt(string);
	    		if (n>=1 && n<=4){
	    			//result.add("few");
	    			System.out.println("few");
	    		}
	    		if (n>=5 && n<=9){
	    			//result.add("several");
	    			System.out.println("several");
	    		}
	    		if (n>=10 && n<=19){
	    			//result.add("pack");
	    			System.out.println("pack");
	    		}
	    		if (n>=20 && n<=49){
	    			//result.add("lots");
	    			System.out.println("lots");
	    		}
	    		if (n>=50 && n<=99){
	    			//result.add("horde");
	    			System.out.println("horde");
	    		}
	    		if (n>=100 && n<=249){
	    			//result.add("throng");
	    			System.out.println("throng");
	    		}
	    		if (n>=250 && n<=499){
	    			//result.add("swarm");
	    			System.out.println("swarm");
	    		}
	    		if (n>=500 && n<=999){
	    			//result.add("zounds");
	    			System.out.println("zounds");
	    		}
	    		if (n>=1000){
	    			//result.add("legion");
	    			System.out.println("legion");
	    		}
	    	//}
			//for (int i=0;i<result.size();i++){
			//	System.out.println(result.get(i)+" ");
			//}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
