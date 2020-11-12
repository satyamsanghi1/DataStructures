package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0119_PascalTriangleII {
	
	public static void main(String[] args) {
		
		int k=3;
		System.out.println("answer "+getRow(3));
	}
	public static List<Integer> getRow(int rowIndex) {

		//ArrayList<ArrayList<Integer>>list1=new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer>list1=new ArrayList<Integer>();

		list1.add(1);

		for(int i=0;i<rowIndex;i++)
		{
			
			ArrayList<Integer>list2=new ArrayList<Integer>();
			for(int k=0;k<list2.size();k++)
				
				list2.remove(k);
			list2.add(1);

			for(int j=0;j<list1.size()-1;j++)
			{
				list2.add(list1.get(j)+list1.get(j+1));
				System.out.println("called");
			}
			list2.add(1);
			System.out.println("list 2"+list2);
			list1=list2;
		}
		return list1;
	}

}
