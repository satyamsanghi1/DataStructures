package graphs;

import java.util.List;

public class _841_KeysAndRooms {
	
	
	public static void main(String[] args) {
		
		
		
	}
	 public boolean canVisitAllRooms(List<List<Integer>> rooms) {
	        
	        boolean[]seen=new boolean[rooms.size()];
	        
	        
	     
	            
	            seen[0]=true;
	            
	                dfs(rooms,0,seen);
	         
	        for(boolean a:seen)
	        {
	            if(!a)
	                return false;
	            
	        }
	        return true;
	    }

	    public void dfs(List<List<Integer>> rooms,int idx,boolean[]seen)
	    {
	        
	        for(int k:rooms.get(idx))
	        {
	        if(seen[k])
	            continue;
	            
	            seen[k]=true;
	        
	            dfs(rooms,k,seen);
	        }
	    }

}
