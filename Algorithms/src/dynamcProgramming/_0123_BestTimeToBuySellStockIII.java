package dynamcProgramming;

public class _0123_BestTimeToBuySellStockIII {
	
	public static void main(String[] args) {
		
		
		int prices[]= {7,1,5,3,6,4};
		
		maxProfitExpert(prices,2);
	}

	public static int maxProfitExpert(int[] prices,int k) {
		
		// for 2 transactions 
		
		int profit[][]=new int[k+1][prices.length];
		int maxThusFar=Integer.MIN_VALUE;
		
		for(int t=1;t<k+1;t++)
		{
			
			for(int d=1;d<prices.length;d++)
			{
				maxThusFar=Math.max(maxThusFar,profit[t-1][d-1]-prices[d-1]);
				System.out.println(maxThusFar);
				
				profit[t][d]=Math.max(profit[t][d-1],prices[d]+maxThusFar);
				
			}
			System.out.println();
		}
		System.out.println(profit[1][prices.length-1]);
		return 0;
		
	}



}
