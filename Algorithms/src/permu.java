import java.util.Arrays;
import java.util.Scanner;

public class permu {

	public static void main(String arg[])
	{
		Scanner in =new Scanner(System.in);
		String n=in.next();
		String ar[]=n.split(",");
		int a[]=new int[ar.length];
		for(int i=0;i<ar.length;i++)
		{
			a[i]=Integer.parseInt(ar[i]);
		}
		int r[]=new int[ar.length];
		for(int j=0;j<a.length;j++)
		{
			r[j]=Arrays.stream(a).sum()-a[j];
			
		}
		for(int i=0;i<r.length-1;i++) {
			System.out.print(r[i]+",");
		}
		
		System.out.print(r[r.length-1]);
	}
}
