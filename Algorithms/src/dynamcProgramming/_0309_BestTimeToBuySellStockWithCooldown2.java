package dynamcProgramming;

public class _0309_BestTimeToBuySellStockWithCooldown2 {
	
	public static void main(String[] args) {
		//youtube link https://www.youtube.com/watch?v=w6xk5Po-DX0
		//techdose
		
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
		//with help of state transition diagram
		
		int dp[][]=new int [prices.length][3];
		
		/*dp[i][0] -> Rest State initiallly
		 * dp[i][1] -> Buy State
		 * dp[i][2] -> Sell State
		 * 
		 * 
		 * We can come to Rest state by :
		 * 		selling stock or we have no stack
		 * 
		 * We can come to sell state : 
		 * 			by selling stock
		 * 
		 * WE can come to buy state : 
		 * 			by bying stock from rest state or doing nothing
		 * 
		 * 
		 */
		
		dp[0][0]=0;
		dp[0][1]=-prices[0];
		dp[0][2]=0;
		
		for(int i=1;i<prices.length;i++)
		{
			dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]);
			dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
			dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
		}
		return Math.max(dp[prices.length-1][0],dp[prices.length-1][2]);
	}
	
	
}
