package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalTriangle {
	
	public static void main(String[] args) {
		
		int n=6;
		
		int rows[][]=new int [n][];
		
		List<List<Integer>>list=new ArrayList<>();
		
	
		ArrayList<Integer> arr=new ArrayList<>();
		arr.add(1);
		list.add(arr);
		
		arr=new ArrayList<Integer>();
		arr.add(1);
		arr.add(1);
		list.add(arr);
		
		System.out.println("  "+list.get(0));
		System.out.println(" "+list.get(1));
		for(int i=2;i<n;i++)
		{
			ArrayList<Integer> ar=new ArrayList<>();
		
			list.add(i,ar);
			list.get(i).add(1);
			
			for(int j=0;j<=list.get(i-1).size()-2;j++)
			{
				//list.get(j).add(1);
				ArrayList<Integer> q=new ArrayList<>();
				int c=list.get(i-1).get(j);
				int v=list.get(i-1).get(j+1);
				System.out.println("c "+c +" v "+v);
				int sum=c+v;
			list.get(i).add(sum);	
			
			System.out.println("ad"+ list.get(i-1).get(j));
		
			}
			list.get(i).add(1);
			
			//traversing after creating each row
			System.out.println("traversing the "+(i+1) +" row of size "+list.get(i).size());
			
			for(int j=0;j<list.get(i).size();j++)
			{
				//list.get(j).add(1);
			System.out.print(list.get(i).get(j)+" ,");
		
			}System.out.println();
			System.out.println("sublist size "+list.get(i).size());
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("list size "+list.size());
		System.out.println("sublist "+list.get(0).size());
		System.out.println();
		
		System.out.println("PASCAL TRIANGLE");
		
		for(int i=0;i<n;i++)
		{
			for(int k=n-i;k>=0;k--)
				System.out.print(" ");
			System.out.print(list.get(i));
		
			System.out.println();
		}
		
		
	}

}
