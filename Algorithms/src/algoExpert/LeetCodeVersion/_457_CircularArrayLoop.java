package algoExpert.LeetCodeVersion;

import java.util.Arrays;

public class _457_CircularArrayLoop {
	//https://leetcode.com/problems/circular-array-loop/discuss/94148/Java-SlowFast-Pointer-Solution
	//algo expert single cycle check
	
	//incomplete difficult
	public static void main(String[] args) {
		
	int []array= {2,-1,1,-2,-2};
	
	boolean ans=hasSingleCycle(array);
	System.out.println("ans "+ans);
	}
	
	 public static boolean hasSingleCycle(int[] array) {
		  
		int visited=0;
		int current=0;
		while(visited<array.length)
		{
			
			if(visited>0 && current==0)
			{
				System.out.println("here");
				return true;
			}
			visited++;
			
			current=getNextIndex(current,array);
			System.out.println("current "+current);
			
		}
		System.out.println("visited "+visited);
		
		    return current==0;
		  }
	 
	 public static int getNextIndex(int current,int[]array)
	 {
		 
		 int jump=array[current];
		 
		 int nextIdx=(jump+current)%array.length;
		 
		 if(nextIdx>=0)
			 return nextIdx;
		 else
			 return nextIdx+array.length;
	 }
	 
	
}
