package JavaConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class AgeComparator implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
class Student { 
	  
    // instance member variables 
    String Name; 
    int Age; 
  
    // parameterized constructor 
    public Student(String Name, Integer Age) { 
        this.Name = Name; 
        this.Age = Age; 
    } 
  
    public String getName() { 
        return Name; 
    } 
  
    public void setName(String Name) { 
        this.Name = Name; 
    } 
  
    public Integer getAge() { 
        return Age; 
    } 
  
    public void setAge(Integer Age) { 
        this.Age = Age; 
    } 
  
    // overriding toString() method 
    @Override
    public String toString() { 
        return "Customer{" + "Name=" + Name + ", Age=" + Age + '}'; 
    }  
}
public class ImplementingComparator {
	
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
       
       
        Collections.sort(al,new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				
				int nameCompare=o1.Name.compareTo(o2.Name);
				int ageCompare=o1.getAge().compareTo(o2.getAge());
				System.out.println("age "+ageCompare);
				System.out.println(nameCompare);
				
				if(nameCompare==0)
				{
					return ageCompare;
				}
				else
				return nameCompare;
			}
        	
        	
		});
     
		for(Student i:al)
			System.out.println(i);
	}

}
