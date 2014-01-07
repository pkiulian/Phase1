import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
public class CoverIlici {
	public static void main(String[] args) {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			int segmentNumber = Integer.parseInt(br.readLine());
			Hashtable<Integer,Integer> segments = new Hashtable<Integer,Integer>(); // already takes the unique ones
			
			for(int index=0;index<segmentNumber;index++){
				String [] xy= br.readLine().split("\\s+");
				int x = Integer.parseInt(xy[0]);
				int y = Integer.parseInt(xy[1]);
				int aux;
				if(x > y) // exclusive or
				{
					 aux = x;
	                 x = y;
	                 y = aux;
				}
				
				int keyToRemove = CoverIlici.removeIfIncluded(segments, x, y);
                if (keyToRemove != -1 && keyToRemove != -2)
                {                    
                    segments.remove(keyToRemove);
                    keyToRemove = CoverIlici.removeIfIncluded(segments, x, y);
                    if (keyToRemove != -1)
                    {
                        segments.remove(keyToRemove);
                    }
                    segments.put(x, y);

                }
                else if (keyToRemove != -2 && !segments.containsKey(x))
                    segments.put(x, y);
				
			}
		List<Integer> keySet = new ArrayList<Integer>(segments.keySet());
		java.util.Collections.sort(keySet);
		List<String> results = new ArrayList<String>();
		int lastAcceptedKeyValue = (int) keySet.get(0);
		results.add((int)keySet.get(0) + " " + (int)segments.get(keySet.get(0)));
	    for(int index = 1; index < keySet.size();index++){
	    	if((int)keySet.get(index) > (int)segments.get(lastAcceptedKeyValue)){
	    		lastAcceptedKeyValue = (int) keySet.get(index);
	    		results.add(lastAcceptedKeyValue + " " + segments.get(lastAcceptedKeyValue));	    		
	    	}
	    }
	    System.out.println(results.size());

		} catch (IOException e) {			
			e.printStackTrace();
		}

	}

	 public static int removeIfIncluded(Hashtable<Integer,Integer> segments, int newSegmentStartPos, int newSegmentEndPos)
     {
		 List<Integer> keySet = new ArrayList<Integer>(segments.keySet());
		 java.util.Collections.sort(keySet);
		 for(int index = 0; index < keySet.size();index++)
         {
			 int currentKey = (int)keySet.get(index);
             if (currentKey < newSegmentStartPos)
             {                 
                 if ((int)segments.get(currentKey) > newSegmentEndPos)
                     return currentKey;
             }
             else if (currentKey > newSegmentStartPos && currentKey < newSegmentEndPos)
             {
                 if ((int)segments.get(currentKey) < newSegmentEndPos)                  
                     return -2;
             }
             else
                 break;
         }         
         return -1;
     }

}
