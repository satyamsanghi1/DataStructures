package algoExpert;

import java.util.Arrays;

public class MinRewards {
	
	public static void main(String[] args) {
		
		int scores[]= {1,2,3,4,4,4,2,1};
		
		minRewards1(scores);
		
	}
	public static int minRewards1(int[] scores) {
		//AlgoExpert Solution 
		//5%
		//also handles the case of duplicates
		int []rewards=new int [scores.length];
		
		Arrays.fill(rewards,1);	// intialising with 1 as each student get atlease 1 reward
		for(int i=1;i<scores.length;i++)
		{
			int j=i-1;	// to get backwards and start fixing prev rewards
			
			if(scores[i]>scores[j])
			{
				rewards[i]=rewards[j]+1;
			}
			else
			{
				// if scores in less than prev one  ,then backtrack a
				// and fix prev rewards
				
				while(j>=0 && scores[j]>scores[j+1])
				{
					rewards[j]=Math.max(rewards[j],rewards[j+1]+1);
					/* if the rewards at j already contains the bigger enough 
					eg [4,2] scores
					    5,1	  rewards
					    
					    in this case when we backtrack from 2  at 4  rewards is already 5 
					    we dont have to make rewards at 4 =rewards of 2 (+1)
					*
					*/
					j--;
				}
			}
			
			traverse(rewards);
			System.out.println("-------------");
		}
		int total=0;
		for(int i:rewards)
			total+=i;
		System.out.println("total "+total);
		return total;
	}
	public static int minRewards(int[] scores) {
		/// Time (O)N2 	my solution with handling case of duplicates
		//Solution 1 
		int []rewards=new int [scores.length];
		rewards[0]=1;
		for(int i=1;i<scores.length;i++)
		{
			if(scores[i]>scores[i-1])
			{
				rewards[i]=rewards[i-1]+1;
			}
			else if(scores[i]<scores[i-1])
			{	 
					rewards[i]=1;
					
				//backtrack to  fix
					for(int k=i-1;k>=0 ;k--)
					{
						if(scores[k]>scores[k+1])
						rewards[k]=Math.max(rewards[k],rewards[k+1]+1);	
					}
			}
			else
			{
				//equal
				rewards[i]=1;
						
			}
			
			traverse(rewards);
			System.out.println("-------------");
		}
		int total=0;
		for(int i:rewards)
			total+=i;
		System.out.println("total "+total);
		return total;
		
	}
	public static void traverse(int[] a)
	{
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();
	}

}
