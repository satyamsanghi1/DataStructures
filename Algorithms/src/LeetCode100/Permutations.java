package LeetCode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	//LEETCODE 46
	//LEETCODE 47,PERMUTATIONS II in leetcodeVersion package
	public static void main(String[] args) {
		
		int nums[]= {1,1,2};
		
		 System.out.println(permute(nums));
	}

	public static List<List<Integer>> permute(int[] nums) {
		
		List<List<Integer>>permutations=new ArrayList<>();
		List<Integer>perm=new ArrayList<Integer>();
		
		List<Integer>array=new ArrayList<>();
		for(int i:nums)
			array.add(i);
		
		helper(array,perm,permutations);
		System.out.println("ans "+permutations);
		return null;
	}
	
	public static void helper(List<Integer>array,List<Integer>perm,List<List<Integer>>perms)
	{
		// Time -> =(O)N!.N.N 
	
		if(array.size()==0)
		{
			perms.add(perm);
			//System.out.println("adding "+perm);
		}
		else
		{
			for(int i=0;i<array.size();i++)
			{
				System.out.println("array "+array);
			List<Integer>newList=new ArrayList<>();
			newList.addAll(perm);
			newList.add(array.get(i));
			
			List<Integer>l=new ArrayList<>(array);
			l.remove(array.get(i));
			helper(l,newList, perms);
			}
		}
	}
	public static List<List<Integer>> permuteAlter(int[] nums) {
		
		
		List<List<Integer>>permutations=new ArrayList<>();
		
		helperAlter(0,nums,permutations);
		System.out.println(permutations);
		
		return null;
		}
		public static void helperAlter(int i,int [] array,List<List<Integer>>perms)
		{
			// Time -> (O)N!.N  +(O)N!.N  =(O)N!.N 
		
			if(i==array.length) // n*n!
			{
				List<Integer>perm=new ArrayList<Integer>();
				for(int x:array) // (O)N
					perm.add(x);
				System.out.println(perm);
				//traverse(array);
				perms.add(perm);
			}
			else
			{
				for(int j=i;j<array.length;j++)
				{
					// j=i becaouse for first time we dont want to swap ,we want permutations as it is
					swap(i, j, array);
					helperAlter(i+1, array, perms);// n*n!
					swap(i, j, array);
					
				}
			}
		
	    }
	public static void swap(int i,int j,int []array)
	{
		int swap=array[i];
		array[i]=array[j];
		array[j]=swap;
	}
	public static void traverse(int array[])
	{
		for(int i:array)
			System.out.print(i+" ");
		System.out.println();
	}

}
