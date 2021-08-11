package StreamsAPIExamples.nonTerminalOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Employee
{
String name;
Integer EmployeeId;


}
public class SortedExample {

	public static void main(String[] args) {
		
		
		List<Integer>list=Arrays.asList(1,6,7,8,5,4,6,8,9);
		list.stream().sorted();
		
		
		List<Employee>empList=new ArrayList();
		empList.stream().sorted(Comparator.comparing(emp->emp.EmployeeId)).forEach(System.out::println);
	
	
	}
}

