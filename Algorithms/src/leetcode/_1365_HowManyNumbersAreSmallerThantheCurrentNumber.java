package leetcode;

public class _1365_HowManyNumbersAreSmallerThantheCurrentNumber {

	public static void main(String[] args) {

		int a[] = { 8, 1, 2, 2, 3 };

		
		int b[]=new int[11];
		int c[]=new int[11];
		for(int i=0;i<a.length;i++)
		{
			b[a[i]]++;
		}
		
		System.out.println("TRAVERSING B ");

		for(int i:b)
		{
			System.out.print(i+" ");
		}
		
		for(int i=1;i<b.length;i++)
		{
			c[i]=b[i-1]+c[i-1];
		}
		
		System.out.println();
		System.out.println("TRAVERSING C ");

		for(int i:c)
		{
			System.out.print(i+" ");
		}
		
		
		int ans[]=new int[a.length];
		
		for(int i=0;i<ans.length;i++)
		{
			ans[i]=c[a[i]];
			
		}
		System.out.println("TRAVERSING ANSWER");
		
		for(int i:ans)
			System.out.print(i);

	
		
		
		
		
		
		/*
		 * 
		 * BRUTE FORCE TECHNIQUE
		 * 
		 * int b[]=new int[a.length];
		 * 
		 * for(int i=0;i<a.length;i++) { int count=0; for(int j=0;j<a.length;j++) {
		 * if(a[i]>a[j]) { count++; } } b[i]=count; count=0; }
		 * 
		 * System.out.println("TRAVERSING ANSWER");
		 * 
		 * for(int i:b) { System.out.println(i+" "); }
		 */
	}

}
