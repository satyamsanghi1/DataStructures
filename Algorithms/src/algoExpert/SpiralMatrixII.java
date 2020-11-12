package algoExpert;

public class SpiralMatrixII {
	
	public static void main(String[] args) {
		
		int n=3;
		generateMatrix(n);
	}
	 public static int[][] generateMatrix(int n) {
	        
	        int matrix[][]=new int[n][n];
	        
	        int inc=1;
	        
	        int firstRow=0;
	        int lastRow=matrix.length-1;
	        
	        int firstColumn=0;
	        int lastColumn=matrix[0].length-1;
	        
	        while(firstRow<=lastRow && firstColumn<=lastColumn)
	        {
	            //firstRow
	        	System.out.println("first Row");
	            for(int i=firstColumn;i<=lastColumn;i++)
	            {
	                matrix[firstRow][i]=inc;
	                //System.out.print(matrix[firstRow][i]+" ");
	               // System.out.println("i "+i+"firstRow "+firstRow);
	                
	                inc++;
	            }
	            traverseMatrix(matrix);
	            //lastColumn
	            System.out.println();
	            System.out.println("last Column");
	            for(int i=firstRow+1;i<=lastRow;i++)
	            {
	                matrix[i][lastColumn]=inc;
	                //System.out.print( matrix[i][lastColumn]+" ");
	                //System.out.println("i "+i+"lastColumn "+lastColumn);
	                inc++;
	            }
	           
	            traverseMatrix(matrix);
	            System.out.println();
	            //lastRow
	            if(firstRow==lastRow)
	                break;
	            System.out.println("lastRow");
	            for(int i=lastColumn-1;i>=firstColumn;i--)
	            {
	            	System.out.println("in");
	                matrix[lastRow][i]=inc;
	                inc++;
	            }
	            traverseMatrix(matrix);
	            //firstColumn
	            System.out.println("firstColumn");
	            if(lastColumn==firstColumn)
	                break;
	            for(int i=lastRow-1;i>=firstRow+1;i--)
	            {
	            	System.out.println("here");
	                matrix[i][firstColumn]=inc;
	                inc++;
	            }
	            traverseMatrix(matrix);
	            firstRow++;
	            lastRow--;
	            firstColumn++;
	            lastColumn--;
	           System.out.println();
	        }
	        System.out.println();
	        System.out.println("next ");
	        System.out.println();
	       // traverseMatrix(matrix);
	        return matrix;
	    }
	 public static void traverseMatrix(int m[][])
	 {
		//System.out.println();
		 for(int i=0;i<m.length;i++)
		 {
			 for(int k=0;k<m[i].length;k++)
			 {
				 System.out.print(m[i][k]+" ");
			 }
			 System.out.println();
		 }
	 }

}
