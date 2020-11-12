package algoExpert.LeetCodeVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class _1424_DiagonalTraverseII {
	// https://leetcode.com/problems/diagonal-traverse-ii/discuss/597698/JavaC%2B%2B-HashMap-with-Picture-Clean-code-O(N)
	public static void main(String[] args) {
		
		
		List<List<Integer>>nums=new ArrayList<>();
	
		
		nums.add(Arrays.asList(1,2,3,4,5));
		nums.add(Arrays.asList(6,7));
		nums.add(Arrays.asList(8));
		nums.add(Arrays.asList(9,10,11));
		nums.add(Arrays.asList(12,13,14,15,16));
		findDiagonalOrder(nums);

	}
	 public static int[] findDiagonalOrder(List<List<Integer>> nums) {
		 //35%Fast //linkedHashMap stores the order
		 LinkedHashMap<Integer,List<Integer>>map=new LinkedHashMap<>();
		 
		 List<Integer>temp=new ArrayList<>();
		 for(int i=0;i<nums.size();i++)
		 {
			 for(int j=0;j<nums.get(i).size();j++)
			 {
				 int sum=i+j;
				 if(map.containsKey(sum))
				 {
					 List<Integer>a=map.get(sum);
					 a.add(0,nums.get(i).get(j));
					 map.put(sum,a);
				 }
				 else
				 {
					 List<Integer>a=new ArrayList<Integer>();
					 a.add(0,nums.get(i).get(j));
					 map.put(sum,a);
					 
				 }
				 System.out.println(nums.get(i).get(j));
				 
			 }
			 
		 }
		 
		 for(int i=0;i<map.size();i++)
		 {
			 temp.addAll(map.get(i));
		 }
		/* map.forEach((k,v)->{			 not maintained order 
			 temp.addAll(v);
			 System.out.println("k "+k+" v "+v);
		 });*/
		 System.out.println("ans "+temp);
		 int k=0;
		   int ans[]=new int [temp.size()];
	        for(int j:temp)
	            ans[k++]=j;
		 return null;
	 }
	 public static int[] findDiagonalOrder1(List<List<Integer>> nums) {
	     //Time limit exceeded because we are traversing for that index in matrix 
		 //	 for which the value in matrix does not even exist
	        int row=0;
	        int column=0;
	        int height=nums.size()-1;
	        int width=nums.get(0).size()-1;
	        //finding width of column with greatest width 
	        
	        for(List<Integer>col:nums)
	        {
	        	width=Math.max(width,col.size());
	        }
	      
	       
	        int k=0;
	        List<Integer>temp=new ArrayList<>();
	     
	        for(int i=0;i<nums.size();i++)
	        {
	        	row=i;
	        	column=0;
	        	while(column<=width && row>=0)
	        	{	
	        	if(nums.get(row)!=null &&	column<nums.get(row).size())
	        	{
	        		temp.add(nums.get(row).get(column));
	        		//System.out.println(nums.get(row).get(column));
	        	}
	        	row--;
	        	column++;
	        	}
	
	        }
	        for(int i=1;i<=width;i++)
	        {
	        	column=i;
	        	row=height;
	        	while(column<=width && row>=0)
	        	{	
	        	if(nums.get(row)!=null &&	column<nums.get(row).size())
	        	{
	        		temp.add(nums.get(row).get(column));
	        		//System.out.println(nums.get(row).get(column));
	        	}
	        	row--;
	        	column++;
	        	}
	        	
	        }
	        	System.out.println("temp "+temp);
	        System.out.println(" out row "+row+" column "+column);
	        int ans[]=new int [temp.size()];
	        for(int j:temp)
	            ans[k++]=j;
	        traverse(ans);
	        return ans;
	        
	    }
	 public static void traverse(int []ans)
	 {
		 for(int i:ans)
			 System.out.print(i+" ");
		 System.out.println();
	 }

}
