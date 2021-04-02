package algoExpert;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

	public static void main(String[] args) {



	}
	public static  boolean generateDocument(String characters, String document) {
		// Write your code here.

		HashMap<Character,Integer>map1=new HashMap<>();
		HashMap<Character,Integer>map2=new HashMap<>();

		fill(map1,characters);
		fill(map2,document);

		for(Map.Entry<Character,Integer>e:map2.entrySet())
		{
			if(map1.containsKey(e.getKey()))
			{
				if(!(map1.get(e.getKey())>=e.getValue()))
					return false;
			}
			else
				return false;

		}
		return true;
	}
	public static void fill(HashMap<Character,Integer>map,String str)
	{
		for(char c:str.toCharArray())
		{
			map.put(c,map.getOrDefault(c,0)+1);
		}
	}

}
