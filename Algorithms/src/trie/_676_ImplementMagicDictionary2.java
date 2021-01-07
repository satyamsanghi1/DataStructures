package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _676_ImplementMagicDictionary2 {
	//16%Fast Time : summation of Wi^2
	/*For each word in dict, for each char, 
	 * remove the char and put the rest of the word as key,
	 *  a pair of index of the removed char and the char as part of value list into a map.
	 *   e.g.
		"hello" -> {"ello":[[0, 'h']], "hllo":[[1, 'e']], "helo":[[2, 'l'],[3, 'l']], "hell":[[4, 'o']]}
	 * 
	 * 
	 * During search, generate the keys as in step 1. 
	 * When we see there's pair of same index but different char in the value array,
	 *  we know the answer is true. e.g.
		"healo" when remove a, key is "helo" and there is a pair [2, 'l'] which has same index but different char.
 		Then the answer is true;
	 */
	 static Map<String, List<int[]>> map = new HashMap<>();
	 
	 
	public static void main(String[] args) {
		
		buildDict(new String[] {"hello"});
		System.out.println("----------");
		boolean ans=search("hhllo");
		
		System.out.println("ans "+ans);
	}
	public static void buildDict(String[] dictionary) {
		for (String s : dictionary) {
            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(0, i) + s.substring(i + 1);
                System.out.println("key "+key);
                /*we are storing index because in key there is only string
                 * this will become usefull when searching
                 * as eg : hllo present key ,
                 * will get pair : [1,e]
                 * same index is replaced and the char dont match hence true
                 * 
                 */
                int[] pair = new int[] {i, s.charAt(i)};
                System.out.println("c "+s.charAt(i));
                /*we will get only when the key is same but the replace character is diff
                 * eg : hello and hfllo for this we will get already inserted keys
                 * 
                 * hllo,hllo
                 * but pair will be different ,[1,e] and [1,f]
                 */
                List<int[]> val = map.getOrDefault(key, new ArrayList<int[]>());
                val.add(pair);
                
                map.put(key, val);
            }
            System.out.println("---------------");
        }
	}
	

	public static boolean search(String word) {
		
		  for (int i = 0; i < word.length(); i++) {
	            String key = word.substring(0, i) + word.substring(i + 1);
	            if (map.containsKey(key)) {
	                for (int[] pair : map.get(key)) {
	                    if (pair[0] == i && pair[1] != word.charAt(i)) return true;
	                }
	            }
	        }
	        return false;
	}
	
	public static void traverse(Map<Character,TrieNode>map)
	{
		for(char c:map.keySet())
			System.out.print(c+" ");
		System.out.println();
	}

}
