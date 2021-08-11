package methodReferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ConstructorMethodReferenceExample1{

	public static void main(String[] args) {
		
		
		Supplier<Map> obj=HashMap::new;
		
		Supplier<List>obj2=ArrayList::new;
		
		Supplier<Invoice>obj3=Invoice::new;
		
		
	}
	

}
interface C
{
	public Invoice getInvoiceObject();
}
class Invoice
{
	public Invoice() {};
	
	public Invoice(int price)
	{
		
	}
}
