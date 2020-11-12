package algoExpert;

import java.util.ArrayList;
import java.util.List;

public class SprialTraverse {
	
	public static void main(String[] args) {
		
		int matrix[][]= {
		                 {1,  2,  3},
		                 {12, 13, 4},
		                 {11, 14, 5},
		                 {10, 15, 6},
		                 {9,  8,  7}
						};
		 
		spiralOrder(matrix);
	}
	
	 public static List<Integer> spiralOrder(int[][] matrix) 
	 {
	        List<Integer>list=new ArrayList<Integer>();
	        
	        int firstRow=0;
	        int lastColumn=matrix[0].length-1;
	        int lastRow=matrix.length-1;
	        int firstColumn=0;
	        
	        //printing first row 
	       
	        while(firstRow<=lastRow && firstColumn<=lastColumn)
	        {
	        	
	        	 System.out.println("printing first Row");
	        	// if(firstColumn!=lastColumn)
	        for(int i=firstColumn;i<=lastColumn;i++)
	        {
	        	System.out.print(matrix[firstRow][i]+" ");
	        	list.add(matrix[firstRow][i]);
	        }
	        System.out.println();
	      
	        System.out.println("printing last column");
	        
	        for(int i=firstRow+1;i<=lastRow;i++)
	        {
	        	System.out.print(matrix[i][lastColumn]+" ");
	        	list.add(matrix[i][lastColumn]);
	        }
	      //  lastColumn--;
	        System.out.println();
	        System.out.println("printing last row");
	     //  if(firstRow==lastRow)
	    //	   break;
	        for(int i=lastColumn-1;i>=firstColumn;i--)
	        {
	        	System.out.print(matrix[lastRow][i]+" ");
	        	list.add(matrix[lastRow][i]);
	        }
	       // lastRow--;
	       
	        System.out.println();
	        System.out.println("printing first column ");
	        
	     //   if(firstColumn==lastColumn)
	      //  	break;
	        for(int i=lastRow-1;i>firstRow;i--)
	        {
	        	System.out.print(matrix[i][firstColumn]+" ");
	        	list.add(matrix[i][firstColumn]);
	        }
	        //firstColumn++;
	        System.out.println();
	      
	        
	        firstRow++;
	        lastColumn--;
	        lastRow--;
	        firstColumn++;
	        System.out.println("firstColumn "+firstColumn);
	        System.out.println("firstRow    "+firstRow);
	        System.out.println("last column "+lastColumn);
	        System.out.println("last row    "+lastRow);
	        System.out.println();
	        System.out.println();
	        }
	        
	      System.out.println();  
	        System.out.println("ans "+list);
	        
	        return list;
	  }

}
