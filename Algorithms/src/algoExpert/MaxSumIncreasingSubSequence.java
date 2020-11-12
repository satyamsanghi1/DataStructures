package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSumIncreasingSubSequence {
	//variant
	//leetcode 300 : Longest Icreasing subsequence
	public static void main(String[] args) {
		
		int array[]= {8,12,2,3,15,5,7};
		
		System.out.println(maxSumIncreasingSubsequence(array));
	}
	 public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
		List<List<Integer>>ans=new ArrayList<>();
		 /*
		  * Step 1 : create array of same size of input array 
		  * ->start iterating input array
		  * store the max increasing subsequence sum till each array 
		  */
		 int sum[]=new int[array.length];
		 int maxIndex=0;// to keep track of max index
		 
		 int []sequence=new int[array.length]; // to create a type of linked list
		 Arrays.fill(sequence,Integer.MIN_VALUE);
		 for(int i=0;i<array.length;i++)
		 {
			 //initially store the index value , beacuse min sum will be the index element
			 //and when starting index like when i=0;
			 sum[i]=array[i];
			 //to find max sum till i , we have to iterate from starting in array 
			 //which element is less than array[i]
			 for(int j=0;j<i;j++)
			 {
				 // if element is less than element at i 
				 // following strictly increasing rule
				 if(array[j]<array[i])
				 {
					 /*
					  * checking if sum of array[j] +array[i] is greater than
					  * previous longest increasing sum at i
					  */
					 int a=sum[j]+array[i];
					 
					 if(sum[i]<a)
					 {
						
						 sum[i]=a;
						/*
						 * we are storing the previous index of longest increasnig subsequence 
						 * till here . 
						 */
						 sequence[i]=j;
					 }
					 /*
					  * Illustration of sequence Array creation 
					  * 
					  * for 8: the 2nd for loop will not execute 
					  * for 12 : we find 8+12 greater than 12 :
					  * 		we update 20 at sum[1] and sequence[1]=0;because 8 is at 0
					  * 		prev value of increasing subsequence till 12 is at array[0]
					  * 
					  * for 2 : no values less than 2 so it remains sum[2]=2;sequence[2]=null
					  * 		because there is no preivous value in 2;
					  * 
					  * for 3 : when at 2 : 2+3 > 3 : hence update at sum[3]=5
					  * 		sequence [3]=2; because 2 is at index 2
					  * 
					  * for15 : a)8+15 >15 update sum[4]=23; sequence[3]=0 , since 8 is at 0
					  *	increasing j b)at 12 : 20+15>23 update sum[4]=15+sum[1] =35, 1 is j
					  *				sequence[4]=1;
					  *		c)at 2 : 2+15 < 35 , not update 
					  *		d)at 3 : 3<15 :sum at 3 : 5 +15<35 , no update
					  *
					  *for 5 : a) skipping 8,12 as <5 
					  *			b) element 2 < 5 : 5+2>5 , updating sum[5]=7, sequence[5]=2
					  *			c)5+5>7 : update , sum[5]=10, sequence[5]=3
					  *
					  *for 7: a) skipping 8,12 
					  *			b)at 2 : 2+7>7 sum[6]=9,sequence[6]=2
					  *			c)at 3 : 5+7>9, sum[6]=12,sequence[6]=3
					  *			d)skipping 15 , at 5 , : 10+7>12 ,sum[6]=17;,seuqnece[6]=5
					  * 		
					  * 		
					  * 			
					  */
					 
				 }
				 if(sum[i]>sum[maxIndex])
				 {
					 maxIndex=i;
				 }
			 }
		 }
		 List<Integer>seq=null;
		seq= generateSubSequence(sequence,array,maxIndex);
		 System.out.println("max "+sum[maxIndex]);
		 traverse(sum);
		 traverse(sequence);
		 System.out.println(seq);

		 ans.add(Arrays.asList(sum[maxIndex]));
		 ans.add(seq);
		return ans;
	 }
	 public static List<Integer> generateSubSequence(int[]sequence,int []array,int currentIndex)
	 {
		 /*
		  * Example : our maxIndex=4a and sequence array
		  * with help of max index we will genrate subsequence having greatest sum
		  * 
		  * sequence : null,0,null,2,1,3,5
		  */
		 
		 List<Integer>seq=new ArrayList<>();
		 
		 while(currentIndex>=0)
		 {
			 System.out.println("current "+currentIndex);
			 seq.add(array[currentIndex]);
			 
			 currentIndex=sequence[currentIndex];
		
		 }
		 /*
		  * at index 4 adding array[4]=15
		  * now sequence[4]=1;
		  * at 1 adding array[1] =12, sequene[1]=0;
		  * aat index 0 , adding array[0] =8
		  * break
		  * 
		  *we are able to find the the longest subsequence using ssubsequence array
		  */
		 Collections.reverse(seq);
		 return seq;
	 }
	 public static void traverse(int []nums)
	 {
		 System.out.println();
		 for(int l:nums)
			 System.out.print(l+" ");
		 System.out.println();
	 }

}
