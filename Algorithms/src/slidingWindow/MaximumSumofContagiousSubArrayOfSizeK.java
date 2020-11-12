package slidingWindow;

public class MaximumSumofContagiousSubArrayOfSizeK {

	public static void main(String[] args) {
		
		int arr[]= {4,2,1,7,8,1,2,8,1,0};
		
		System.out.println("max "+maxSum(arr,3));
	}
	
	public static int maxSum(int arr[],int k)
	{
		int currentRunningSum=0;
		int maxSoFar=Integer.MIN_VALUE;
		
		for(int i=0;i<k;i++) {
			
			currentRunningSum+=arr[i];
			
		}
		maxSoFar=Math.max(currentRunningSum,maxSoFar);
		System.out.println(currentRunningSum );
		
		for(int i=k;i<arr.length;i++) {
			
			currentRunningSum+=arr[i]-arr[i-(k)];
		
			System.out.println(currentRunningSum );
			maxSoFar=Math.max(currentRunningSum,maxSoFar);
		}
		return maxSoFar;
	}
	
	

}
