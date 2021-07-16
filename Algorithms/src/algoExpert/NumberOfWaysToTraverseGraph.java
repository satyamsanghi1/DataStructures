package algoExpert;

public class NumberOfWaysToTraverseGraph {
	//Leetcode 62 
	//algoexpert brute force naice  time exponential 2^(N+M)
	//space (N+M) to rach base case atmost N+M calls on call stack
	//bottom up approach
	//top down approach is in dynamic package for leetcode question
	public static void main(String[] args) {
		
		System.out.println(helper(4,3));
	}
	public static int helper(int m,int n)
	{
		//1 because not using 0-indexing
		//when first row and first column there is only one way 
		if(m==1 || n==1)
			return 1;
		
		//ways to reach current box is sum of ways if (above and left box) 
		return helper(m-1,n)+helper(m,n-1);
	}
	
}
