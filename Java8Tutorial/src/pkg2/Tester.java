package pkg2;

import java.util.HashMap;

public class Tester implements Cloneable  {

	
	int x=2;
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Tester t1=new Tester();
		Tester t2=(Tester) t1.clone();
		
		t2.x=3;
		System.out.println(t1.x);
		System.out.println(t2.x);
		
		
		
		System.out.println(t1.getClass());
	}
}
