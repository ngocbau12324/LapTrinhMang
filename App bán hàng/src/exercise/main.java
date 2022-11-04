package exercise;

import java.util.*;
import exercise.employee;
public class main {
	public static List<employee> employees = new ArrayList<employee>();
	public static void main(String[] args) {
		employees.add(new employee("A", "123", 20));
		employees.add(new employee("A", "123", 20));
		employees.add(new employee("A", "123", 20));
		employees.add(new employee("A", "123", 20));
		employee.inputEmployee();
		
	}

}
