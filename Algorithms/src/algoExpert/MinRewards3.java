package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinRewards3 {
	
	public static void main(String[] args) {
		
		int scores[]= {8,4,2,1,3,6,7,9,5};
		
		minRewards(scores);
		
	}
	public static int minRewards1(int[] scores) {
		
		int []rewards=new int [scores.length];
		 Arrays.fill(rewards ,1);
		return 0;
	}
	public static int minRewards(int[] scores) {
		//94%fast
		/// Time (O)N 	my solution with handling case of duplicates
		//Solution 1 
		int []rewards=new int [scores.length];
			 Arrays.fill(rewards ,1);
		//left to right  //considering climbing scores or increasing scores
			 for(int i=1;i<scores.length;i++)
			 {
				 if(scores[i]>scores[i-1])
				 {
					 rewards[i]=rewards[i-1]+1;
				 }
			 }
//right to left // falling or decreasing scores
			 for(int i=scores.length-2;i>=0;i--)
			 {
				 if(scores[i]>scores[i+1])
				 {
					 rewards[i]=Math.max(rewards[i],rewards[i+1]+1);
				 }
			 }
			 traverse(rewards);
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
