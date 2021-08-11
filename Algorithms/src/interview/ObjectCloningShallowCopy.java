package interview;

class Test1 implements Cloneable
{
	int a;
	int b;
	
	
	//not mandatory to override for class that dont have mutable objects
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	
}
public class ObjectCloningShallowCopy {

	public static void main(String[] args) {
		
		Test1 t=new Test1();
		t.a=1;
		t.b=2;
		
		
		
		//changes made on one object will reflect on the other
		Test1 t2=null;
		try {
			t2 = (Test1)t.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.a=4;
		
		System.out.println(t+" , "+t2);
	}
}
