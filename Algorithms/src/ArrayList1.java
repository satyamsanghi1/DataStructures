import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList1 {

	public static void main(String arg[])
	{
		 int n,i,q,index,val,j,k;
	        String qt="";
	        ArrayList arr=new ArrayList();
	        Scanner in=new Scanner(System.in);
	        System.out.println("Enter the size of the arrayList");
	        n=in.nextInt();
	        System.out.println("Enter elements in the arrayList");
	      for(i=0;i<n;i++)
	      {
	          arr.add(in.nextInt());
	      }
	      System.out.println("Enter the number of queries");
	        q=in.nextInt();
	        for(i=0;i<q;i++)
	        {
	        	 System.out.println("Enter the query name");
	            qt=in.next();
	            if(qt.equals("Insert"))
	            {
	            	System.out.println("Enter the index");
	                index=in.nextInt();
	                System.out.println("Enter the valued");
	                val=in.nextInt();
	                 //System.out.println(index);
	                // System.out.println(val);
	              //  arr.remove(index) ;
	                arr.add(index,val);
	                for(k=0;k<arr.size();k++)
	          	      System.out.print(arr.get(k)+" ");
	                
	            }
	            else if(qt.equals("Delete"))
	            {
	            	System.out.println("Enter the index");
	                index=in.nextInt();
	                arr.remove(index);
	             //   arr.add(index,0);
	                // System.out.println(index);
	                 //System.out.println(val);
	                for(k=0;k<arr.size();k++)
	          	      System.out.print(arr.get(k)+" ");
	            }
	        }
	        
	         System.out.println();
	      //  System.out.println(arr.get(3));
	  for(k=0;k<arr.size();k++)
	      System.out.print(arr.get(k)+" ");
	}
}
