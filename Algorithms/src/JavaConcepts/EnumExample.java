package JavaConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

class Element
{
	
}
enum Day{
	Monday,Tuesday,Wednesday
}
public class EnumExample {

	public static void main(String[] args) {
		
	Element e1=new Element();	
	
	
	ArrayList<Element>a=new ArrayList<>();
	
	
	Collections.sort(a,new Comparator<Element>() {

		@Override
		public int compare(Element o1, Element o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	});
	}
}
