package algoExpert;

import java.util.Arrays;

public class SingleCycleCheck {
	static int x=0;
	public static void main(String[] args) {
		
	int []array= {2, 3, 1, -4, -4, 2};
	
	boolean ans=hasSingleCycle(array);
	System.out.println("ans "+ans);
	}
	
	 public static boolean hasSingleCycle(int[] array) {
		  
		int visited=0;
		int current=0;
		// checking that we visit all the elements once
		while(visited<array.length)
		{
			//if before reached the current , means we have not used all the elemenets
			//there exists multiple cycles 
			//>0 tells to check for reamaing elements not 0
			if(visited>0 && current==0)
				return false;
			visited++;
			
			current=getNextIndex(current,array);
			System.out.println("current "+current);
			
		}
		System.out.println("visited "+visited);
		
		/*if visited no of elements exceeded the lemgth and still we are 
		 * not reached the first index or reached 
		 */
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
