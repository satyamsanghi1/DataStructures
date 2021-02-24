package interview;

abstract class AB{
	
	abstract public void hello();
}
class ABC extends AB
{
	public void hello() {
		System.out.println("hello");
	}
}

public class RuntimePolymorphism {

	public static void main(String[] args) {
		
		
		AB obj=new ABC();
		
		obj.hello();
	}
		
}
