package dynamcProgramming;

public class _221_MaximalSquare {
	
	public static void main(String[] args) {
		
		
	}
	 public int maximalSquare(char[][] matrix) {
	        
	        if(matrix.length==1)
	            for(int i=0;i<matrix[0].length;i++)
	                if(matrix[0][i]=='1')
	                    return 1;
	        
	        if(matrix[0].length==1)
	             for(int i=0;i<matrix.length;i++)
	                if(matrix[i][0]=='1')
	                    return 1;
	           
	        int n=matrix.length;
	        int m=matrix[0].length;
	            
	            
	            int small=n<m?n:m;
	        int max=0;
	        for(int i=1;i<=small;i++)
	        {
	            if(iterateMatrix(matrix,i))
	            {
	               // System.out.println("n "+i);
	                max=i;
	            }
	           // System.out.println("----------------");
	        }
	        return max*max;
	    }
	    public boolean iterateMatrix(char [][]matrix,int n)
	    {
	        for(int i=0;i<matrix.length;i++)
	        {
	            for(int k=0;k<matrix[0].length;k++)
	            {
	             if(search(matrix,i,k,n))
	             {
	                 //System.out.println("found at i"+i+" k "+k);
	                 return true;
	             }
	               // System.out.println("__________");
	            }
	        }
	        return false;
	    }
	    
	    public boolean search(char matrix[][],int a,int b,int n)
	    {
	        int count=0;
	      // System.out.println("a "+a+" b "+b+" n "+n+" v "+(a+n));
	         for(int i=a;(a+n-1)<matrix.length &&i<a+n;i++)
	        {
	            for(int k=b;(b+n-1)<matrix[i].length && k<b+n;k++)
	            {
	               // System.out.println("("+i+","+k+")");
	               if(matrix[i][k]=='0')
	                   return false;
	                if(matrix[i][k]=='1')
	                    count++;
	            }
	        }
	        return n*n==count;
	        
	    }

}
