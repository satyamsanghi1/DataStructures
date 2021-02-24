package algoExpert;

import java.util.ArrayList;

public class ValidIPAddresses {

//Leetcode 93
	public static void main(String[] args) {


		StringBuilder sb=new StringBuilder();
		String x="asd";
		sb.append("satyam");
		sb.delete(2,sb.length());
		System.out.println("sb "+sb.toString());

	}
	public ArrayList<String> validIPAddresses(String string) {
		// Write your code here.
		ArrayList<String>list=new ArrayList<>();
		StringBuilder sb=new StringBuilder();
		helper(string,list,0,1,sb);
		return list;
	}
	public void helper(String string,ArrayList<String>list,int i,int c,StringBuilder sb)
	{
		if(c>4)
			return ;
		if(c==4)
		{
			String last=string.substring(i,string.length());
			if(!validate(last))
				return ;
			sb.append(last);
			list.add(sb.toString());
			return ;
		}

		for(int x=1;x<=3;x++)
		{
			if(x+i>=string.length())
				return ;
			String current=string.substring(i,x+i);
			if(!validate(current))
				return ;
			int n=sb.length();
			sb.append(current+".");
			helper(string,list,i+x,c+1,sb);
			sb.delete(n,sb.length());
		}

	}
	public boolean validate(String s)
	{
		int val=Integer.parseInt(s);
		if(val>255)
			return false;
		if(s.length()>1 && s.startsWith("0"))
			return false;

		return true;
	}
}

