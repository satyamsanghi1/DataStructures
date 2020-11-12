import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RepeatingElementsInArray {

//repeating elements in an array
	// non repeating elements in array 
	
	
	public static void main(String[] args)
	{
		String a="satyam";
		
		HashMap<Character,Integer> map=new HashMap<Character, Integer>();
		
		
		for(int i=0;i<a.length();i++)
		{
			if(map.containsKey(a.charAt(i)))
			{
				int value=map.get(a.charAt(i));
						value+=1;
				map.put(a.charAt(i), value);
			}
			else
			{
				map.put(a.charAt(i),1);
			}
		}
		
		for(Entry<Character, Integer> val:map.entrySet())
		{
			System.out.print(val.getKey()+" ");
			System.out.println(val.getValue());
		}
		
		
		
		
	
	}

}
