package dynamcProgramming;

public class _0309_BestTimeToBuySellStockWithCooldown {
	
	public static void main(String[] args) {
		
		
		//int prices[]= {3,2,6,5,0,3};
		//int prices[]= {2,1,2,1,0,0,1};
		//int prices[]= {2,1,2,1,0,1,2};
		//int prices[]= {7,1,5,3,6,4};
		int prices[]= {3,3,5,0,0,3,1,4};
		maxProfit(prices);
	}
	public static int maxProfit(int[] prices) {
		
		
		
		int maxThusFar=Integer.MAX_VALUE;
		int maxProfit=0;
		int prevD=0;
		int profit=0;
		int transaction=0;
		int currentD=0;
		for(int d=1;d<prices.length;d++)
		{
			
			System.out.println("d "+d);
			//maxThusFar=Math.max(-prices[d-1],maxThusFar);
			
			
			System.out.println("maxprofit "+maxProfit);
			System.out.println("prev trans "+transaction);
			maxThusFar=Math.min(prices[d-1],maxThusFar);
			System.out.println("thusfar "+maxThusFar);
			int currentTransaction=0;
			if(maxThusFar<prices[d])
			{	
				//maxThusFar=prices[d-1];
				
				currentTransaction=prices[d]-maxThusFar; 
			
				System.out.println("current trans "+currentTransaction);
				maxProfit=0;
				currentD=d;
				if(currentTransaction>transaction)
				{
					maxThusFar=Integer.MAX_VALUE;
				d+=2;	
				//profit+=currentTransaction;
				}
				System.out.println("prevD "+prevD);
				System.out.println("currentD-prevD "+(currentD-prevD));
				if(currentD-prevD>1)
				{
					System.out.println("here");
					profit+=currentTransaction;
				}
				else if(currentD-prevD<=1)
				{
					System.out.println("else");
					profit-=transaction;
					profit+=currentTransaction;
				}
				prevD=currentD;
			
				System.out.println("profit "+profit);
				transaction=currentTransaction;
				currentTransaction=0;
				
			}
			System.out.println();
			
		}
		System.out.println();
		System.out.println("profit "+profit);
		
		
		 maxThusFar=Integer.MIN_VALUE;
		 maxProfit=0;
		
		
		for(int d=1;d<prices.length;d++)
		{
			maxThusFar=Math.max(-prices[d-1],maxThusFar);
			//System.out.println("thusfar "+maxThusFar);
			
			maxProfit=Math.max(maxProfit,prices[d]+maxThusFar);
		}
		System.out.println("maxProfit "+maxProfit);
		
		int ans=maxProfit>profit?maxProfit:profit;
		
		System.out.println("ans "+ans);
		
		return maxProfit;
	}


	
}
