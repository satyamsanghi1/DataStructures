package dynamcProgramming;

public class _0122_BestTimeToBuySemmStockII {

	//my solution
	public static void main(String[] args) {
		
		int []prices= {7,1,5,3,6,4};
		
		
		
	}
	public int maxProfit(int[] prices) {
        
        if(prices.length==0)
           return 0;
       int price[]=new int [prices.length];
       int lowest=prices[0];
       int total=0;
       int current=0;
       for(int i=1;i<price.length;i++)
       {
       if(prices[i]>lowest)
       {
          int profit=prices[i]-lowest;
           
           if(profit>current)
           {
               current=profit;
           }
           else
           {
               total+=current;
               current=0;
               lowest=prices[i];
           }
       }
       else
       {
       lowest=prices[i];
           total+=current;
           current=0;
       }
           
       }
     if(current!=0)
         total+=current;
       return total;
       
   }
}
