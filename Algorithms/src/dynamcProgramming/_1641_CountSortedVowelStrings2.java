package dynamcProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class _1641_CountSortedVowelStrings2 {
	//30%Fast my solution
	public static void main(String[] args) {


		countVowelStrings(3);
	}
	public static int countVowelStrings(int n) {



		List<Character>data1=new ArrayList<>(Arrays.asList('a','e','i','o','u'));

		HashMap<Character,Integer>map=new HashMap<>();
		map.put('a',1);
		map.put('e',1);
		map.put('i',1);
		map.put('o',1);
		map.put('u',1);

		for(int i=0;i<n-1;i++)
		{
			HashMap<Character,Integer>newmap=new HashMap<>();

			for(Entry<Character,Integer>e :map.entrySet())
			{
				for(char to:data1)
				{
					if(to>=e.getKey())
					newmap.put(to,newmap.getOrDefault(to,0)+e.getValue());
				}
			}
			System.out.println(newmap.toString());
			map=newmap;

		}
		System.out.println("size "+calculate(map));
		return 0;
	}
	public static int calculate(HashMap<Character,Integer>map)
	{
		Integer total=0;
		for(Entry<Character,Integer>e :map.entrySet())
		{
			total+=e.getValue();
			//System.out.println(e.getValue());
		}

		return total;
	}
}
