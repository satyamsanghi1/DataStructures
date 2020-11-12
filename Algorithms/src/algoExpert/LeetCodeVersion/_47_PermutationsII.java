package algoExpert.LeetCodeVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _47_PermutationsII {
	
	public static void main(String[] args) {
		
		int []nums= {1,1,2};
			//System.out.println(permuteUnique1(nums));
		//System.out.println(permuteUnique(nums));
		System.out.println(permuteUniqueAlter(nums));
		
	}
	
	 public static List<List<Integer>> permuteUnique1(int[] nums) {
		        List<List<Integer>> res = new ArrayList<List<Integer>>();
		        if(nums==null || nums.length==0) return res;
		      
		        boolean [] used=new boolean[nums.length];
		        Arrays.sort(nums);
		        List<Integer>perm=new ArrayList<Integer>();
		        permute1(nums, perm, used, res);
		        return res;
	    }
	 
	 public static void permute1(int [] array,List<Integer>perm,boolean [] used,List<List<Integer>>perms)
	 {
		 // used array is used when we come back from recursion 
		 // and to avoid processing of same elements 
		 //99% Fast
		 
		 if(perm.size()==array.length)
		 {
			 perms.add(new ArrayList<Integer>(perm));
		 }
		 else
		 {
			 for(int i=0;i<array.length;i++)
			 {
				if(used[i])
					continue;
				
				/*
				 * if current and prev element is same and prev boolaean value is false
				 * this means that prev same value is processed and we can skip the current same value
				 * how prev same value is false ?
				 * it is false because , everytime we come back from recursion we undo changes made
				 * to that boolean value to the prev state
				 */
				if(i>0 && array[i]==array[i-1] && !used[i-1])
					continue;
				
				used[i]=true;
				
				perm.add(array[i]);
				System.out.println(perm);
				permute1(array, perm, used, perms);
				perm.remove(perm.size()-1);
				used[i]=false;
			
			 }
		 }
	 }

		public static List<List<Integer>> permuteUniqueAlter(int[] nums) {
			
			
			List<List<Integer>>permutations=new ArrayList<>();
			Arrays.sort(nums);
			helperAlter(0,nums,permutations);
			System.out.println(permutations);
			
			return null;
			}
	 public static void helperAlter(int i,int [] array,List<List<Integer>>perms)
		{
			// Time -> (O)N!.N  +(O)N!.N  =(O)N!.N 
		
			if(i==array.length-1) // n*n!
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
					/*
					 * only the first occurance of element is processed 
					 * rest all are rejected by hashset
					 */
					HashSet<Integer>set=new HashSet<>();
					for(int j=i;j<array.length;j++)
					{
						System.out.print("j "+j+" i "+i+" array : ");
						traverse(array);
						System.out.println();
						if(set.add(array[j]))
						{
						swap(i, j, array);
						helperAlter(i+1, array, perms);
						// n*n!
						swap(i, j, array);
						}
						
					}
				
			}
		
	    }
	public static void swap(int i,int j,int []array)
	{
		int swap=array[i];
		array[i]=array[j];
		array[j]=swap;
	}
		
	
	//solution 3 

	 public static List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>>permutations=new ArrayList<>();
		List<Integer>perm=new ArrayList<Integer>();
		
		List<Integer>array=new ArrayList<>();
		for(int i:nums)
			array.add(i);
		
		helper(array,perm,permutations);
		return permutations;
	 }
	  public static void helper(List<Integer>array,List<Integer>perm,List<List<Integer>>perms)
		{
		  // 22 % Fast
		
			if(array.size()==0)
			{
				perms.add(perm);
				System.out.println("adding "+perm);
			}
			else
			{
				for(int i=0;i<array.size();i++)
				{
					// if current element is same as next element  we skip the current element
					// will process
					if((i+1)<array.size() && array.get(i)==array.get(i+1))
					{
						System.out.println("skipping "+i);
						continue;
					}
				List<Integer>newList=new ArrayList<>();
				newList.addAll(perm);
				newList.add(array.get(i));
			
				List<Integer>l=new ArrayList<>(array);
				l.remove(array.get(i));
				helper(l,newList, perms);
				}
			}
		}
	  public static void traverse(int array[])
		{
			for(int i:array)
				System.out.print(i+" ");
			System.out.println();
		}
	  public static void traverseBoolean(boolean array[])
			{
				for(boolean i:array)
					System.out.print(i+" ");
				System.out.println();
			}

}
