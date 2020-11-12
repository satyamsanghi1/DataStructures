package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapSackProblem {
	
	public static void main(String[] args) {
		
		
		int [][]items= {{1,2},{4,3},{5,6},{6,7}};
		
		knapsackProblem(items,10);
	}
	  public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
		    // Write your code here.
		    // Replace the code below.
		   
		  int [][]dp=new int[items.length+1][capacity+1];
		
		  for(int i=1;i<dp.length;i++)
		  {
			 for(int j=0;j<dp[0].length;j++)
			 {
				 int value=0;
				if(items[i-1][1]<=j)
				{
					 value=dp[i-1][j-items[i-1][1]]+items[i-1][0];

				}
				
				dp[i][j]=Math.max(value,dp[i-1][j]);
				 
			 }
			 traverse(dp[i]);
			 
		  }
		 
		  System.out.println("ans "+dp[dp.length-1][dp[0].length-1]);
		  generateList(dp, items,capacity);
		  return null;
		  }
	  
	  public static List<List<Integer>> generateList(int dp[][],int [][]items,int capacity)
	  {
		  int i=dp.length-1;
		  int j=dp[0].length-1;
		
		  List<List<Integer>>knapsack=new ArrayList<>();
		  knapsack.add(Arrays.asList(dp[i][j]));
		  System.out.println("knap "+knapsack);
			List<Integer>list=new ArrayList<>();
		  while(i!=0)
		  {
			  System.out.println("i "+i+" j "+j);
			  if(dp[i][j]!=dp[i-1][j])
			  {
			
				list.add(i-1);
				System.out.println("item "+items[i-1][0]+","+items[i-1][1]);
				 j=j-items[i-1][1];
				 i--;
			  }
			  else if(dp[i][j]==dp[i-1][j])
			  {
				  i--;
			  }
			  
			  System.out.println(knapsack);
			  System.out.println("-----------------------");
		  }
		  knapsack.add(list);
		  System.out.println("ans list "+knapsack);
		  return knapsack;
		  
	  }
	  public static void traverse(int a[])
	  {
		  for(int i:a)
		  {
			  System.out.print(i+" ");
		  }
		  System.out.println();
	  }

}
