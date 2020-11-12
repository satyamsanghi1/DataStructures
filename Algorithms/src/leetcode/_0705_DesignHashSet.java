package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

class MyHashSet {
// should not use these data structures , but to use proper implementation of HashSet working internally
    /** Initialize your data structure here. */
    private int set[]=new int[1000000];
    TreeSet tree=new TreeSet();
    
    public MyHashSet() {
    	Arrays.fill(this.set,-1);	
    }
    
    public void add(int key) {
        
    	set[key]=1;
    	tree.add(key);
    }
    
    public void remove(int key) {
        
    	set[key]=-1;
    	tree.remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
    
    	if(set[key]==-1)
    		return false;
    	return true;
    }
}

public class _0705_DesignHashSet {

	public static void main(String[] args) {
	
		MyHashSet s=new MyHashSet();
		s.add(1);
		System.out.println(s.contains(2));
	}

}
