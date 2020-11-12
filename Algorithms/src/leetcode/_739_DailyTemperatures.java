package leetcode;

import java.util.HashMap;
import java.util.Stack;

/*
 * 
 * REFERENCE : https://www.youtube.com/watch?v=WGm4Kj3lhRI
 */
class Pair
{
	int value;
	int index; 
	
	public Pair(int value,int index)
	{
		this.value=value;
		this.index=index;
	}
}
public class _739_DailyTemperatures {
	
	public static void main(String[] args) {
		
		int []T = {89,62,70,58,47,47,46,76,100,70};
		//  8 1 5 4 3 2 1 1 0 0 
		dailyTemperaturesAlter1(T);
		
	}
	  public static  int[] dailyTemperatures(int[] T) {
		  
		  // we can store index of elements in stack
		  // no need of hashmap
		  
		  // we will start from behind 
		  int []ans=new int[T.length];
		  Stack<Integer>stack=new Stack<>();
		  // pushing the index of last element in the stack 
		  stack.push(T.length-1);
		  
		  for(int i=T.length-2;i>=0;i--)
		  {
			  System.out.println("current "+T[i]);
			  while(!stack.isEmpty() && T[i]>=T[stack.peek()])
			  {
				  int x=stack.pop();
				
				  System.out.println("pop "+T[x]);
				  System.out.println("----------------------");
			  }
			  if(!stack.isEmpty() && T[stack.peek()]>T[i])
			  {
				 	 System.out.println("here> "+T[i]);
				 ans[i]=stack.peek()-i;
				  System.out.println("ans["+i+"]="+ans[i]);
			  }
			  stack.push(i);
			
			  System.out.println("_______________________________________________");
		  }
		  traverse(ans);
		  return ans;
	  } 
	  public static  int[] dailyTemperaturesAlter1(int[] T) {
		  // 48%Fast 
		  int []ans=new int[T.length];
		  Stack<Integer>stack=new Stack<>();
		  
		  stack.push(0);
		  for(int i=1;i<T.length;i++)
	        {
	            
			  /*
			   * if the element at peek index of stack is less than curren element 
			   * than pop and store the diference between the index 
			   */
	            while( !stack.isEmpty()  && T[i]>T[stack.peek()])
	            {
	              int index=stack.pop();
	              ans[index]=i-index;
	            }
	            
	            // push the current elemenet index in stack
	          stack.push(i);
	         
	        }
	  traverse(ans);
		  return ans;
	  }
	  public static  int[] dailyTemperaturesAlter(int[] T) {
	        
	    // thought of storing element with index
	        int []ans=new int[T.length];
	        Stack<Pair>stack=new Stack<>();
	        
	        stack.push(new Pair(T[0],0));
	       
	      
	  for(int i=1;i<T.length;i++)
	        {
	            
	            while( !stack.isEmpty()  && T[i]>stack.peek().value)
	            {
	              Pair p=stack.pop();
	              ans[p.index]=i-p.index;
	            }
	            
	          stack.push(new Pair(T[i],i));
	         
	        }
	  
	        
	        traverse(ans);
	        return ans;
	    }
	  public static void traverse(int a[])
		 {
			 
			 for(int i:a)
				 System.out.print(i+" ");
			 System.out.println();
		 }

}
