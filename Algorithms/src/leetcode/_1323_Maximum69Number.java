package leetcode;

public class _1323_Maximum69Number {
	
	public static void main(String[] args) {
		
		System.out.println("ans "+maximum69Number(9996));
	}
	public static int maximum69Number (int num)
	{
		String x=Integer.toString(num);
		char q[]=x.toCharArray();
		for(int i=0;i<q.length;i++)
		{
			if(q[i]=='6')
			{
				q[i]='9';
				break;
			}
			}
			
		String a=new String(q);
		System.out.println(a);
		
		
		return 0;
    }

	
}
