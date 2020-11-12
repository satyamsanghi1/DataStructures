package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagTraverse {
	//leetcode 498 
	public static void main(String[] args) {
		
		List<List<Integer>>array=new ArrayList<>();
		array.add(Arrays.asList(1,3,4,10));
		array.add(Arrays.asList(2,5,9,11));
		array.add(Arrays.asList(6,8,12,15));
		array.add(Arrays.asList(7,13,14,16));
		
		zigzagTraverse(array);
	}
	 public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
		 //algoExpert solution
			int height=array.size()-1;
			int width=array.get(0).size()-1;
			int row=0;
			int column=0;
			boolean down=true;
			List<Integer>ans=new ArrayList<>();
			
			while(isOutOfOrder(row,column,height,width))
			{
				ans.add(array.get(row).get(column));
				if(down)
				{
					if(column==0 || row==height)
					{
						if(row==height)
						{
							column++;
						}
						else if(column==0)
						{
							row++;
						}
						down=false;
					}
					else
					{
						row++;
						column--;
					}
				}
				else
				{
					if(column==width || row==0)
					{
						if(column==width)
						{
							row++;
						}
						else if(row==0)
						{
							column++;

						}
						down=true;
					}
					else
					{
						row--;
						column++;
					}
				}
			}
			System.out.println("ans "+ans);
	    return ans;
	 }
		public static boolean isOutOfOrder(int row,int column,int height,int width)
		{
			if(row<0 || row>height)
				return false ;
			
			if(column < 0 || column >width)
				return false;
			
				return true;
		}
	 public static List<Integer> zigzagTraverse1(List<List<Integer>> array) {
		 //mysolution
		 List<Integer>ans=new ArrayList<>();
		    // Write your code here.
		 int row=array.size();
		 int column=array.get(0).size();
		 int i=1;
		 int j=0;
		 boolean up=true;
		 
		 if(row==1)
			{ans.addAll(array.get(0)); 
		 return ans;
			}
		 while(i!=row && j!=column)
		 {
			 if(up)
			 {
				 // go diagonally up
			while(i>=0 && j<column)
			 {
				ans.add(array.get(i).get(j));
			 System.out.println(array.get(i).get(j));
			i--;
			j++;
			 }
			
				System.out.println("i "+-1);
				i++;
			
			if(j==column)
			{
				j--;
				i++;
			}
			
			up=false;
			
			System.out.println("__________");
			 }
			 else
			 {
				 while(j>=0 && i<row)
				 {
					 System.out.println(array.get(i).get(j));
					 ans.add(array.get(i).get(j));
				 i++;
				 j--;
				 }
				 System.out.println("j "+j);
				 System.out.println("i "+i);
				
				 j++;
				 
				 if(i==row)
				 {
					 j++;
					 i--;
				 }
				 
					 
				System.out.println("here"); 
				 up=true;
			 }
			
			 
			 
			 System.out.println("i "+i+" j "+j);
			 
			 
		
		
			System.out.println("---------------------");
		 }
		 ans.add(0,array.get(0).get(0));
		 System.out.println("ans "+ans);
		   return ans;
		  }

}
