package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
	//Leetcode 78 Subsets 
	
	public static void main(String[] args) {
		
		List<Integer>array=new ArrayList<Integer>(Arrays.asList(1,2,3));
		System.out.println(powerset(array));
		
	}
	 public static List<List<Integer>> powerset(List<Integer> array) {
		    // Write your code here.
				List<List<Integer>>list=new ArrayList<>();
				list.add(new ArrayList<Integer>());
				List<Integer>current=new ArrayList<>();
				helper(0,array,current,list);
		    return list;
		  }
	public static void helper(int i,List<Integer>array,List<Integer>current,List<List<Integer>>list)
	{
		for(int k=i;k<array.size();k++)
		{
		current.add(array.get(k));
			list.add(new ArrayList<Integer>(current));
			helper(k+1,array,current,list);
			current.remove(array.get(k));
		}
	}
}
