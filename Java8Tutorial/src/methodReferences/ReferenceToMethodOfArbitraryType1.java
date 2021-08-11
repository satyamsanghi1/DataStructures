package methodReferences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;

public class ReferenceToMethodOfArbitraryType1 {


	public static void main(String[] args) {


		String[] stringArray = { "Barbara", "James", "Mary", "John",
				"Patricia", "Robert", "Michael", "Linda" };
		
		//anonymous class
		Arrays.sort(stringArray,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
		});
		
		
		
		//lambdaExpression
		Arrays.sort(stringArray,(a,b)->a.compareTo(b));
		
		//method reference of an object 
		Arrays.sort(stringArray,String::compareTo);
	}

}
