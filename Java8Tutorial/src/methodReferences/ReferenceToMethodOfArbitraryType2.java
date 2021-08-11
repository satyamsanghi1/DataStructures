package methodReferences;

import java.util.function.BiPredicate;
import java.util.function.Function;

public class ReferenceToMethodOfArbitraryType2 {


	public static void main(String[] args) {

		Provider p=new Provider();

		p.provideLength("satyam",String::length);

		Provider.playTwoArgument("satyam","sa",String::startsWith);
		
		
		
	}



}
class Provider
{
	public int provideLength(String s,Function<String,Integer>func)
	{
		return func.apply(s);
	}
	static Boolean playTwoArgument(String s1, String s2, BiPredicate<String, String> func) {
		return func.test(s1, s2);
	}
}
