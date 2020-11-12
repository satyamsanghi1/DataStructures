package leetcode;

public class _443_StringCompresssion {
	
	public static void main(String[] args) {
		
		
	////SOLVING WITH THE HELP OF TWO POINTER 
		
		// ONE POINTER KEEPS TRACK OF  CURRENT INDEX 
		
		// OTHER ONE KEEPS TRACK OF UNIQUE ELEMENTS 
		
		//char [] chars= {'a','a','b','b','c','c','c'};
		//char[] chars = {'a'};
			//char [] chars= {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
	
//	char [] chars= {'a','b','b','b','b','b','b','b','b','b','b','b','b','c'};
		char [] chars= {'a','b','b','b','b','b','b','b','b','b','b','b','b','c','c'};

			//char [] chars= {'b','b','b','b','b','b','b','b','b','b','b','b','a'};
		
	
		//char arr[]=chars;
		int j=0;
		int count=1;
		int n=chars.length;
		for(int i=0;i<chars.length-1;i++)
		{
			char a=chars[i];
			char b=chars[i+1];
			
			if(a!=b)
			{
				System.out.println();
				System.out.println("In if " +a+" , "+b);
				//step 1
				chars[j]=chars[i];
				if(count==1)
					j++;// increasing j if count is 1 , we should keep that value and shift j for next 
				
				if(count>1 && count <10)
				{
					System.out.println("count>1 "+chars[i]);
					j++;
					   chars[j]=(char)(count+'0');
					   count=1;
					  // for step 1 so that j can be shifted to next index  
					   j++;
				}
				else if(count>9)
				{
					System.out.println("big count "+count);
					String s=Integer.toString(count);
					for(int p=0;p<s.length();p++)
					{
						j++;
						chars[j]=s.charAt(p);
					}
					j++;
					count=1;
				}
			}
			else
			{
				count++;
			}

		}
	//for loop ends 
		System.out.println("OUTSIDE LOOP");
		System.out.println();
		System.out.println(" j value "+j);
		System.out.println("count value "+count);
			
		chars[j]=chars[n-1];
		if(count>1 && count<10)
		{
			//if count >1 then shifting j for count value
			j++;
			 chars[j]=(char)(count+'0');	
		}
		else if(count>9)
		{
			
			System.out.println("big count "+count);
			String s=Integer.toString(count);
			for(int p=0;p<s.length();p++)
			{
				j++;
				chars[j]=s.charAt(p);
			}
		}
		
		System.out.println();
		System.out.println("FINAL TRAVERSING");
		j++;
		for(int q=0;q<j;q++)
        {
        	System.out.print(chars[q]+",");
        }
		
		System.out.println("FINAL j "+j);
		/*
		 * 
		 *   char[]ans=new char[chars.length];
		 *   int j=0;
		  int count=1;
		  int n=chars.length;
	        for(int i=0;i<chars.length-1;i++)
	        {
	        	System.out.println("current value "+chars[i]);
	        	char a=chars[i];
	        	char b=chars[i+1];
	            if(a!=b)
	            {
	            	System.out.println();
	             	System.out.println("CHANGING j "+j);
	            	System.out.println("1st "+a+" 2nd "+b);
	           
	            	System.out.println();
	            	ans[j]=chars[i];
	            	System.out.println("ans[j] : "+ans[j]);
	            	j++;
	            	
	            
	            if(count>1 && count<10) {
	            	
	            ans[j]=(char)(count+'0');
	            j++;
	          
	            }
	            else if(count>9)
	            {
	        
	            	System.out.println("in loop :J in else "+j);
	            	   String s=Integer.toString(count);
	            	 for(int q=0;q<s.length();q++)
		        	   {
		        		   ans[j]=s.charAt(q);
		        		   j++;
		        	   }
	            	  
	            }
	            count=1;
	            }
	            else
	            {
	            	count++;
	            }
	            System.out.println("j "+j);
	            
	        }
	        System.out.println("OUTSIDE LOOP j "+j);
	        System.out.println();
	        System.out.println("count "+count);
	        System.out.println();
	       
	        ans[j]=chars[n-1];
	        if(count==1)
	          j++;
	        else if(count>1 && count<10) {
	        	  
	        	  j++;
	        	   System.out.println("after j "+j);
	            ans[j]=(char)(count+'0');
	            j++;
	           }
	           else
	           { 
	        	   System.out.println("j in else "+j );
	        	   ans[j]=chars[n-1];
	        	   j++;
	        	   String s=Integer.toString(count);
	        	   System.out.println("count string s[0] "+s.charAt(0));
	        	   for(int i=0;i<s.length();i++)
	        	   {
	        		   ans[j]=s.charAt(i);
	        		   j++;
	        	   }
	        	  	        	  
	           }

	        System.out.println();
	        System.out.println("TRAVERSING");
	        System.out.println();
	        
	        for(int i=0;i<j;i++)
	        {
	        	System.out.print(ans[i]+",");
	        }
	       */ 
	       
	}

}
