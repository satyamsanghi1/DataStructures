package recursion;

public class ReverseCharArray {
	public static void main(String[] args) 
	{
		
		char[]a = {'a','b','c','d','e'};
		
		recur(a,0,a.length-1);
		
		for(char c:a)
		{
			System.out.println(c);
		}
		
	}
	
	public static char[] recur(char[]a,int i,int j)
	{
	
			if(i==j)
			{
				return a;
			}
			
			recur(a,i+1,j-1);
			char swap;
			swap=a[i];
			a[i]=a[j];
			a[j]=swap;
			
			System.out.println(i+" "+j);
		return a;
	}
}
