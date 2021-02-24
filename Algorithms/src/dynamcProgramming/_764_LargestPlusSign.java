package dynamcProgramming;

import java.util.Arrays;

public class _764_LargestPlusSign {
	//high complexity 
	public static void main(String[] args) {
		
		
		int N=5;
		int [][]mines=new int[][]{{4,2}};
			Long start=System.currentTimeMillis();
			
			int ans=orderOfLargestPlusSign(N, mines);
			System.out.println("ans "+ans);
			Long end=System.currentTimeMillis();
			System.out.println("start "+start+ " end "+end);
			System.out.println("time taken "+(end-start));
			
	}
	 public static int orderOfLargestPlusSign(int N, int[][] mines) {
	        
	        int [][]matrix=createMatrix(N,mines);
	        int max=0;
	        for(int i=0;i<matrix.length;i++)
	        {
	            for(int j=0;j<matrix[0].length;j++)
	            {
	                max=Math.max(max,search(matrix,i,j));
	            }
	        }
	        return max;
	    }
	    public  static int search(int [][]mines,int i,int j)
	    {
	        int up=0,down=0,left=0,right=0;
	        int count=0;
	        up=i;down=i;left=j;right=j;
	        while(up>=0 && left>=0 && down<mines.length && right <mines[0].length)
	        {
	            if(mines[up][j]==1 && mines[down][j]==1)
	            {
	                if(mines[i][left]==1 && mines[i][right]==1)
	                {
	                    count++;
	                    up--;
	                    left--;
	                    down++;
	                    right++;
	                    
	                }
	                else
	                    break;
	            }
	            else
	                break;
	        }
	        
	        return count;
	    }
	    public static int [][] createMatrix(int N,int [][]mines)
	    {
	        int [][]matrix=new int[N][N];
	        
	        for(int i=0;i<N;i++)
	        {
	            Arrays.fill(matrix[i],1);
	        }
	        
	        for(int i=0;i<mines.length;i++)
	        {
	            int j=mines[i][0];
	            int k=mines[i][1];
	        
	            matrix[j][k]=0;
	        }
	        return matrix;
	    }

}
