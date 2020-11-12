package JavaConcepts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueUsingComparator {

	public static void main(String[] args) {
		
		List<Student> al = new ArrayList<>(); 
		  
        // create customer objects using constructor initialization 
        Student obj1 = new Student("Ajay", 27); 
        Student obj2 = new Student("Sneha", 23); 
        Student obj3 = new Student("Simran", 37); 
        Student obj4 = new Student("Ajay", 22); 
        Student obj5 = new Student("Ajay", 29); 
        Student obj6 = new Student("Sneha", 22); 
  
        // add customer objects to ArrayList 
        al.add(obj1); 
        al.add(obj2); 
        al.add(obj3); 
        al.add(obj4); 
        al.add(obj5); 
        al.add(obj6); 
        
        PriorityQueue<Student>pq=new PriorityQueue<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				
				if(o1.Age>o2.Age)
					return 1;
				
				if(o1.Age<o2.Age)
					return -1;
				return 0;
			}
        	
        	
		});
        for(Student i:al)
        	pq.add(i);
        
        
        while (!pq.isEmpty()) 
        System.out.println(pq.poll().Age); 
  
	}
}
