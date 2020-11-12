package algoExpert;

public class MonotonicArray {

	public static void main(String[] args) {
		
		int a[]= {-1, -5, -10, -1100, -900, -1101, -1102, -9001};	
		
		//isMonotonic(a);
		
		boolean ans=isMonotonicAlter(a);
		System.out.println("ans "+ans);
		
	}
	
	  public boolean isMonotonic1(int[] A) {
      	if(A.length==0)
			return true;
	
      boolean inc=true;
      boolean dec=true;
		for(int i=0;i<A.length-1;i++)
		{
			if(A[i+1]<A[i])
              inc=false;
			
			if(A[i+1]>A[i])
              dec=false;
		}
          return inc||dec;
  }
	  
public static boolean isMonotonicAlter(int[] array) {
		
		int countInc=0;
		int countDec=0;
		
		for(int i=0;i<array.length-1;i++)
		{
			if(array[i+1]<array[i])
			{
				countInc++;
			}
			
			if(array[i+1]>array[i])
			{
				countDec++;
			}
			System.out.println("countDec "+countDec+" countInc "+countInc);
			if(countDec>0 && countInc>0)
				return false;
		}
		
		System.out.println("countDec "+countDec+" countInc "+countInc);
		return true;
	}

	public static boolean isMonotonic(int[] array) {
		
		int countInc=0;
		int countDec=0;
		
		for(int i=0;i<array.length-1;i++)
		{
			if(array[i+1]<=array[i])
				countInc++;
			
			if(array[i+1]>=array[i])
				countDec++;
		}
		
		if(countInc==array.length-1 || countDec==array.length-1)
		{
			System.out.println("array is monotonic");
		}
		System.out.println("countDec "+countDec+" countInc "+countInc);
		return true;
	}
}
