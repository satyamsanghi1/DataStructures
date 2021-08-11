package functionalInterfaceExamples.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MultiplePredicatesInFilter {

public static void main(String[] args) {
		
		Predicate<Integer> p1= x->x%2==0;
		Predicate<Integer> p2= x->x>2;
		
		
		p1.negate();
		Consumer c= x->System.out.println(x);
		
		List<Integer>list=Arrays.asList(1,2,3,4,5,6,7,8);
		
		list.stream().filter(p1.or(p2)).forEach(c); // or condition
		
		list.stream().filter(p1.and(p2)).forEach(c); // and condition
		
}
}
