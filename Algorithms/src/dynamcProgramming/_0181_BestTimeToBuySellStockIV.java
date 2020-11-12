package dynamcProgramming;

public class _0181_BestTimeToBuySellStockIV {
	
	public static void main(String[] args) {
		
		
		int prices[]= {7,1,5,3,6,4};
		
		System.out.println(maxProfitExpert(prices,20));
	}

	public static int maxProfitExpert(int[] prices,int k) {
		
		
		
		//time limit exceeded case if transactions is greater than half size]
		// then calculate profit with max transactions
		if(k>=prices.length/2)
			return maxTransactionsProfit(prices);
		
		
		int evenProfits[]=new int [prices.length];
		int oddProfits []=new int [prices.length];
		
		int previousProfits[]=null;
		int currentProfits[]=null;
		
		for(int t=1;t<k+1;t++)
		{
			int maxThusFar=Integer.MIN_VALUE;
			
			if(t%2!=0)
			{
				previousProfits=evenProfits;
				currentProfits=oddProfits;
			}
			else
			{
				previousProfits=oddProfits;
				currentProfits=evenProfits;
			}
			for(int d=1;d<prices.length;d++)
			{
	
				maxThusFar=Math.max(maxThusFar,previousProfits[d-1]-prices[d-1]);
				currentProfits[d]=Math.max(currentProfits[d-1],prices[d]+maxThusFar);
			}
			System.out.println();
		}
		//System.out.println(currentProfits[prices.length-1]);
		return currentProfits[prices.length-1];
		
	}
	public static int maxTransactionsProfit(int[] prices) {
		
		 
	            int profit=0;
	            for(int d=1;d<prices.length;d++)
	            {
	                if(prices[d]>prices[d-1])
	                    profit+=(prices[d]-prices[d-1]);
	            }
	            return profit;
	        
	}



}
