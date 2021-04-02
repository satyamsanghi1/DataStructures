package algoExpert.LeetCodeVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class _71_SimplifyPath {

	//my solution based on AlgoExpert Explanation
			// time ->(O)N,Space-> (O)N
			//leetcode 71 , 30%Fast
		
	// leetcode version contains only absolute path
	public static void main(String[] args) {


		//	String ans=shortenPath(path);
		//System.out.println("ans "+ans);

	}
	public static String shortenPath(String path) {
		// Write your code here;

		String []tokens=path.split("/");
		List<String>tokenList=Arrays.asList(tokens);
		List<String>filteredTokens=tokenList.stream()
				.filter(token->!token.isEmpty() && !token.equals("."))
				.collect(Collectors.toList());
		
		
		
		List<String>stack=new ArrayList<>();
		
		
		
		for(String token:filteredTokens)
		{
			if(token.equals(".."))
			{

				//when prev token is String like foo
				 if(!stack.get(stack.size()-1).equals(""))
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
	
	
}
