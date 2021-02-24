package interview;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutation3 {
	static int largest=Integer.MIN_VALUE;
	static int ans=0;
	public static void main(String[] args) {
		
		
		 int []arr=new int []{1,2,3,4};
		 ArrayList<Integer>list=new ArrayList<>(Arrays.asList(0,4,2,3,5,1));
		 ArrayList<Integer>rem=new ArrayList<>();
		 
		
		helper1(list,0,0);
		 System.out.println("ans "+largest);
		
		 System.out.println("final ans "+ans);
		 
		// System.out.println("largest "+largest);
	}
	
	public static void helper1(ArrayList<Integer>list,int i,int count)
    {
       
		if(i==list.size()) {
		System.out.println("list "+	list.toString());
//	
//		int val=calculateDiff(list);
//		if(val==17)
//			System.out.println("count "+count);
//		if(val>=largest)
//		{
//			largest=val;
//			ans=count+val;
//		}
		}
       
        System.out.println("----------");
        for(int j=i;j<list.size();j++)
        {
        	swap(list,i,j);
           helper1(list,i+1,count+1);
           swap(list,i,j);
        }
      
    }
	
	public static int calculateDiff(ArrayList<Integer>list)
	{
		int diff=0;
		
		for(int i=1;i<list.size();i++)
		{
			diff+=Math.abs(list.get(i-1)-list.get(i));
		}
		return diff;
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


