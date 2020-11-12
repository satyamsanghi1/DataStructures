package algoExpert;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {
	
	public static void main(String[] args) {
		
		int coins[]= {5,2,1};
		
		System.out.println("answer "+coinChange(coins,7));
	}
	public static int coinChangeAlter(int[] coins, int amount) {
		
		double noOfCoins[]=new double[amount+1];
		// we are filing array with max value so that we can find minimum no of coins
		// this will work for initial conditions 
		Arrays.fill(noOfCoins,Double.MAX_VALUE);
		noOfCoins[0]=0;
		for(int i=0;i<coins.length;i++)
		{
			System.out.println("current coin is  "+coins[i]);
			for(int currentAmount=0;currentAmount<noOfCoins.length;currentAmount++)
			{
				//almost same approach as below method
				if(coins[i]<=currentAmount)
				{
					int a=currentAmount-coins[i];
					System.out.println("a "+a);
					System.out.println("dif "+noOfCoins[a]+1);
					noOfCoins[currentAmount]=Math.min(noOfCoins[currentAmount],noOfCoins[a]+1);
				}
				
			}
			System.out.println();
			traverse(noOfCoins);
			System.out.println();
		}
		
		if(amount==0)
			return 0;
		
		if(noOfCoins[noOfCoins.length-1]==Double.MAX_VALUE)
		{
			System.out.println("here");
			return -1;
		}
		else
			return (int)noOfCoins[noOfCoins.length-1];
		
		//return noOfCoins[noOfCoins.length-1]!=Integer.MAX_VALUE?noOfCoins[noOfCoins.length-1]:-1;
	}
	public static int coinChange(int[] coins, int amount) {
        
		//Arrays.sort(coins);
		
		int noOfCoins[]=new int[amount+1];
		
		for(int i=0;i<coins.length;i++)
		{
			System.out.println("current coin is  "+coins[i]);
			for(int j=0;j<noOfCoins.length;j++)
			{
				// will update no of coins only when the current amount
				// is smaller or equal to the coin amount
				if(j>=coins[i])
				{
					/*
					 * Step 1: subtract the coin amount from curent amount  i.e. a
					 * Step 2 : go to that amount a to find no of coins for that subtracted amount i.e. x
					 * 
					 * Step3 : if a is 0 then update the no. of coins directly
					 * 
					 * Step 4: if a is not zero , means eg amount is 5 , current coin is 3
					 * difference is 2 , we go to 2 , and check coins at 2 , if it is greater than 1
					 * we update the no of coins i.e . x is greater than 1 .
					 * else x is 0, we do not update because we cannot calculate 5 with only coin 3 available
					 * 
					 * 
					 * Step 5: when updating 
					 *        Step 1 : We check for min coins only when ,the coins at that amount is at lease 1 
					 *        other wise it will give 0 all the time 
					 *        -> if it is zero , we do not check for the minimum, update directly 
					 *        i.e. x+1 , +1 becaouse we are subtracting current coin , hence adding a coin
					 */
					int a=j-coins[i];
					int x=noOfCoins[a];
					System.out.println("at amount "+j+" a "+a+" x "+x);
					// this condition will work when coins are not sorted
				if(x!=0 || a==0)
				{
					if(noOfCoins[j]>=1)
				noOfCoins[j]=Math.min(x+1,noOfCoins[j]);
					else
						noOfCoins[j]+=x+1;
				
				}
				}
			}
			
			System.out.println();
			traverseInt(noOfCoins);
			System.out.println();
			//break;
			//break;
			
		}
		//System.out.println("ans "+noOfCoins[noOfCoins.length-1]);
		return noOfCoins[noOfCoins.length-1];	
    }

	
	
	public static void traverse(double a[])
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
	public static void traverseInt(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
	}

}
