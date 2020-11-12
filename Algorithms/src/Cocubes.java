
import java.math.BigInteger;

 class node{
      int val;
      node next;
      node(int x) { val = x; }
  }

public class Cocubes {
public static void main(String[] args) {
	BigInteger f=new BigInteger("10000000000");
	long y=1000;
	node o;
	node k=new node(0);
	node add=k;
	while(f.intValue()>0)
	{
		o=k;
		k=new node((int)f.intValue()%10);
		//System.out.println(k.val);
		o.next=k;
		System.out.println((int)f.intValue()%10);
		f=new BigInteger(String.valueOf(f.intValue()/10));
	}
	
	
	add=add.next;
	while(add!=null)
	{
		//System.out.println(add.val);
		add=add.next;
		
	}
	
}
}
