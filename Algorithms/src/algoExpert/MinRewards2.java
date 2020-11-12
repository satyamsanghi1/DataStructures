package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinRewards2 {
	
	public static void main(String[] args) {
		
		int scores[]= {1,4,1,3,2,1,1,1,1,1,2,3,4};
		
		minRewards(scores);
		
	}
	public static int minRewards1(int[] scores) {
		
		int []rewards=new int [scores.length];
		 Arrays.fill(rewards ,1);
		return 0;
	}
	public static int minRewards(int[] scores) {
		//22%Fast
		/// Time (O)N 	my solution with handling case of duplicates
		//Solution 1 
		int []rewards=new int [scores.length];
			 Arrays.fill(rewards ,1);
		//step 1 finding local mins
		List<Integer>localMins=findLocalMins(scores);
		
		System.out.println("mins "+localMins);
		for(int localMin:localMins)
		{
		expandLocalMins(rewards, scores, localMin);
		traverse(rewards);
		}
		int total=0;
		for(int i:rewards)
			total+=i;
		
		System.out.println("total "+total);
		return total;
		
	}
	public static void expandLocalMins(int []rewards,int []scores,int localMins)
	{
		System.out.println("at "+localMins);
		int leftIdx=localMins-1;
		//expanding left
		while(leftIdx>=0 && scores[leftIdx]>scores[leftIdx+1])
		{
			rewards[leftIdx]=Math.max(rewards[leftIdx],rewards[leftIdx+1]+1);
			leftIdx--;
			System.out.println("left");
		}
		
		int rightIdx=localMins+1;
		
		while(rightIdx<scores.length && scores[rightIdx-1]<scores[rightIdx])
		{
			rewards[rightIdx]=rewards[rightIdx-1]+1;
			rightIdx++;
			System.out.println("right");
		}
		
			
	}
	public static List<Integer>findLocalMins(int scores[])
	{
		//my solution
		List<Integer>mins=new ArrayList<>();
		int n=scores.length-1;
		
		
		
		for(int i=0;i<scores.length;i++)
		{
			if(i==0 && scores[i]<scores[i+1])
				mins.add(i);
			if(i==n && scores[n]<scores[n-1])
				mins.add(n);
			
			if(i==0 || i==n ) // if above 2 condiotion dont match than skip i==0 or i=n
				continue;
			if(scores[i]<=scores[i-1] && scores[i]<=scores[i+1]) // equals applying duplicate conditon
				mins.add(i);
		}
		
	
		
		return mins;
	}
	public static void traverse(int[] a)
	{
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();
	}

}
