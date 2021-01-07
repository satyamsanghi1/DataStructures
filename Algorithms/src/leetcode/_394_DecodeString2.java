package leetcode;

import java.util.Stack;

public class _394_DecodeString2 {

	
	public static void main(String[] args) {
		
		/*ALGO  28%Fast
		 * using stack
		 * 
		 * loop through s for each c 
		 * 
		 * if c is a char:
		 * 		loop till we have a char and create string,reverse  and push onto stack
		 * 
		 * if c is a digit :
		 * 		loop till we find a contns no eg( 12[ab] )and push on to stack
		 * 
		 * if c is [ :
		 * 		push [ onto stack
		 * 
		 * if c is ] :
		 * 		pop stack till we find [ and append into rep
		 * 		pop again to find the digit  x
		 * 
		 * 		multiply rep x times and push rep onto stack
		 * 		
		 * after coming out of loop 
		 * pop stack and append in String , and reverse 
		 * 
		 */
		String s="3[a2[c]]";
		String ans=decodeString(s);
		System.out.println("ans "+ans);
		
	}
	   public static String decodeString(String s) {
		      
		   Stack<String>stack=new Stack<>();
		   int i=0;
		   while(i<s.length())
		   {
			   char c=s.charAt(i);
			   System.out.println("c "+c);
			   if( Character.isAlphabetic(s.charAt(i)))
			   {
				   StringBuilder sb=new StringBuilder();
				   while(i<s.length() && Character.isAlphabetic(s.charAt(i)))
				   {
					   sb.append(s.charAt(i)+"");
					   i++;
				   }
				   stack.push(sb.reverse().toString());
			   }
			   // find length of digit 
			   else if( Character.isDigit(c))
			   {

				   StringBuilder sb=new StringBuilder();
				   while(i<s.length() && Character.isDigit(s.charAt(i)))
				   {
					   sb.append(s.charAt(i)+"");
					   i++;
				   }
				   stack.push(sb.toString());
			   }

			   else if(c=='[')
			   {
				   stack.push(c+"");
				   i++;
			   }
			   else  if(c==']')
			   {
				   System.out.println("here "+i);
				   StringBuilder jo=new StringBuilder();
				   while(!stack.peek().equals("["))
				   {
					   jo.append(stack.pop());
				   }

				   String pop=  stack.pop(); // popping [
				   System.out.println("pop "+pop);
				   int rep=Integer.parseInt(stack.pop());

				   StringBuilder repeat =new StringBuilder();
				   for(int z=0;z<rep;z++)
				   {
					   repeat.append(jo);
				   }
				   stack.push(repeat.toString());
				   i++;
			   }


			   traverse(stack);
			   System.out.println("-------------------");
		   }

	        
	        
	        StringBuilder last=new StringBuilder();
	           while(!stack.isEmpty())
	         {
	             last.append(stack.pop());
	         }
	          
	        return last.reverse().toString();
	    }
	   public static void traverse(Stack<String >s)
	   {
		   System.out.println("traversing");
		   s.forEach((x)->{
			   System.out.println(x);
		   });
	   }
	  
	
}
