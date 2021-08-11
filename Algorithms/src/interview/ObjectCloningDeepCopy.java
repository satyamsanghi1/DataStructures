package interview;

class Test2 implements Cloneable
{
	int a;
	int b;
	LinkedList node;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		return "Test1 [a=" + a + ", b=" + b + ", node=" + node + "]";
	}


	
}

class Z
{
	protected void method1()
	{
		System.out.println("hello");
	}
}
class X extends Z
{
	
}
public class ObjectCloningDeepCopy {

	public static void main(String[] args) {
		
		X obj=new X();
		obj.method1();
	}
}
