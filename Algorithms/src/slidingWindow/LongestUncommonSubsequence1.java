package slidingWindow;

public class LongestUncommonSubsequence1 {

	public static void main(String[] args) {
		
		//incomplete
		String a="abaqpoiu";
		String b="cdcquiop";
		
		findLUSlength(a, b);
	}
	
	 public static int findLUSlength(String a, String b) {
	        
		 int max=0;
		 int windowStart=0;
		 int current=0;
		 char q[]=a.toCharArray();
		 char w[]=b.toCharArray();
		 
		 for(int windowEnd=0;windowEnd<a.length();windowEnd++)
		 {
			 if(q[windowEnd]!=w[windowEnd])
			 {
				 System.out.println("here");
				 current++;
				// max=Math.max(max,windowStart-windowEnd);
				 //windowStart=windowEnd;
			 }
			 else
			 {
				 System.out.println("different ");
				 current=0;
			 }
			 max=Math.max(current,max);
		 }
		 System.out.println("max "+max);
		 return 0;
	    }
}
