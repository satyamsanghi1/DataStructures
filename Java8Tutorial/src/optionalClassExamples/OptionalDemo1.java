package optionalClassExamples;

import java.util.Optional;
import java.util.function.Supplier;


public class OptionalDemo1 {

	public static void main(String[] args) {
		
		
		
		//System.out.println(op.isPresent());
		
		String []s=new String[5];
			s[1]="1";
		//passed value should not be null
		//Optional<String>p=Optional.of(s[2]);
		
		Optional<String>p=Optional.ofNullable(s[2]);
		
		if(p.isPresent())
		System.out.println(p.get());
		
		System.out.println(p.orElse("Empty"));
		
		System.out.println(p.orElseGet(String::new));
	
		//System.out.println(p.orElseThrow(ArithmeticException::new));
		
		
		p.ifPresent(System.out::println);
		
		p.ifPresentOrElse(System.out::print,()->System.out.println("no value present"));
		
		Optional<String>pp=Optional.ofNullable(s[1]);
		int value=pp.map(Integer::valueOf).orElse(0);
		
		System.out.println(value);
		
		Optional opp=p.or(Optional::empty);
		
		
	}
	
}
