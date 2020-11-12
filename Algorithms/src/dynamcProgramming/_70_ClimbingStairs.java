package dynamcProgramming;

import java.util.HashMap;

public class _70_ClimbingStairs {
	
	// similar like fiboncaacii series 
	public static void main(String[] args) {
		
		System.out.println("aanswer "+climbStairsAlter1(6));
		
	}
	 public static int climbStairsAlter(int n) {
		 
		 // bottom up approach using extra space 
		 // ways for each stairs // breaking problem into smaller sub problems 
		 int stairs[]=new int[n+1];
		 //base cases
 		 stairs[0]=1; // for 0 step , there is 1 way by not stepping it
		 stairs[1]=1; // for 1 step, there are 1 one way by stepping one step
		 
		 for(int i=2;i<=n;i++)
		 {
			 // ways for current step = ways for current step-1 + ways for current step -2
			 stairs[i]=stairs[i-1]+stairs[i-2];
			 System.out.println(i+" step ways "+stairs[i]);
			 
		 }
		 
		 return stairs[n];
	 }
	 
	 public static int climbStairsAlter1(int n) {
			 
			 int first=1;// for 0 step , there is 1 way by not stepping it
			 int second=1;// for 1 step, there are 1 one way by stepping one step
			 
			 for(int i=2;i<=n;i++)
			 {
				 int currentStepWays=first+second;
				 System.out.println("currentStepWays "+currentStepWays);
				 second=first;
				 first=currentStepWays;
			 }
			 return (first);
	 }
	 public static int climbStairs(int n) {
		 
		
		 HashMap<Integer,Integer>map=new HashMap<>();
		return helper(n, map);
		 //return 0;	
	 }
	 
	 public static int helper(int n, HashMap<Integer,Integer>map)
	 {
		// using memoization and top down approach i dynamic programming
		 if(n==-1)
			 
			 return 0;
		 
		 if(n==0)
			 return 1;
		 
		 if(map.containsKey(n))
			 return map.get(n);
		 
		  map.put(n, helper(n-2,map)+helper(n-1,map));
		  
		  return map.get(n);
	 }

}
