package functionalInterfaceExamples.function;

import java.util.function.Function;

public class FunctionChaining {


	public static void main(String[] args) {


		Function<Integer,Integer>function2 = x->x*2;
		Function<String,Integer>function1 = x->x.length();

		
		int x=function1.andThen(function2).apply("satyam");
		
		System.out.println(x);
	}
}
