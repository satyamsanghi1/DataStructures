package methodReferences;

import java.util.function.Function;

public class ConstructorMethodReferenceExampleWithParamter{

	public static void main(String[] args) {
		
	
		
		FD f=Invoicee::new;
		
		Invoicee e=f.getInvoiceObject(2);
		
		Function<Integer,Invoicee>fz=Invoicee::new;
		
		
	}
	

}
interface FD
{
	public Invoicee getInvoiceObject(int x);
}
class Invoicee
{
	public Invoicee() {};
	
	public Invoicee(int price)
	{
		System.out.println("price is "+price);
	}
}
