package functionalInterfaceExamples.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateNegate {



	public static void main(String[] args) {

		Predicate<Integer> p= x->x%2==0;


		Consumer c= x->System.out.println(x);

		List<Integer>list=Arrays.asList(1,2,3,4,5);

		list.stream().filter(p.negate()).forEach(c);
	}
}
