package defaultMethods;


interface A
{
	default void method()
	{
		System.out.println("hello");
	}
}

interface B extends A
{
	
}

class Test implements B
{
	
}
public class DefaultMethodInheritance {

	public static void main(String[] args) {
		
		B b=new Test();
		b.method();
	}
}
