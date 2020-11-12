package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class _0451_SortCharactersByFrequency {
	//appending string builder is faster than using + in String
	//internally + using String Builder only
	public static void main(String[] args) {
		
		String s="etre";
		
		frequencySortAlter(s);
	}
	public static String frequencySortAlter(String s) {
		//60%Faster  	
		
		
		///THis question is to be soolved using hashmap and priority queue
		// step1 : count frequncey of all characters using hashmaps
		// step2 :we are using priority queue becaouse , it maintans order acoording to user special type ordering
		// like in this case , sorting according to values of hashmap
		HashMap<Character,Integer>map=new HashMap<>();
		for(char c:s.toCharArray())
		{
			// this methods return default value 0 if key is not present 
			// and if present return the value of that key
			map.put(c,map.getOrDefault(c,0)+1);
		}
		PriorityQueue<Entry<Character,Integer>>pq= new PriorityQueue<>(new Comparator<Entry<Character,Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				if(o2.getValue()>o1.getValue())
					return 1;
				else if(o2.getValue()<o1.getValue())
					return -1;
				return 0;
			}
		});
		
		for(Entry<Character,Integer>e:map.entrySet())
		{
			pq.add(e);
		}
		
		// we can use 
		//pq.addAll(map.entrySet());
		
		StringBuilder sb=new StringBuilder();
		  while (!pq.isEmpty()) 
		  {
		        //System.out.println(pq.poll().getKey()); 
		        Entry<Character,Integer>e=pq.poll();
		        int value=e.getValue();
	            for(int z=0;z<value;z++)
	                sb.append(e.getKey());
		  }
		System.out.println(sb.toString());
		return sb.toString();
	}
	public static String frequencySort(String s) {
     
		// very high space and time complexity
		HashMap<Character,Integer>map=new HashMap<>();
		
		for(char c:s.toCharArray())
		{
			if(map.containsKey(c))
			{
				int value=map.get(c);
				map.put(c, ++value);
			}
			else
				map.put(c,1);
		}
		sortMapValue(map);
		return null;
    }
	public static String sortMapValue(HashMap<Character,Integer>map)
	{
		// 44% Faster
		// when used String contactenation using + 
		// 5 % Faster 
		List<Entry<Character,Integer>>list=new ArrayList(map.entrySet());
		
		Iterator i=list.iterator();
		System.out.println("before sorting");
		while(i.hasNext())
		{
			System.out.println(i.next());
			
		}
		Collections.sort(list,new Comparator<Entry<Character,Integer>>()
				{

					@Override
					public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
						
						return o2.getValue().compareTo(o1.getValue());
					}
			
				});
		
		System.out.println("after sorting");
		StringBuilder sb=new StringBuilder();
		for(Entry<Character,Integer>e:list)
		{
			System.out.println(e.getKey()+" , "+e.getValue());
			
		}
		for(Entry<Character,Integer>e:list)
		{
            int value=e.getValue();
            for(int z=0;z<value;z++)
                sb.append(e.getKey());
			
		}
		System.out.println(sb.toString());
     return  sb.toString();       
	}
	
}
