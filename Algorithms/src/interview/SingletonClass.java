package interview;

public class SingletonClass {
	
	private static SingletonClass obj;
	
	private SingletonClass()
	{
	}
	
	public static SingletonClass getSingleton()
	{
		if(obj==null)
			obj=new SingletonClass();
		return obj;
	}

}
