package bitManipulation;

public class RightShift {

	public static void main(String[] args) {
		
		int x=3;
			
		System.out.println(Integer.toString(x,2));
		
		x=x<<1;
		
		String y=Integer.toBinaryString(x);
		System.out.println(y);
		
		System.out.println(Integer.parseInt(y,2));
		
		System.out.println(2^2);
		
	}
}
