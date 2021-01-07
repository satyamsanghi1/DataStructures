package dynamcProgramming;

public class _0309_BestTimeToBuySellStockWithCooldown {
	
	public static void main(String[] args) {
		//youtube link https://www.youtube.com/watch?v=w6xk5Po-DX0
		
		//int prices[]= {3,2,6,5,0,3};
		//int prices[]= {2,1,2,1,0,0,1};
		//int prices[]= {2,1,2,1,0,1,2};
		//int prices[]= {3,2,6,5,0,3};
		//int prices[]= {1,2,3,0,2};
		//int prices[]= {3,3,5,0,0,3,1,4};
		int prices[]= {1,2,3,0,2};
		
	int ans=maxProfit(prices);
	System.out.println("ans "+ans);
	}
	public static int maxProfit(int[] prices) {
		/*Algo 
		 * at any day there are two cases : 
		 * 1 . we have a stock on day i,
		 * 2. we dont have a stock on day i. 
		 * 
		 * a . We have a stock dp[i][1] :
		 * 		 	if we have a stock :(max of 1 ,2)
		 * 				1. we bought it today	
		 * 					dp[i-2][0] means adding the sold value before cooldown (0 -> sell)
		 * 					dp[i-2][0] - prices[i]
		 * 				2. we are carrying forward  prev buy
		 * 					dp[i-1][1]
		 * 
		 * b. We have no stock dp[i][0] :
		 * 		1. we sell it today 
		 * 			dp[i-1][1]+prices[i]
		 * 		2. we are carry forwarding , doing nothing
		 * 			dp[i-1][0]
		 */
		
		int dp[][]=new int [prices.length][2];
		if(prices.length==0)
        return 0;
		
		dp[0][0]=0;
		dp[0][1]=-prices[0];
		
        dp[1][0]=Math.max(dp[0][0],dp[0][1]+prices[1]);
  	  	dp[1][1]=Math.max(dp[0][1],-prices[1]);
  	  	

  	  	for(int i=2;i<prices.length;i++)
  	  	{
  	  		dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
  	  		dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
  	  		System.out.println("dp["+i+"][0]"+ dp[i][0]);
  	  		System.out.println("dp["+i+"][1]"+ dp[i][1]);
  	  		System.out.println("-----------------");
  	  	}
  	  	System.out.println(" val "+dp[prices.length-1][0]);
  	  	return dp[prices.length-1][0];
	}
	
	
}
