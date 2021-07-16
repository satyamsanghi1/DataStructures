package algoExpert;

public class NumberOfWaysToTraverseGraph3 {
	//Leetcode 62 
	//algoexpert  time (N*M) space(N*M)
	//bottom up approach memoisation
	//top down approach is in dynamic package for leetcode question
	public static void main(String[] args) {


		System.out.println(numberOfWaysToTraverseGraph(4,3));
	}
	public static int numberOfWaysToTraverseGraph(int width, int height) {
		int numberOfWays[][]=new int [width+1][height+1];
		
		for(int widthIdx=1;widthIdx<=width;widthIdx++)
		{
			for(int heightIdx=1;heightIdx<=height;heightIdx++)
			{
				//top or leftmost  border
				if(widthIdx==1 || heightIdx==1)
				{
					numberOfWays[widthIdx][heightIdx]=1;
				}
				else
				{
					int prevWays=numberOfWays[widthIdx-1][heightIdx];
					int aboveWays=numberOfWays[widthIdx][heightIdx-1];
					
					numberOfWays[widthIdx][heightIdx]=aboveWays+prevWays;
				}
			}
		}
		return numberOfWays[width][height];
	}
	

}
