package algoExpert;

public class NumberOfWaysToMakeChange {
	// LEETCODE 322
	
	//REFERENCES 
	
	//https://www.youtube.com/watch?v=PafJOaMzstY
	
	//https://www.geeksforgeeks.org/understanding-the-coin-change-problem-with-dynamic-programming/
	
	//https://www.youtube.com/watch?v=DJ4a7cmjZY0 // BACK2BACK SWE
	public static void main(String[] args) {
		
		int coins[]= {1,2,5};
		
		coinChange(coins,5);
	}
	public static int coinChange(int[] coins, int amount) {
        
		int amounts[]=new int[amount+1];
		amounts[0]=1;
		
		for(int i=0;i<coins.length;i++)
		{
			for(int j=0;j<amounts.length;j++)
			{
				if(coins[i]<=j)
				{
					amounts[j]=amounts[j]+amounts[j-coins[i]];
					
				}
				System.out.print(amounts[j]+" ");
			}
			System.out.println();
		}
		System.out.println("final ways to make "+amount +" is " +amounts[amounts.length-1]);
		return 0;
    }

}
