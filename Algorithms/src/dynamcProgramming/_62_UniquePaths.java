package dynamcProgramming;

public class _62_UniquePaths {
	//exponential complexity
	//algoexpert
	//top down approach
	public static void main(String[] args) {
		
	}
	 int count=0;
	    public int uniquePaths(int m, int n) {
	        
	     
	        helper(0,0,m,n);
	        return count;
	    }
	    public void helper(int i,int j,int w,int h)
		{
			if(i==h-1 && j==w-1)
			{
				count++;
				return ;
			}
			if(i>h || j>w)
				return ;
			
			helper(i+1,j,w,h);
			helper(i,j+1,w,h);
		}
}
