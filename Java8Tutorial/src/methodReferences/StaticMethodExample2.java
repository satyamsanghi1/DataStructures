package methodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StaticMethodExample2 {

	public static void main(String[] args) {


		List<String>l=Arrays.asList("1","2","3","4","5");

		//anonymous class
		List<Integer>list1=l.stream().map(new Function<String,Integer>()
		{

			public Integer apply(String s)
			{
				return Integer.parseInt(s);
			}
		}).collect(Collectors.toList());
		
		//lambda expression
		List<Integer>list2=l.stream().map(x->Integer.parseInt(x)).collect(Collectors.toList());
				
		//method reference
		List<Integer>list3=l.stream().map(Integer::parseInt).collect(Collectors.toList());


		System.out.println();

	}
}

