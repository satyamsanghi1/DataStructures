package slidingWindow;import java.awt.event.WindowStateListener;

public class SmallestSubArrayWithGivenSum {
	
	public static void main(String[] args) {
		
		/// dynamic resizing of window 
		int nums[]= {4,2,2,7,8,1,2,8,1,0};
		
		smallestSubArray(nums,8);
	}
	
	public static int smallestSubArray(int nums[],int sum)
	{
		int currentRunningSum=0;
		int windowStart=0;
		
		int minWindowSize=Integer.MAX_VALUE;
		
		
		
		for(int windowEnd=0;windowEnd<nums.length;windowEnd++)
		{
			currentRunningSum+=nums[windowEnd];
			
			while(currentRunningSum>=sum) {
				//shrinking window size 
				System.out.println("window end "+windowEnd);
				minWindowSize=Math.min(minWindowSize,windowEnd-windowStart+	1);
				currentRunningSum-=nums[windowStart];
				windowStart++;
			}
			System.out.println("current sum "+currentRunningSum);
				
		}
		
		System.out.println("window size "+minWindowSize);
		
		
		return 0;
	}

}
