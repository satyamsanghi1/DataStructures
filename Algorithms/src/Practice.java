import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Practice {
	
	static int count=0;
	public static void main(String[] args) {
	
		System.out.println("ans "+(2.5*10%10));
		String [] words= {"Hello", "Alaska", "Dad", "Peace"};
		
		  HashSet<Character>set1=new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
          HashSet<Character>set2=new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
          HashSet<Character>set3=new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
        
        int x1=0,x2=0,x3=0;
        
        ArrayList<String>list=new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            String p=words[i].toLowerCase();
        	System.out.println(words[i]);
            
            for(char c:p.toCharArray())
            {
            	
                if(set1.contains(c))
                    x1++;
                
                if(set2.contains(c))
                    x2++;
                if(set3.contains(c))
                    x3++;
                
            }
            System.out.println("x1 "+x1+" x2 "+x2+" x3 "+x3);
            if(x1==words[i].length())
            {
                list.add(words[i]);
            }
             if(x2==words[i].length())
             {
            	 System.out.println("here");
                list.add(words[i]);
             }
             if(x3==words[i].length())
             {
                list.add(words[i]);
             }
      
            x1=0;
            x2=0;
            x3=0;
                
        }
        System.out.println("list  "+list);
        String s[]=new String[list.size()];
        int q=0;
        for(String o:list)
            s[q++]=o;
    
		
		//System.out.println(x);
		/*
		 * 
		 * crio accelerate turtle communication problem
		 * 
		 * int grid[][]= {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
		
		 int count=0;
	        for(int i=0;i<grid.length;i++)
	        {
	            for(int j=0;j<grid[i].length-1;j++)
	            {
	                if(grid[i][j]==1 && grid[i][j+1]==1)
	                    count+=1;
	                
	            }
	        }
	        
	        for(int i=0;i<grid.length;i++)
	        {
	            for(int j=0;j<grid[i].length-1;j++)
	            {
	            	
	            	System.out.print(grid[j][i]+" ");
	            	if(grid[j][i]==1 && grid[j+1][i]==1)
	            		count+=1;
	            }
	            System.out.println();
	            
	        }
	           */ 
	        
		
	        //System.out.println("coount "+count);
		//String g="6913259244";
		//String q="71103343";
		
		/*String g="9";
		String q="1";
		//	System.out.println("max "+Integer.MAX_VALUE);
			
			int n1=g.length();
			int n2=q.length();
			int i=n1-1,j=n2-1;
			StringBuilder sb=new StringBuilder();
			int sum=0;
			while(i>=0 || j>=0 || sum!=0 )
			{
				if(i>=0) {
				int x=g.charAt(i--)-'0';
				System.out.print("x "+x);
				sum+=x;
				}
				if(j>=0) {
				int y=q.charAt(j--)-'0';
				System.out.println(" y "+y);
				sum+=y;
				}
				sb.append(sum%10);
				System.out.println(sum);
				sum=sum/10;
				System.out.println("sum "+sum);
				System.out.println(sb);
				System.out.println();
				
			}
			System.out.println("abs "+sb.reverse());
	*/	
	}
 
    
	
	
}
