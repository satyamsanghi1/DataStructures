package dynamcProgramming;

public class _746_MinCostClimbingStairs {
	
	public static void main(String[] args) {
		
		int cost[]= {10,15,20};
		
		minCostClimbingStairsAlter1(cost);
	}
	public static int minCostClimbingStairs(int[] cost) {
        
		//with extra space 
		int a[]=new int[cost.length+1];
		
		
		
		for(int i=2;i<cost.length+1;i++)
		{
			//calculating min cost required at each index 
			
			/*
			 * We are doing  addition of min cost till that step i.e. a[i-1]
			 * and cost to reach next sttep i.e. cost[i-1]
			 * 
			 * Similarly fir cost[i-2]
			 */
			
			a[i]=Math.min(a[i-1]+cost[i-1],a[i-2]+cost[i-2]);
			
			System.out.println("a["+i+"] "+a[i]);
		}
		
		return 0;
		
    }
	public static int minCostClimbingStairsAlter1(int[] cost) {
        
		
		int first=0;
		int second=0;
		int current=0;
		for(int i=cost.length-1;i>=0;i--)
		{
			//calculating min cost required at each index  from backwards 
		
			current=cost[i]+Math.min(first,second);
			System.out.println("current "+current);
			second=first;
			first=current;
			
		}
		System.out.println("answer  " +Math.min(second,first));
		// can start from first or second 
		return Math.min(second,first);
		
    }	
	
	public static int minCostClimbingStairsAlter(int[] cost) {
        
		int a[]=new int[cost.length+1];
		
		//initially first will be zero as we can start from 0 we require 0 cost
		int first=0;
		//similarly as first for second , we can start from second as well 
		int second=0;
		int current=0;
		for(int i=2;i<cost.length+1;i++)
		{
			
			/*
			 * at a time we only require prev max or prev to prev max 
			 */
			//a[i]=Math.min(a[i-1]+cost[i-1],a[i-2]+cost[i-2]);
			
			
			/*
			 * We are doing  addition of min cost till that step i.e. first
			 * and cost to reach next sttep i.e. cost[i-1]
			 * 
			 * Similarly fir cost[i-2] and second
			 */
		 current=Math.min(first+cost[i-1],second+cost[i-2]);
		 	// as first is i-1 , in next iter it will become i-2
			second=first;
			// as current is i , in next iter it will become i-1
			first=current;
			System.out.println("a["+i+"] "+a[i]);
		}
		
		System.out.println("answer "+current);
		return 0;
		
    }

}
