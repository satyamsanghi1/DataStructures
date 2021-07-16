package JavaConcepts;

import java.util.ArrayList;


public class CheckedExceptionExample {

	
	public static void main(String[] args) {
		
		ArrayList list=new ArrayList();
		
		list.add(1);
		list.add("aj");
		
		
		method1();
		
	}
	
	public static void method1() throws NullPointerException
	{
		int x=0;
		
		throw new NullPointerException();
//		try {
//		if(x>0)
//		throw new IOException();
//		}
//		catch(Exception e)
//		{
//			
//		}
	}
}
