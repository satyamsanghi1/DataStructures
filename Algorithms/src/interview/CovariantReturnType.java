package interview;


class A{
	public A foo() {
		return this;
	}
}

class B extends A{
	
	@Override
	public B foo() {
		return this;
	}
}
public class CovariantReturnType {

}
