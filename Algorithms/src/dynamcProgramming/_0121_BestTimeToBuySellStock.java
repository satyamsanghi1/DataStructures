package dynamcProgramming;

public class _0121_BestTimeToBuySellStock {
	
	public static void main(String[] args) {
		
		
		int prices[]= {7,1,5,3,6,4};
		
		Alter(prices);
	}
	public static int Alter(int[] prices) {
		// when transaction is 1 
		int maxThusFar=Integer.MIN_VALUE;
		int maxProfit=0;
		
		
		for(int d=1;d<prices.length;d++)
		{
			maxThusFar=Math.max(-prices[d-1],maxThusFar);
			System.out.println("thusfar "+maxThusFar);
			
			maxProfit=Math.max(maxProfit,prices[d]+maxThusFar);
		}
		System.out.println(maxProfit);
		
		return maxProfit;
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
	public static int maxProfitAlter(int[] prices) {
		
		// when transaction is 1 
		int maxProfit=0;

		int minPrice=Integer.MAX_VALUE;
		for(int i=0;i<prices.length;i++)
		{
			
			int max=0;

			if(minPrice<prices[i])
			{
				max=prices[i]-minPrice;
				
			}
			else
			{	
				minPrice=prices[i];
			}
			System.out.println("minPrice "+minPrice);
			
			maxProfit=Math.max(maxProfit,max);

			System.out.println("maxProfit "+maxProfit);
			System.out.println();
			
		}
		System.out.println("maxProfit "+maxProfit);
		return 0;
	}
	public static int maxProfit(int[] prices) {

		/// brute force 
		int maxProfit=0;
		
		//int pr[]=new int[prices.length];
		
	
		for(int i=1;i<prices.length;i++)
		{
			
			
			int max=0;
			
			for(int k=0;k<i;k++)
			{
				int profit=prices[i]-prices[k];
				max=Math.max(max,profit);
			}
			maxProfit=Math.max(maxProfit,max);
			
			//pr[i]=max;
			
			System.out.println("max "+max);
			
		}
		
		System.out.println("maxProfit "+maxProfit);
		return 0;
	}

}
