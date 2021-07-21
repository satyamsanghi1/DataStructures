package JavaConcepts;

import java.io.IOException;
import java.util.ArrayList;


public class CheckedExceptionExample {

	
	public static void main(String[] args) {
		
		ArrayList list=new ArrayList();
		
		list.add(1);
		list.add("aj");
		
		
		try {
			method1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void method1() throws IOException
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
