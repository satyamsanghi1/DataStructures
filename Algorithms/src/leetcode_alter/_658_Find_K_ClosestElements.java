package leetcode_alter;

import java.util.ArrayList;

public class _658_Find_K_ClosestElements {

	public static void main(String[] args) {

		int arr[] = {1,2,4,5,8};
			
		//int arr[]= {1,2,3,4,5};
			
		
		ArrayList<Integer>list=new ArrayList<>();
		int n=arr.length;
		int x=3;
		int k=4;
		
		int crossOver=findCrossOverPoint(arr,x,arr.length-1);
		
		System.out.println("cross Over "+arr[crossOver]+" index "+crossOver);
		
		int l =crossOver; 
        int r = l+1;   // Right index to search 
        int count = 0; 
        
		/*
		 * if (arr[l] == x) { System.out.println("equal"); l--; }
		 */
        
        
		 while (l >= 0 && r < n && count < k) 
	        { 
		
	            if (Math.abs(x - arr[l]) <= Math.abs(arr[r] - x)) {
	                System.out.print(arr[l]+"a "); 
	                list.add(arr[l]);
	                l--;
	            
	            }
	                else if(Math.abs(x - arr[l]) > Math.abs(arr[r] - x)) {
	                System.out.print(arr[r]+" "); 
	                list.add(arr[r]);
	                r++;
	                
	                }
	            count++;
			 }
			
	            
	     
		 
		  while (count < k && l >= 0) 
	        { 
			    list.add(arr[l]);
	            System.out.print("data "+ arr[l--]+" "); 
	            count++; 
	        } 
		  while (count < k && r < n) 
	        { 
			   list.add(arr[r]);
	            System.out.print(arr[r++]+" "); 
	            count++; 
	        } 
		 
		
		

	}
	
	public static int findCrossOverPoint(int arr[],int x,int n)
	{
		if(arr[0]>x)
			return 0;
		
		else if(arr[n]<x)
			return n;
		
		int mid=(n+0)/2;
		System.out.println("mid "+arr[mid]+" midIndex "+mid);
		if(arr[mid]==x)
		{
			return mid;
		}
		else if(x<arr[mid])
		{
		
			for(int i=0;i<=mid;i++)
			{
				System.out.println("arr[i]"+arr[i]+" arr[i+1] "+arr[i+1]);
				if(arr[i]==x)
				{
					return i;
				}
				else if(arr[i]<=x && arr[i+1]>x)
				{
					return i+1
							;
				}
			}
		}
		else if(x>arr[mid])
		{
			
			for(int i=mid+1;i<=n;i++)
			{
				System.out.println("arr[i-1]"+arr[i-1]+" arr[i] "+arr[i]);
				
				if(arr[i]==x)
				{
					return i;
				}
				else if(arr[i-1]<=x && arr[i]>x)
				{
					System.out.println("i" +i);
					return i-1;
				}
			}
		}
		
		return 0;
	}


	

				


}
