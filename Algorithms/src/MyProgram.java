import java.util.Scanner;

public class MyProgram {
public static void main(String arg[])
{
	int count=0,testedarr[],j,inc=0,i;
	boolean check=true;
	Scanner in=new Scanner(System.in);
	System.out.println("enter the size of the array");
	int n=in.nextInt();
	int arr[]=new int[n];
	testedarr=new int[n];
	System.out.println("enter "+n+" elements in the array");
	for(j=0;j<n;j++)
		arr[j]=in.nextInt();
	//logic
	
	for( i=0;i<arr.length;i++)
	{

		for(j=0;j<arr.length;j++)
		{
		if(testedarr[j]==arr[i])
		{
			check=false;
			
		}
		}
		if(check==false)
		{
			
			inc++;
			testedarr[i]=arr[i];
		
		}
		check=true;

}
	for(i=0;i<testedarr.length;i++)
	{
		System.out.println(testedarr[i]+" ");
	}
}
}
