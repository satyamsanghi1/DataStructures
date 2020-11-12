package algoExpert.LeetCodeVersion;

public class _11_ContainerWithMostWater {
	
	public static void main(String[] args) {
		
		int height[]= {1,8,6,2,5,4,8,3,7};
		
		maxArea(height);
	}
	public static int maxArea(int[] height) {

		int maxWater=0;
		int leftIdx=0;
		int rightIdx=height.length-1;
		
		while(leftIdx<rightIdx)
		{
			if(height[leftIdx]<height[rightIdx]) 
			{
				int currentContainer=height[leftIdx]*((rightIdx-leftIdx));
				maxWater=Math.max(currentContainer,maxWater);
				leftIdx++;
				System.out.println("current "+currentContainer);
			}
			else
			{
				int currentContainer=height[rightIdx]*((rightIdx-leftIdx));
				maxWater=Math.max(currentContainer,maxWater);
				rightIdx--;
				System.out.println("current "+currentContainer);
			}
			System.out.println("--------------------");
			
		}
		
		
		System.out.println("maxWater "+maxWater);
		return maxWater;
	}

}
