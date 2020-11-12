package algoExpert.LeetCodeVersion;

public class _407_TrappingRainWaterII {
	
	
	public static void main(String[] args) {
		
		int [][]heightMap= {
							{12,13,1,12},
							{13,4,13,12},
							{13,8,10,12},
							{12,13,12,12},
							{13,13,13,13}
							};
		
		trapRainWater(heightMap);
	}
	public static int trapRainWater(int[][] heightMap) {
        
		int dp[][][]=new int [heightMap.length][heightMap[0].length][4];
		
		/*Each index in matrix have 4 values 
		 *{leftMax,RightMax,UpMax,DownMax}
		 * 
		 */
		
		int n=heightMap[0].length-1;
		//row
		for(int i=0;i<heightMap.length;i++)
		{//column
			for(int j=1;j<heightMap[0].length;j++)
			{
				int leftMax=dp[i][j-1][0];
				dp[i][j][0]=Math.max(leftMax,heightMap[i][j-1]);
				
				int rightMax=dp[i][n-j+1][1];
				dp[i][n-j][1]=Math.max(rightMax,heightMap[i][n-j+1]);
			}
			//traverse(dp[i],0);
			//traverse(dp[i],1);
		//	System.out.println("--------------");
		}
		//System.out.println("____________________________________");
		int rowSize=heightMap.length-1;
		//colum
		for(int j=0;j<heightMap[0].length;j++)
		{	
			//row
			for(int i=1;i<heightMap.length;i++)
			{
				int upMax=dp[i-1][j][2];
				dp[i][j][2]=Math.max(upMax,heightMap[i-1][j]);
				
				
				int downMax=dp[rowSize-i+1][j][3];
				//System.out.println("val "+(rowSize-i+1));
				dp[rowSize-i][j][3]=Math.max(downMax,heightMap[rowSize-i+1][j]);
				
			}
			System.out.println();
		}
			for(int j=0;j<heightMap[0].length;j++)
			{	
				//row
				for(int i=0;i<heightMap.length;i++)
				{
				//	System.out.println("downMax "+dp[i][j][3]);
				}
				//System.out.println();
			}
			//System.out.println("--------------");
		
		
		//System.out.println("__________________________");
			int water=0;
		for(int i=0;i<heightMap.length;i++)
		{//column
			for(int j=0;j<heightMap[0].length;j++)
			{
				int leftMax=dp[i][j][0];
				int rightMax=dp[i][j][1];
				
				int upMax=dp[i][j][2];
				int downMax=dp[i][j][3];
				
				System.out.println(" "+upMax);
				System.out.println(leftMax+"("+heightMap[i][j]+")"+rightMax);
				System.out.println(" "+downMax);
				System.out.println("----------");
				
				int currentWater=Math.min(leftMax,Math.min(rightMax,Math.min(upMax,downMax)));
				currentWater-=heightMap[i][j];
				if(currentWater>0)
				{
					System.out.println("current water "+currentWater);
					water+=currentWater;
				}
				
			}
			System.out.println("_____________________________");
		}
		System.out.println("water "+water);
		
		
		return 0;
    }
	 public static void traverse(int [][]a,int z)
	 {
		 System.out.println();
		 for(int []x:a)
			 System.out.print(x[z]+" ");
		 System.out.println();
	 }

}
