package interview;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation1 {
	//permutation
	
	public static void main(String[] args) {
		
		
//		int []arr=new int [] {55,56,65,505,1006};
//		
//		//finding the largest by making combinations 
//		
//		Arrays.sort(arr);
//		
//		for(int i:arr)
//		{
//			System.out.print(i+" ");
//		}
//	\
		 int []arr=new int []{1,2,3};
		 ArrayList<Integer>list=new ArrayList<>(Arrays.asList(1,2,3));
		 ArrayList<Integer>rem=new ArrayList<>();
		 helper1(list,rem);
		
		
		
		
	}
	public static void helper1(ArrayList<Integer>list,ArrayList<Integer>perm)
    {
       
      if(list.size()==0) {
    	//	return;
        
        System.out.println(list.toString());
        System.out.println("perm "+perm.toString());
        System.out.println("----------");
      }
        for(int j=0;j<list.size();j++)
        {
        ArrayList<Integer>l=new ArrayList<>(list);
       int val= l.remove(j);
        perm.add(val);
        helper1(l,perm);
        perm.remove(perm.size()-1);
        
        }
    
    }
	
	

    
    public static void swap(ArrayList<Integer>list,int i,int j)
    {
        int temp=list.get(i);
       list.set(i,list.get(j));
       list.set(j,temp);
    }
    
    
    public static void traverse(ArrayList<Integer>arr)
    {
        for(int i:arr)
        {
            System.out.print(i+ " ");
        }
        System.out.println();
    }

	
	
	
	

}
