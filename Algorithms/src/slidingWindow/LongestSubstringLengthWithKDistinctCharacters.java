package slidingWindow;
import java.util.HashMap;
import java.util.Map.Entry;

public class LongestSubstringLengthWithKDistinctCharacters {
	// covers atmost k also
	public static void main(String[] args) {
		
		String s="ABABACCCCCC";
	
		//longestSubstring(s,2);
		longestAlter(s,2);
	}
	
	public static void longestAlter(String s,int k)
	{
		//faster 
		int windowStart=0;
		int bank[]=new int[128];
		int max=Integer.MIN_VALUE;
		
		int count=0;// count of unique characteres
		for(int windowEnd=0;windowEnd<s.length();windowEnd++)
		{
			
			// increasing count only when the freq of char is 0 i.e for the first time
			if(bank[s.charAt(windowEnd)]==0)
			{
				
				count++;
				System.out.println("increaseing count "+count);
			}
			bank[s.charAt(windowEnd)]++;
			
			while(count>2)
			{
				System.out.println("in while");
				bank[s.charAt(windowStart)]--;
				//when the freq of char becomes zero reduce the count 
				// becaause when freq is 0 that means that char is no longer in window
				if(bank[s.charAt(windowStart)]==0)
				{
					System.out.println("here");
					count--;
				}
				windowStart++;
				//break;
			}
			max=Math.max(max,windowEnd-windowStart+1);
			System.out.println("max "+max);
			System.out.println();
		}
	}
	public static void longestSubstring(String s,int k)
	{
		int windowStart=0;
		HashMap<Character,Integer>map=new HashMap<>();
		int max=Integer.MIN_VALUE;
		char[]c=s.toCharArray();
		
		for(int windowEnd=0;windowEnd<s.length();windowEnd++)
		{
			
			if(map.containsKey(s.charAt(windowEnd)))
			{
				int value=map.get(s.charAt(windowEnd));
				map.put(s.charAt(windowEnd),++ value);
			}
			else
				map.put(s.charAt(windowEnd),1);
			
			System.out.println("size "+map.size());
			
			System.out.println("window End "+windowEnd+" windowStart "+windowStart);
			
			System.out.println("while start");
			
			// when map size is greater than k we start contracting our window
			while(map.size()>2)
			{
				traverseMap(map);
				
				//max=Math.max(max,windowEnd-windowStart);
				System.out.println("max "+max);
				System.out.println("map size "+map.size());
				System.out.println("windowStart "+windowStart);
				if(map.get(c[windowStart])>1)
				{
					
					System.out.println("get "+map.get(c[windowStart]) +" "+c[windowStart]);
					int value=map.get(c[windowStart]);
				map.put(c[windowStart],--value);
				}
				else
				{
					System.out.println("here");
					map.remove(c[windowStart]);
				}
				
				windowStart++;
			
				//System.out.println();
			}
			//calculatng max at end beacuse of cases when theier are 2 uniq chars till the end
			max=Math.max(max,windowEnd-windowStart+1);
			System.out.println("map size "+map.size());
			System.out.println("while end");
			System.out.println();
			
		}
		System.out.println();
		System.out.println("max "+max);
		
		
	}
	public static void traverseMap(HashMap<Character,Integer>map)
	{
		for(Entry<Character,Integer>e:map.entrySet())
		{
			System.out.println("key "+e.getKey()+" value "+e.getValue());
		}
	}

}
