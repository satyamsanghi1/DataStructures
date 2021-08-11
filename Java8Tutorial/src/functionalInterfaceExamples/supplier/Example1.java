package functionalInterfaceExamples.supplier;

import java.util.function.Supplier;

public class Example1 {

	public static void main(String[] args) {
		
		
		Supplier<Integer>s=()->2;
		
		System.out.println(s.get());
		
		
	}
}
