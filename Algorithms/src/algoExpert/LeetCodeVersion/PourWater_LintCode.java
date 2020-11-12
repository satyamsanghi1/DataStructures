package algoExpert.LeetCodeVersion;

public class PourWater_LintCode {
	
	public static void main(String[] args) {
		
		int [] heights= {13,7,9,6,4,4,4,10,15,9};
		
		pourWater(heights,7,1);
	}
	public static int[] pourWater(int[] heights, int V, int K) {
		// NOT WORKING 
		int a[]=heights.clone();
		
		
		for(int i=0;i<V;i++)
		{
			System.out.println("water val "+(i+1));
			int leftIdx=K-1;
			int rightIdx=K+1;

			//going left side
			int leftNotEqual=leftIdx;
			while(leftIdx-1>=0 && leftIdx>=0 && a[leftIdx]<=a[K]  && a[leftIdx-1]<=a[leftIdx])
			{
				if(a[leftIdx]!=a[leftIdx-1])
				{
					leftNotEqual=leftIdx-1;
				}
				System.out.println("left inc");
				leftIdx--;
			}
			System.out.println("left not "+leftNotEqual);
			if((leftNotEqual)!=-1 && a[leftNotEqual]<a[K])
			{
				a[leftNotEqual]++;
			
				traverse(a);
				System.out.println("L---------------");
				continue;
			}
			int notEqual=rightIdx;
			while(rightIdx+1<a.length &&rightIdx<a.length && a[rightIdx]<=a[K] && a[rightIdx]>=a[rightIdx+1])
			{
				if(a[rightIdx]!=a[rightIdx+1])
				{
					notEqual=rightIdx+1;
				}
				System.out.println("inc");
				rightIdx++;
			}
			System.out.println("right "+rightIdx);
			System.out.println("not " +notEqual);
			if(notEqual<a.length && a[notEqual]<a[K] )
			{
				a[notEqual]++;
				System.out.println("ading waqter "+notEqual);
				traverse(a);
				System.out.println("R---------------");
				continue;
			}
		
			
			System.out.println("left "+leftIdx);
			
			if(leftIdx==K-1 && rightIdx==K+1)
			{
				System.out.println("not moved left or right");
				a[K]++;
				System.out.println("---------------");
				continue;
			}
			if(rightIdx==a.length-1)
			{
				
				System.out.println("biggest ");
				a[K]++;
				System.out.println("---------------");
				continue;
			}
			traverse(a);
			System.out.println("---------------");
			
		}
		traverse(a);
		return a;
        // Write your code here
    }
	public static void traverse(int a[])
	{
		System.out.println();
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();
	}

}
