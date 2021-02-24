package interview;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation2 {

	public static void main(String[] args) {
		
		
		 int []arr=new int []{1,2,3,4};
		 ArrayList<Integer>list=new ArrayList<>(Arrays.asList(1,2,3));
		 ArrayList<Integer>rem=new ArrayList<>();
		 helper1(list,rem);
	}
	
	public static void helper1(ArrayList<Integer>list,ArrayList<Integer>rem)
    {
        //if(rem.size()==list.size())
        	//System.out.println("rem size "+rem.size());
		if(list.size()==0) {
		//System.out.println("list "+	list.toString());
        System.out.println("rem "+rem.toString());
		}
        if(list.size()==0)
    		return;
        System.out.println("----------");
        for(int j=0;j<list.size();j++)
        {
       // System.out.println("list "+	list.toString());
          int val= list.remove(j);
          rem.add(val);
           helper1(list,rem);
         //  System.out.println("adding "+val);
           rem.remove(rem.size()-1);
           list.add(j,val);
         //  System.out.println("after adding");
           //System.out.println("list "+	list.toString());
           //System.out.println("rem "+rem.toString());
        }
        //System.out.println("_________(_________\n");
        //System.out.println("list "+	list.toString());
        //System.out.println("rem "+rem.toString());
      //  System.out.println("__________)_________\n");
    }
	
	public static void helper(int arr[],int i)
    {
        if(i>=arr.length)
        return ;
     
        traverse(arr);  
        System.out.println("----------");
        for(int j=i+1;j<arr.length;j++)
        {
            //   System.out.println("i "+i);
            swap(arr,i,j);
             
            helper(arr,i+1);
            
            swap(arr,i,j);
        }
    }
    public static void swap(int arr[],int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
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
    public static void traverse(int arr[])
    {
        for(int i:arr)
        {
            System.out.print(i+ " ");
        }
        System.out.println();
    }
}


