package algoExpert;

public class LogestPeak {

	//LEETCODE 845 LONGEST MOUNTAIN IN ARRAY
	public static void main(String[] args) {
		
		int array[]= {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
		
		longestPeakAlter2(array);
	}
	
			public static int longestPeakAlter2(int[] array)
			{
				//best solution 
			int longest=0;
			
			int i=1;
			
			while(i<array.length-1)
			{
				System.out.println("current "+array[i]);
				/*
				 * STep1 : finding the tip  that is left and right element of it 
				 * should be strictly deacreasing  thats where is the middle of the peak 
				 */
				boolean isPeak=array[i-1]<array[i] && array[i]>array[i+1];
				if(!isPeak)
				{
					i++;
					continue;
				}
				System.out.println("tip "+i);
				//-2 beacouse -1 is alreaady check above 
				int left=i-2;
				int right=i+2;
				while(left>=0 && array[left]<array[left+1])
				{
					left--;
					System.out.println("left ");
				}
				while(right<array.length && array[right]<array[right-1])
				{
					right++;
					System.out.println("right ");
				}
				System.out.println("left "+left+"right "+right);
				longest=Math.max(longest,(right-left-1));
				System.out.println("longest "+longest);
				
				//last right element is next tip 
				//no need to again traverse beacause before right it must be stricky decreasing
				i=right;
				
				
				
			}
			System.out.println("longest "+longest);
			return longest;
	}
	
	public static int longestPeakAlter(int[] array) {
		
		int longest=0;
		for(int i=1;i<array.length-1;i++)
		{
			
			/*
			 * STep1 : finding the tip  that is left and right element of it 
			 * should be strictly deacreasing  thats where is the middle of the peak 
			 */
			System.out.println("current "+array[i]);
			if(array[i-1]<array[i]&& array[i]>array[i+1])
			{		
				/*
				 * When found tip , trying to expand outwards 
				 */
				System.out.println("tip at index "+i);
				int left=i-1;
				int right=i+1;
				int leftDist=0;
				int rightDist=0;
				
				//calculating left distance
				while(left>=0 && array[left]<array[left+1])
				{
					
					leftDist=Math.abs(i-left);
					System.out.println("left " +array[left]);
					left--;
					
				}
				System.out.println("left dist "+leftDist );
				//calculating right distance 
				while(right<array.length && array[right-1]>array[right])
				{    
					rightDist=Math.abs(right-i);
					System.out.println("right " +array[right]);
					right++;
					
			
				}
				
				System.out.println("right Dist "+rightDist);
				// calculating longest of rightDist+ leftDist and the tip element(+1)
				longest=Math.max(longest,(leftDist+rightDist+1));
				
				}
				
				System.out.println();
			
			
		}
		System.out.println("longest "+longest);
		System.out.println();
		return longest;
	}
	public static int longestPeak(int[] array) {
	    
		// my solution 
		int start=0;
		int longest=0;
		boolean dec=false;
		boolean inc=false;
		for(int i=0;i<array.length-1;i++)
		{
			System.out.println();
		System.out.println("current i "+i);
			
			if(array[i+1]>array[i] && dec==true)
			{
				System.out.println("here");
				start=i;
				dec=false;
				inc=false;
			}
			if(array[i+1]>array[i] && dec==false)
			{	
				System.out.println("updating inc");
				inc=true;
				continue;
			}
			if(array[i+1]==array[i])
			{
				System.out.println("equal at "+i);
				dec=false;
				inc=false;
				start=i+1;
				
			}
			if(array[i+1]<array[i] && inc==true)
			{
				
				longest=Math.max(i-start+2,longest);
				System.out.println("updating longest "+longest);
				dec=true;
			}
			if(array[i+1]<array[i] && inc==false)
				start=i+1;
			
			System.out.println("start "+start);
			System.out.println();
			
				
		}
		System.out.println("longest "+longest);
	    return -1;
	  }
}
