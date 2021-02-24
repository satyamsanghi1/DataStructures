	package OOPS;

import java.util.ArrayList;
import java.util.Collections;

class Base   
	{  
		public void baseMethod()  
		{  
			System.out.println("BaseMethod called ...");  
		}  
	}  
	class Derived extends Base   
	{  
		public void baseMethod()  
		{  
			System.out.println("Derived method called ...");  
		}  
	}  
	public class OverridingExample {
	
	
		public static void main(String[] args) {
	
			//Base b = new Derived();  
			//b.baseMethod();  
			
			ArrayList<Integer> l=new ArrayList<>(1);
			
			l.add(1);
			l.add(2);
			l.add(3);
			Collections.sort(l,Collections.reverseOrder());
			
			
			System.out.println(l.size());
	
		}
	}
