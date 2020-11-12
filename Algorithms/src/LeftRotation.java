
public class LeftRotation {
	
	public static void main(String[] args) {
		
		
		///reversing a string 
		
		String c="123";//012
		///231 //////120
		
		int x=Integer.valueOf(c);
		
		int n=5;
		for(int i=0;i<n;i++)
		{
		int a=x/100;
		int b=x%100;
		//System.out.println(a);
		//System.out.println(b);
		
		String y="";
		
		y+=Integer.toString(b)+Integer.toString(a);
		x=Integer.valueOf(y);
		System.out.println(y);
		}
		//312
	
	}

}
