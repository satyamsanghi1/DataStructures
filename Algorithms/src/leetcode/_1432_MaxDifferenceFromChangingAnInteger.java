package leetcode;

public class _1432_MaxDifferenceFromChangingAnInteger {

	
	public static void main(String[] args) {
		

		int x=110157;
		String o=Integer.toString(x);
		String s=o;
	
		int greatest=0;
		int smallest=0;
		//finding greatest
		boolean flag=false;
		boolean flag1=false;
		for(int i=0;i<s.length();i++)
		{
			
			int a=Integer.valueOf(s.charAt(i)+"");
			if(a!=9)
			{
				System.out.println("here");
				s=replace(s,'9',s.charAt(i));
				greatest=Integer.valueOf(s);
				flag=true;
				break;
				//s.replace(s.charAt(i),'9');
			}
		}
		if(flag==false)
		{
			greatest=Integer.valueOf(s);
		}
		  System.out.println("greatest "+greatest);
		  s=o;
		  System.out.println("s "+s);
		  //checking all one
		  int count=0;
		  for(int i=0;i<s.length();i++)
			{
			  if(s.charAt(i)=='1')
				  count++;
			}
		  
		  
		  if(count==s.length())
		  {
			  smallest=Integer.valueOf(o);
			  flag1=true;
		  }
		//finding smallest
		  int count2=0;
		  if(flag1==false)
		  {
		for(int i=0;i<s.length();i++)
		{
			System.out.println("i "+i);
			int a=Integer.valueOf(s.charAt(i)+"");
			if(a!=1 && i==0)
			{
				System.out.println("here in ");
				s=replace(s,'1',s.charAt(i));
				smallest=Integer.valueOf(s);
				//flag1=true;
				break;
				//s.replace(s.charAt(i),'9');
			}
			else if(s.charAt(i)!=s.charAt(0) && s.charAt(i)!='0')
			{
				System.out.println("in else at "+i);
				s=replace(s,'0',s.charAt(i));
				smallest=Integer.valueOf(s);
				//flag1=true;
				break;
			}
			else
				count2++;
		}
		  }
		  if(count2==s.length())
		  {
			  smallest=Integer.valueOf(o);
			  
		  }
		  System.out.println("count2 "+count2);
		System.out.println("flag1  "+flag1);
		
		System.out.println("smallest "+smallest);
		
		int maxDiff=greatest-smallest;
		System.out.println("max Difference "+maxDiff);
	}
	public static String replace(String s,char c,char toReplace)
	{
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==toReplace)
				s=s.replace(s.charAt(i),c);
			
		}
		return s;
	}
}
