package dynamcProgramming;

public class _673_NumberOfLongestIncreasingSubSequence {
	//leetcode 674 Longest Continous Increasing Subsequence
	
	public static void main(String[] args) {
		
		int nums[]= {1,2,4,3,5};
		
		int a=findNumberOfLIS(nums);
		System.out.println("ans "+a);
	}
	  public static int findNumberOfLIS(int[] nums) {

	         int values[]=new int[nums.length];
	        int count[]=new int[nums.length];
			 int max=0;
			int maxCount=0;
			 
			 
	        int min=Integer.MAX_VALUE;
			 for(int i=0;i<nums.length;i++)
			 {	
				 System.out.println("at "+nums[i]);
				 //by default the current value at each index should be 1 
				 
				 count[i]=1;//base case
				 values[i]=1;//base case
				 for(int j=0;j<i;j++)
				 {	
					System.out.println("current "+nums[j]);
					 if(nums[j]<nums[i] )
					 {
						//when there are two subsequence of same length 
						 if(values[i]==values[j]+1)
						 {
							 System.out.println("here");
							 count[i]+=count[j];
						 }
						 //when we have a new subsequence of new length
						 if(values[i]<values[j]+1)
						 {
							 System.out.println("in");
							 values[i]=values[j]+1;
							 count[i]=count[j];
						 }
						
						
						 
						 
					 }

				 }
				 traverse(count);
				 traverse(values);
				
				 //if new max found then update both maxCount
				 if(values[i]>max)
				 {
					 System.out.println("a");
					 max=values[i];
					 maxCount=count[i];
				 }
				 //if occurs same length add that count[i] in maxCount 
				 else if(values[i]==max)
				 {
					 System.out.println("b");
					 
					 maxCount+=count[i];
				 }
				 System.out.println("max "+max+" count "+maxCount);
				 System.out.println("----------------------------");
			
			 }
		
			 System.out.println("maxIndex "+max);
			 System.out.println();
			 	
			return maxCount;
	  }
	  public static void traverse(int []nums)
		 {
			 System.out.println();
			 for(int l:nums)
				 System.out.print(l+" ");
			 System.out.println();
		 }

}
