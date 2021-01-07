package dynamcProgramming;

public class _0122_BestTimeToBuySemmStockII2 {

	//100%Fast
	//create graph 
	public static void main(String[] args) {
		
		int []prices= {7,1,5,3,6,4};
		
		
		maxProfit(prices);
	}
	public static int maxProfit(int[] prices) {
        
        if(prices.length==0)
           return 0;
    int total=0;
        for(int i=1;i<prices.length;i++)
        {
        	if(prices[i]-prices[i-1]>0)
        		total+=prices[i]-prices[i-1];
        }
        System.out.println("total "+total);
        return total;
   }
}
