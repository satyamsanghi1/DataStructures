package algoExpert;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LRUCacheRunner2 {

	public static void main(String[] args) {


	}
	class LRUCache
	{
		private LinkedHashMap<Integer, Integer> map;
		
		//final because in anonymous class can be accessed
		private final int CAPACITY;
		public LRUCache(int capacity) {
			CAPACITY = capacity;
			map = new LinkedHashMap<Integer, Integer>(CAPACITY,0.75f, true){

				@Override
				protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
					
					return size()>CAPACITY;
				}
				
				
			};
			
		}
		public int get(int key) {
			return map.getOrDefault(key, -1);
		}
		public void set(int key, int value) {
			map.put(key, value);
		}
	}





}
