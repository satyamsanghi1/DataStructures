package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Practice {
	
	public static void main(String[] args) {
		
	

			int a[]= {10,20,30,40,50,60,70,80};
			//
			int groupsize=3;
			int i=0;
			
			while(i<a.length)
			{	
					int limit=i+groupsize-1;
				
						System.out.println(i+" , "+limit);
						if(limit>=a.length)
							break;
						reverse(i,limit,a);
					
					i+=groupsize;
				
			}
			System.out.println("i "+i);
			if(i<a.length)
			{
				reverse(i,a.length-1, a);
			}
			
			traverse(a);
			
			
			
			
	}
	public static void reverse(int start,int end,int[]array)
	{
		System.out.println("start "+start+"end "+end);
		int temp=0;
		
		
		while(start<end)
		{
			
			temp=array[start];
			array[start]=array[end];
			array[end]=temp;
			start++;
			end--;
		}
	}
	public static void traverse(int []a)
	{
		System.out.println();
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();
	}
	
	

}
