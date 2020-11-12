package algoExpert;

public class WaterArea {
		//LEETCODE 42 : Trapping Rain Water
	public static void main(String[] args) {
		
		int [] heights= {0,8,0,0,5,0,0,10,0,0,1,1,0,3};
		
		waterArea2(heights);
	}
	public static int waterArea2(int[] heights) {
		//leetcode solution contains graphics
		
		/*If left building is smaller , that means  we can calculate left bilding water
		 * as right is bgiger than left ,  we have found right max for left
		 * but not for right answer , as there may exist bigger left values for right
		 */
		int water=0;
		int leftMax=heights[0];
		int rightMax=heights[heights.length-1];
		int leftIdx=0;
		int rightIdx=heights.length-1;
		
		
		while(leftIdx<rightIdx)
		{
			if(heights[leftIdx]<heights[rightIdx])
			{
				//we require left Max only , hence we update left , not right also
				leftMax=Math.max(leftMax,heights[leftIdx]);
			water+=(leftMax-heights[leftIdx]);	
				leftIdx++;
			}
			else
			{
				rightMax=Math.max(rightMax, heights[rightIdx]);
				water+=(rightMax-heights[rightIdx]);	
				rightIdx--;
			}
	
		}
		
		System.out.println("water "+water);
		
		return water;
	}
	public static int waterArea1(int[] heights) {
		//(O)N time , (O)N space
		/*As in our prev sol we are using two arrays for left max  and right max
		 * in this sol we will use only one array to do both the operations
		 */
		int water=0;
		int maxes[]=new int[heights.length];
		int leftMax=0;// left max for first index is 0
		for(int i=0;i<heights.length;i++)
		{
			int height=heights[i];
			//first assigning the left max
			maxes[i]=leftMax;
			//updating leftmax for the next iteration
			leftMax=Math.max(height,leftMax);
		}
		int rightMax=0;
		for(int i=heights.length-1;i>=0;i--)
		{
			int height=heights[i];
			//As at current maxes[i] we have our max left value 
			// also we are calculating maxRight simultaneously 
			// hence we have both the values so we can calculate the max water can be 
			// put in that index
			// min of right and left will be the max value
			maxes[i]=Math.min(rightMax,maxes[i]);
			// after we have max water height we can check if there is pillar 
		/*and if that pillar is less than our max water height then we subtract 
		 * that pillar other wise set maxes[i]=0 because pillar height is greater
		 * than max water can be poured at that index 
		 * 
		 */
			if(height<maxes[i])
			{
				maxes[i]-=height;
			}
			else
			{
				maxes[i]=0;
			}
			//calculating rightMax for the next iteration
			rightMax =Math.max(height,rightMax);
		}
		
		for(int i=0;i<heights.length;i++)
		{
			water+=maxes[i];
		}
		traverse(maxes);
		System.out.println("water "+water);
		return water;
	}
	 public static int waterArea(int[] heights) {
		 
		 int left[]=new int[heights.length];
		 int right[]=new int[heights.length];
	 
		 int n=heights.length-1;
		 for(int i=1;i<heights.length;i++)
		 {
			 // filling leftmax heights
			 if(heights[i-1]>left[i-1])
			 {
				 left[i]=heights[i-1];
			 }
			 else
			 {
				 left[i]=left[i-1];
			 }
			 //filling rightmax heights
			 if(heights[n-i+1]>right[n-i+1])
			 {
				 right[n-i]=heights[n-i+1];
			 }
			 else
			 {
				 right[n-i]=right[n-i+1];
			 }
 
		 }
		 int water=0;
		 for(int i=0;i<heights.length;i++)
		 {
			 int leftHeight=left[i];
			 int rightHeight=right[i];
			 int currentWater=0;
			 if(leftHeight!=0 && rightHeight!=0)
			 {
				 if(heights[i]>leftHeight || heights[i]>rightHeight)
					 continue;
			 if(leftHeight<rightHeight)
			 {
				 currentWater+=(leftHeight); 
			 }
			 else
			 {
				 currentWater+=(rightHeight); 
			 }
			 currentWater-=heights[i];
			 
			 }
			 System.out.println("at "+heights[i]+" ( "+leftHeight+" , "+rightHeight+") water: "+currentWater);
			 water+=currentWater;
		 }
		
		 System.out.println("water "+water);
		 return water;
	 }
	
	 public static void traverse(int []a)
	 {
		 System.out.println();
		 for(int x:a)
			 System.out.print(x+" ");
		 System.out.println();
	 }

}
