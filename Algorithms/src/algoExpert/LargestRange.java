package algoExpert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LargestRange {
		///leetcode 128
	public static void main(String[] args) {
		
		int []array= {1,11,0,3,15,5,2,4,10,7,12,6};
		//int []array= {1,0,-1};

		largestRange1(array);
	}
	 public static int[] largestRange1(int[] array) {
		 
		 HashMap<Integer,Boolean>map=new HashMap<>();
		
		 for(int i=0;i<array.length;i++)
		 {
			 map.put(array[i],false);
		 }
		 
		int largest=0;
		 int i=0;
		 int start=0;
		 int end=0;
		 while(i<array.length)
		 {
			 System.out.println("at "+array[i]);
			 if(!map.get(array[i]))
			 {
				 
				 map.put(array[i],true);
			int count=1;
			int leftVal=0;
			int rightVal=0;
			
			 leftVal=array[i]-1;
			 rightVal=array[i]+1;
			 
			while( map.containsKey(leftVal))
			{
				System.out.println("left "+leftVal);
				map.put(leftVal,true);
				count++;
				leftVal--;		
			}
			while( map.containsKey(rightVal))
			{
				System.out.println("right "+rightVal);
				map.put(rightVal,true);
				
				count++;
				rightVal++;	
			}
			System.out.println("left Val "+leftVal+" rightVal "+rightVal);
			
			System.out.println("count "+count);
			if(count>=largest)
			{
				largest=count;
				start=leftVal+1;
				end=rightVal-1;
			}
			 }
			 System.out.println("-------------");
			 i++;
		 }
		 System.out.println("largest "+largest);
		 System.out.println(start+" ,"+end);
		 return null;
		 
	 }
	 public static int[] largestRange(int[] array) {
		    // Write your code here
				Set<Integer>set=new HashSet<>();
				int min=Integer.MAX_VALUE;
				int max=Integer.MIN_VALUE;
				
				for(int i:array)
				{
					set.add(i);
					min=Math.min(min,i);
					max=Math.max(max,i);
				}
				System.out.println("max "+max);
				System.out.println("min "+min);
				int start=0;
				int end=0;
				int largest=0;
				int count=0;
				int i=min;
				while(i<=max)
				{
					System.out.println("at "+i);
					if(set.contains(i))
					{
					i++;
					count++;
					System.out.println("count "+count);
					}
					else
					{
					if(count>=largest)
					{
						System.out.println("at "+i);
						largest=count;
						end=i-1;
						start=end-largest+1;
					}
						count=0;
						i++;
					}
				}
				// when largest ranges finishes at end
				if(count>=largest)
				{
					System.out.println("at "+i);
					largest=count;
					end=i-1;
					start=end-largest+1;
				}
				
				System.out.println("start "+start+" end "+end);
		    return new int[] {start,end};
		  }
}
