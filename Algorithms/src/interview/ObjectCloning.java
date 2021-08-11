package interview;

class Test 
{
	int a;
	int b;
	@Override
	public String toString() {
		return "Test [a=" + a + ", b=" + b + "]";
	}
	
}
public class ObjectCloning {

	public static void main(String[] args) {
		
		Test t=new Test();
		t.a=1;
		t.b=2;
		
		//just creating another reference varible to same memory location
		//changes made on one object will reflect on the other
		Test t2=t;
		
		t.a=4;
		
		System.out.println(t+" , "+t2);
	}
}
