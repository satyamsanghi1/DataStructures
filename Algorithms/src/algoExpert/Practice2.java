package algoExpert;
import java.util.Arrays;
import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		
		Scanner in =new Scanner(System.in);
		String s=in.nextLine();
		String sp[]=s.split(" ");
		int i=0;
		int []ar=new int [sp.length];
		for(String x:sp)
		{
			ar[i++]=Integer.valueOf(x);
		}
		
		Arrays.sort(ar);
		int leftIdx=1;
		int rightIdx=ar.length-2;
		
		int left=ar[0];
		int right=ar[ar.length-1];
		
		while(leftIdx<rightIdx)
		{
			System.out.println("leftidx "+leftIdx+" rightIdx "+rightIdx);
			if(left<right)
			{
				left+=ar[leftIdx];
				leftIdx++;
				
			}
			else if(right<left)
			{
				right+=ar[rightIdx];
				rightIdx--;
			}
			else
			{	
				
				right+=ar[rightIdx];
				left+=ar[leftIdx];
				leftIdx++;
				rightIdx--;
				
			}
			
		}
		System.out.println(Math.max(left,right));
	}
}
