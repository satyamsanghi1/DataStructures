import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class AliceMarks {
   
	
	public static int rank(int a[],int x)
	{
		
		System.out.println("ALICE MARK "+x);
		ArrayList<Integer> a1=new ArrayList();
		for(int i=0;i<a.length;i++)
		{
			a1.add(a[i]);
		}
		a1.add(x);
		
		TreeSet<Integer> set=new TreeSet<Integer>();
		ArrayList<Integer> dup=new ArrayList<Integer>();
		
		
		for(int i=0;i<a1.size();i++)
		{
			
			if(set.add(a1.get(i)))
			{
				System.out.println("caling different");
			}
			else
			{
				System.out.println("caling");
				dup.add(a1.get(i));
				
			}
			
		}
		
		
		int count=0;
		int [] rank=new int[set.size()];
		
		ArrayList<Integer> setArray=new ArrayList(set);
		
		for(int val:setArray)
		{
			
			System.out.print(val+" ");

		}
		
		System.out.println();
		
		for(int i=0;i<set.size();i++)
		{
			rank[i]=++count;
		}
		
		for(int i=0;i<rank.length;i++)
		{
			System.out.println(rank[i]);
		}
		
		int rank2[]=new int[dup.size()];
		int index=0;
		int count1=0;
		
		
		for(int i=0;i<dup.size();i++)
		{
			for(int j=0;j<set.size();j++)
			{
				if(dup.get(i)==setArray.get(j))
				{
					System.out.println("match j="+j);
					rank2[index]=rank[j];
					index++;
				}
				
				
			}
				}
		
		System.out.println();
		System.out.println("DOPLICATES");
		for(int val:dup)
		{
			System.out.println(val);

		}
		System.out.println("DUPLICATES RANK");
		for(int i=0;i<rank2.length;i++)
		{
			System.out.println(rank2[i]);
		}
		System.out.println("FINAL RANk");
		ArrayList<Integer>fiArray=new ArrayList<>();
		
		for(int i=0;i<setArray.size();i++)
		{
			fiArray.add(rank[i]);
		}
		for(int i=0;i<dup.size();i++)
		{
			fiArray.add(rank2[i]);
		}
		
		for(int val:fiArray)
		{
			System.out.println(val);

		}
		System.out.println("MARKS");
		Collections.sort(a1);
		Collections.sort(fiArray);
		for(int i=0;i<a1.size();i++)
		{
			System.out.print(a1.get(i)+" ");
			
		}
		System.out.println();
		int aliceIndex=0;
		for(int i=0;i<a1.size();i++)
		{
			
			if(x==a1.get(i))
			{
				aliceIndex=i;
				System.out.println("ALICE RANK "+a1.get(i));
			}
		}
		
		
		System.out.println("final rank");
		System.out.println(fiArray.get(aliceIndex));
		System.out.println("MARKS");
	
		for(int val:fiArray)
		{
			System.out.print(val+" ");
			

		}
		a1.remove(aliceIndex);
		int len=a1.size();
		System.out.println();
		for(int i=0;i<a1.size();i++)
		{
			System.out.print(a1.get(i)+" ");
			
		}
		return len-aliceIndex;
		
	}
	
	
	
	

	public static void main(String[] args) throws IOException {
	
		int a[]={100 ,90 ,90 ,80 ,75 ,60};
		
		int alice[]= {50, 65 ,77 ,90 ,102};
		
	       ArrayList<Integer>s=new ArrayList<Integer>();
	       //for(int i=0;i<alice.length;i++)
	        s.add(rank(a,alice[3]));
		
	       for(int x:s)
	       {
	    	   System.out.println("alice rank "+x);
	       }
	
}
}

