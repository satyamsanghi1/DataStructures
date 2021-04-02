package algoExpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShortenPath {
		//my solution based on AlgoExpert Explanation
		// time ->(O)N,Space-> (O)N
		//leetcode 71 , 30%Fast
	
	public static void main(String[] args) {


		//String path="../../foo/../../bar/baz";

	//	String path="../../foo/../test/../test/..///foo//bar/./baz";

		//String path="foo/bar/baz";
		
		//String path="/home/foo/.ssh/../.ssh2/authorized_keys/";
		
		String path="./..";
		String ans=shortenPath(path);
		System.out.println("ans "+ans);

	}
	public static String shortenPath(String path) {
		// Write your code here;

		boolean isAbsolutePath=path.charAt(0)=='/';
		
		String []tokens=path.split("/");
		List<String>tokenList=Arrays.asList(tokens);
		List<String>filteredTokens=tokenList.stream()
				.filter(token->!token.isEmpty() && !token.equals("."))
				.collect(Collectors.toList());
		
		System.out.println("filtered "+filteredTokens);
		
		List<String>stack=new ArrayList<>();
		
		if(isAbsolutePath)
			stack.add("");
		
		for(String token:filteredTokens)
		{
			if(token.equals(".."))
			{
				// when relative path or prev token is .. eg ../..
				if(stack.size()==0 || stack.get(stack.size()-1).equals(".."))
					stack.add(token);
				//when prev token is String like foo
				else if(!stack.get(stack.size()-1).equals(""))
					stack.remove(stack.size()-1);
			}
			else
			{
				stack.add(token);
			}
		}
		//last token can be .. eg: ./.. 
		if(stack.size()==1 && stack.get(0).isEmpty())return "/";
	return String.join("/",stack);

	}
	
	public static void iterateTokens(String []tokens)
	{
		System.out.println();
		for(String token:tokens)
			System.out.print(token+",");
		System.out.println();
	}
}
