package dynamcProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyClass {

	
	public static void main(String[] args) {
		
		
		Scanner in=new Scanner(System.in);
		List<String>data=new ArrayList<>();
		
		while(true)
		{
			String input=in.next();
			if(input.equals("q"))
				break;
			data.add(input);
			}
		
		int n=data.size();
		
		test( data, n);	

	}
	public static Float [] test(List<String>data,int n)
	{
		
		double []nums=new double[n];
		
		for(int i=0;i<n;i++)
		{
			nums[i]=Double.parseDouble(data.get(i));
		}
		
		double a=0,b=0,c=0;
		
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]>=42.195)
			{
			continue;
			}
				if(nums[i]>a)
				{
					c=b;
					b=a;
					a=nums[i];
				}
				else if(nums[i]>b)
				{
					c=b;
					b=nums[i];
				}
				else if(nums[i]>c)
				{
					c=nums[i];
				}
			
		}
		System.out.println("a "+a+" , b "+b+" c "+c);
		return new Float[]{(float)a,(float)b,(float)c};
	}
}
