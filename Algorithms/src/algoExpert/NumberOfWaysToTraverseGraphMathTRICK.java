package algoExpert;

public class NumberOfWaysToTraverseGraphMathTRICK {
	//Leetcode 62 
	//algoexpert  time (N+M) space(1)

	public static void main(String[] args) {

		System.out.println(numberOfWaysToTraverseGraph(4,3));
	}
	public static int numberOfWaysToTraverseGraph(int width, int height) {
	
		/*
		 * Applying concept of permutations
		 * if w=3;
		 * h=3
		 * 
		 * to reach end there will be {R,R,D,D} steps atmost
		 * total ways is the permutations of this 
		 * hence will apply permutations formula, nCr
		 * 	
		 * 	(R! + D!) /R! x D!
		 */
		
		int xDistanceToCorner=width-1;
		int yDistanceToCorner=height-1;
		
		int numerator=fact(xDistanceToCorner+yDistanceToCorner);
		int deominator=fact(xDistanceToCorner)*fact(yDistanceToCorner);
		
		return numerator/deominator;
	}
	public static int fact(int n)
	{
		int f=1;
		for(int i=1;i<=n;i++)
		{
			f*=i;
		}
		return f;
	}
	
}
