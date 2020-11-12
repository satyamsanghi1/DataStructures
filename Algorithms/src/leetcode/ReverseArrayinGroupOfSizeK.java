package leetcode;

//geeks for geeks
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReverseArrayinGroupOfSizeK {

		public static void main(String[] args) throws IOException {
			
			  ReverseArrayinGroupOfSizeK res = new ReverseArrayinGroupOfSizeK();
				//code
				//Scanner in=new Scanner(System.in);
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				
				String ix = reader.readLine();
				
				int a=Integer.parseInt(ix);
				//int a=in.nextInt();
				System.out.println("a "+a);
				for(int q=0;q<a;q++)
				{
				String input=reader.readLine();
				String []inputs=input.split(" ");
			
				    int size=Integer.parseInt(inputs[0]);
				    int groupsize=Integer.parseInt(inputs[1]);
				    System.out.println("size "+size  +" , groupsize "+groupsize);
				    
				    int array[]=new int[size];
				    // taking array input
				    String input_array=reader.readLine();
				    String array_elements[]=input_array.split(" ");
				    for(int j=0;j<array_elements.length;j++)
				    array[j]=Integer.parseInt(array_elements[j]);
				    traverse(array);
				    if(groupsize>array.length)
				    {
				        reverse(0,array.length-1,array);
				        traverse(array);
				    }
				    else
				    {

				  // stem.out.printl Syn("size "+size+" ,groupsize "+groupsize);
				    int i=0;
				    while(i<array.length)
					{	
					  //  System.out.println("here");
							int limit=i+groupsize-1;
						    if(limit>=array.length)
						    {
									break;
						    }
								reverse(i,limit,array);
							
							i+=groupsize;
						
					}
					if(i<array.length)
					{
						reverse(i,array.length-1, array);
					}
					    traverse(array);
				    }
				    
				    
				}
		}
		public static void reverse(int start,int end,int[]array)
		{
			System.out.println("start "+start+"end "+end);
			int temp=0;
			
			
			while(start<end)
			{
				
				temp=array[start];
				array[start]=array[end];
				array[end]=temp;
				start++;
				end--;
			}
		}
		public static void traverse(int []a)
		{
			System.out.println();
			for(int i:a)
				System.out.print(i+" ");
			System.out.println();
		}
		

}
