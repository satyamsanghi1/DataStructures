package searching_and_sorting;

public class KMPStringMatching {
	
	public static void main(String[] args) {
		
		String text="abxabcabcaby";
		
		String pattern="abcaby";
		
	int a[]=	createArray(pattern);
	traverseArray(a);
		System.out.println();
		System.out.println();
		boolean ans=KMPSearch(a, text, pattern);
		
		System.out.println("ANSWER "+ans);
	}
	
	public static boolean KMPSearch(int a[],String text,String pattern)
	{
		
		int i=0; // for text
		int j=0; // for pattern
		
	
		while(i<text.length() && j<pattern.length())
		{		
			char c=text.charAt(i);
			char v=pattern.charAt(j);
			
			System.out.println("current c: "+c+" v: "+v);
			
			if(c==v)
			{
				System.out.println("matched i "+i+" j "+j);
				i++;
				j++;
				if(j==pattern.length())
					return true;
			}
			else
			{
				System.out.println("not matched i :"+i+" , j : "+j);
				if(j>0)
				{
					int prevIndex=j;
					--prevIndex;
				j=a[prevIndex];
				}
				else
				{
					
					i++;
				}
			}
			System.out.println();
			
		}
	
	
		
		return false;
		
		
	}

	
	public static int[] createArray(String pattern )
	{
		
		int a[]=new int[pattern.length()];
		
		//a[0]=0;
		int i=0;
		int j=1;
		int k=1;
		
			while(k<a.length && i<pattern.length() && j<pattern.length())
			{
			char c=pattern.charAt(i);
			char v=pattern.charAt(j);
			
			//System.out.println("current c: "+c+" v: "+v);
			if(c==v)
			{
				//System.out.println("matched i "+i+" j "+j);
				a[k]=i+1;
				i++;
				j++;
				k++;
		}
			else
			{ 
		//		System.out.println("not matched i :"+i+" , j : "+j);
				
	//			System.out.println("i "+i);
				int prevIndex=i;
				--prevIndex;
				if(prevIndex>=0) 
				{
			//		System.out.println("prev index "+prevIndex);
			//		System.out.println("j "+j);
				i=a[prevIndex];
				
				}
				else
				{
					j++;
					k++;
				}
				
			}
		//	System.out.println();
		
		}
	//	traverseArray(a);
		
		return a;
		
	}
	
	public static void traverseArray(int[] a)
	{
		for(int x:a)
			System.out.print(x+" ");
	}

}
