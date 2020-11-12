package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class FourNumberSum {
	//leetcode version 18 with duplicates
	public static void main(String[] args) {
		
		//int array[]= {7,6,4,-1,1,2};
		int array[]=  {-2,-1,-1,1,1,2,2};
		//int array[]=  {-2,-1,0,0,1,2};
		fourNumberSumDuplicate(array,0);
		//System.out.println(fourNumberSum(array,16).toString());
	}
 public static List<Integer[]> fourNumberSumDuplicate(int[] array, int targetSum) {
		 Arrays.sort(array);
		 //this algorithm not working for duplicates
		 HashMap<Integer,List<List<Integer>>>map=new HashMap<>();
		
		 List<List<Integer>>ans=new ArrayList<>();
		
			  
		  for(int i=0;i<array.length;i++)
		  {
			//  if(i+1<array.length && array[i+1]==array[i])
				//  continue;
			  System.out.println("at "+array[i]+" i "+i);
			  //System.out.println("map "+map.values());
			  map.forEach((k,v)->{
				  System.out.println("k "+k+" v " +v);
			  });
			
			 for(int j=i+1;j<array.length;j++)
			 {
				if(j>i+1 && array[j-1]==array[j])
				{
					System.out.println("skipped");
					continue;
				}
				 int sum=array[i]+array[j];
				 int diff=targetSum-sum;
			//	 System.out.println("diff "+diff);
				 if(map.containsKey(diff))
				 {
					
					 List<List<Integer>>l=map.get(diff);
					 System.out.println("found j "+j);
					 for(List<Integer>a:l)
					 {
						 System.out.println("pair "+a);
						 List<Integer>la=new ArrayList<>();
						 la.add(a.get(0));
						 la.add(a.get(1));
						 la.add(array[i]);
						 la.add(array[j]);
						// ans.add(new Integer[] {a.get(0),a.get(1),array[i],array[j]});
						 ans.add(la);
						 System.out.println("ans "+ans);
					 }
				 }
			 }
			
			 for(int k=0;k<i;k++)
			 {
				 if(k-1>=0 && array[k-1]==array[k])
					 continue;
				 int sum=array[k]+array[i];
				 if(map.containsKey(sum))
				 {
					 List<List<Integer>>l=map.get(sum);
					List<Integer>check=l.get(0);
					if((check.get(0)==array[k]&& check.get(1)==array[i])||
							(check.get(1)==array[k]&& check.get(0)==array[i]))
					{
						continue;
					}
					// l.add(new Integer[] {array[k],array[i]});
					 List<Integer>la=new ArrayList<>();
					 la.add(array[k]);
					 la.add(array[i]);
					 l.add(la);
					 map.put(sum,l);
				 }
				 else
				 {
					 //List<Integer[]>l=new ArrayList();
					 List<Integer>la=new ArrayList<>();
					 List<List<Integer>>lb=new ArrayList<>();
					 la.add(array[k]);
					 la.add(array[i]);
					 lb.add(la);
					// l.add(new Integer[] {array[i],array[k]});
					 map.put(sum,lb);
				 }
			 }
			// traverseMap(map);
			 System.out.println("_______________________________");
		  }
		 
		/*for(Integer a[]:ans)
		{
			System.out.println();
			for(int i:a)
				System.out.print(i+",");
			System.out.println("----------------");
			
		}*/
		  
		 System.out.println("final ans "+ans);
		 return null;
	 }
	 public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
		 //without duplicates
		 HashMap<Integer,List<Integer[]>>map=new HashMap<>();
		
		 List<Integer[]>ans=new ArrayList<>();
		 
			  
		  for(int i=0;i<array.length;i++)
		  {
			 for(int j=i+1;j<array.length;j++)
			 {
				 int sum=array[i]+array[j];
				 int diff=targetSum-sum;
				 
				 if(map.containsKey(diff))
				 {
					 List<Integer[]>l=map.get(diff);
					
					 for(Integer[]a:l)
					 {
						 ans.add(new Integer[] {a[0],a[1],array[i],array[j]});
					 }
				 }
			 }
			 for(int k=0;k<i;k++)
			 {
				 int sum=array[k]+array[i];
				 if(map.containsKey(sum))
				 {
					 List<Integer[]>l=map.get(sum);
					 l.add(new Integer[] {array[k],array[i]});
					 map.put(sum,l);
				 }
				 else
				 {
					 List<Integer[]>l=new ArrayList();
					 l.add(new Integer[] {array[i],array[k]});
					 map.put(sum,l);
				 }
			 }
		  }
		 
		for(Integer a[]:ans)
		{
			System.out.println();
			for(int i:a)
				System.out.print(i+" , ");
			System.out.println("----------------");
			
		}
		  
		 
		 return null;
	 }
	  public static List<Integer[]> fourNumberSum1(int[] array, int targetSum) {
		    //naive
		  List<List<Integer>>ans=new ArrayList<>();
		 
		  
		  for(int i=0;i<array.length;i++)
		  {
			  for(int j=i+1;j<array.length;j++)
			  {
				  for(int k=j+1;k<array.length;k++)
				  {
					  for(int l=k+1;l<array.length;l++)
					  {
						  int sum=(array[i]+array[j]+array[k]);
						
						  if(sum==targetSum)
						  {
							  System.out.println("found");
							  System.out.println(array[i]+" , "+array[j]+" , "+array[k]+" , "+array[l]);
							  
						  }
					  }
				  }
			  }
		  }
		    return null;
		  }
	  
	  public static void traverseMap(HashMap<Integer,List<Integer[]>>map)
	  {
		  for(Entry<Integer,List<Integer[]>>e:map.entrySet())
		  {
			  int sum=e.getKey();
			  List<Integer[]>l=e.getValue();
			  System.out.println("sum "+sum);
			  for(Integer[]a:l)
			  {
				  System.out.println(a[0]+", "+a[1]);
			  }
			  System.out.println("-----------------");
		  }
	  }

}
