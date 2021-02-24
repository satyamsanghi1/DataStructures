package algoExpert;

import java.util.ArrayList;import java.util.Arrays;
import java.util.HashMap;

public class CycleInGraph {
		//mysolution
	public static void main(String[] args) {


		int [][]edges=new int [][] {{1,3},{2,3,4},{0},{},{2,5},{}};
		
		cycleInGraph(edges);
	}
	public static boolean cycleInGraph(int[][] edges) {

		HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
		int i=0;
		for(int []edge:edges)
		{
			ArrayList<Integer>list=new ArrayList<>();
			for(int a:edge)
				list.add(a);
			
			map.put(i++,list);
			System.out.println("map "+map.toString());
			
			for(int z:list)
			{
				boolean val=helper(map.get(z), map,z);
				System.out.println("val "+val);
				System.out.println("_______");
			}
			
		
			System.out.println("---------------");
		}

		return false;
	}
	
	public static boolean helper(ArrayList<Integer>list,HashMap<Integer,ArrayList<Integer>>map,int val)
	{
		
		if(list==null)
			return false;
		
		
			System.out.println("list "+list);
		for(int i:list)
		{
			if(i==val)
				return true;
			
			boolean bool=helper(map.get(i), map,val);
			if(bool)
				return true;
		}
		
		return false;
	}

}


