package algoExpert;

import java.util.HashMap;

public class StaircaseTraversal {
	//leetcode climbingStairs
	//mysolution
	public static void main(String[] args) {


		int height=5;
		int maxSteps=2;
		long start=System.currentTimeMillis();
		int ans=staircaseTraversalSW(height, maxSteps);
		System.out.println("time taken "+(System.currentTimeMillis()-start));
		System.out.println("ans "+ans);
	}
	public static int staircaseTraversal(int height, int maxSteps) {
		//Time -> (O)n*K
		//iterative solution
		int [] heightDp=new int [height+1];
		
			heightDp[0]=1;

		for(int i=1;i<=height;i++)
		{
			for(int step=1;step<=maxSteps;step++)
			{
				if(i>=step)
					heightDp[i]+=heightDp[i-step];
				else 
					break;
			}
		}


		//return heightDp[heightDp.length-1];
		HashMap<Integer,Integer>map=new HashMap<>();
		return helper(height,maxSteps,map);
	}
	/*
	 * Without Memoisation TIme -. (O) K^N . k->max steps (width) , n->height (of tree)
	 * Space -> (O) n -> height of tree
	 * 
	 *   With Memoisation :
	 *   Time ->(O) K*n , k->maxSteps,n->height
	 *   Space->(O)n
	 */
	//Recursion + Memoisation
	public static int helper(int height,int maxSteps,HashMap<Integer,Integer>dp)
	{
		if(height==0)
			return 1;
		
		if(dp.containsKey(height))
			return dp.get(height);
		
		int ways=0;
		
		for(int step=1;step<=maxSteps;step++)
		{
			if((height-step)>=0) {
			int way=helper(height-step,maxSteps,dp);
			dp.put(height-step,way);
			ways+=way;
			}
		}	//ways+=helper(height-2,maxSteps);
		return ways;
		
	}
	public static int staircaseTraversalSW(int height, int maxSteps) {
		//SW->Sliding Window
		
		int window[]=new int [height+1];
		window[0]=1;
		int curNoOfWays=0;
		int j=maxSteps;
		for(int i=1;i<=height;i++)
		{
			System.out.println("window at "+i);
			if(i>maxSteps)
			{
				System.out.println("deduct "+window[i-1-maxSteps]);
				curNoOfWays-=window[i-1-maxSteps];
			}
				curNoOfWays+=window[i-1];
				window[i]=curNoOfWays;
			
			System.out.println(" cur "+curNoOfWays);
			System.out.println("-----------------");
			
		}
		return curNoOfWays;
	}
}
