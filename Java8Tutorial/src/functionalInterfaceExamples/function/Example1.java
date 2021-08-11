package functionalInterfaceExamples.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Example1 {

	public static void main(String[] args) {
		
		
		Function<Integer,Integer>function = x->x*2;
		
		System.out.println(function.apply(2));
	}
}
