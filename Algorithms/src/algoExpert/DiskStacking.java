package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiskStacking {

	public static void main(String[] args) {
		
		List<Integer[]>disks=new ArrayList<>();
		disks.add(new Integer[] {2,1,2});
		disks.add(new Integer[] {3,2,3});
		disks.add(new Integer[] {2,2,8});
		disks.add(new Integer[] {2,3,4});
		disks.add(new Integer[] {1,3,1});
		disks.add(new Integer[] {4,4,5});

		diskStacking(disks);
		
	}
	  public static List<Integer[]> diskStacking(List<Integer[]> disks) {
		  
		  disks.sort((Integer[]a ,Integer []b )->{
			  
			  return a[2].compareTo(b[2]);
		  });
		  traverseDisks(disks);
		  
		  int heights[]=new int[disks.size()];
		  int maxHeight=0;
		  int sequence[]=new int [heights.length];
		  for(int i=0;i<heights.length;i++)
		  {
			  sequence[i]=-1;
		  }
		  heights[0]=disks.get(0)[2];	//base case
		  
		  for(int i=1;i<heights.length;i++)
		  {
			 int h=0;
			 heights[i]=disks.get(i)[2];
			  System.out.println("at "+i);
			  for(int j=0;j<i;j++)
			  {
				  if(disks.get(j)[0]<disks.get(i)[0] && disks.get(j)[1]<disks.get(i)[1]&& disks.get(j)[2]<disks.get(i)[2])
				  {
					  System.out.println("here "+heights[j]);
					  h=heights[j];
					
					   
					   if((h+disks.get(i)[2])>heights[i])
					   {
						   heights[i]=(h+disks.get(i)[2]);
						   sequence[i]=j;
						   
					   }
					   
				  }
				  maxHeight=heights[i]>heights[maxHeight]?i:maxHeight;
			  }
			
			  traverse(heights);
			  traverse(sequence);
			  System.out.println("-------------------");
		  }
		  
		  System.out.println("max Height "+maxHeight);
		  traverse(heights);
		  
		List<Integer[]>ans= generate(heights, disks,sequence,maxHeight);
		  System.out.println("ans");
		traverseDisks(ans);
		    return new ArrayList<Integer[]>();
		  }
	  
	  public static List<Integer[]>  generate(int []heights,List<Integer[]>disks,int []sequence,int maxHeight)
	  {
		  List<Integer[]>stack=new ArrayList<>();
		  
		  int i=maxHeight;
		  
		  while(i>=0)
		  {
			 
				  stack.add(disks.get(i));
				  i=sequence[i];
			
		  }
		  
		  return stack;
	  }
	  
	  public static void traverse(int a[])
	  {
		  System.out.println();
		  for(int i:a)
			  System.out.print(i+" ");
		  System.out.println();
	  }
	  public static void traverseDisks(List<Integer[]>disks)
	  {
		  for(Integer[]a:disks)
			{
				System.out.println(a[0]+","+a[1]+","+a[2]);
			}
	  }
}
