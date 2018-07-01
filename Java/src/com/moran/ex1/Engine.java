package com.moran.ex1;

import java.util.HashSet;
import java.util.Set;

public class Engine {

	private static Set<Employee> employee = new HashSet<>();
	
	public static void main(String[] args) {

		Employee e1 = new Employee(1, "e1", null);
		Employee e2 = new Employee(2, "e2", e1);
		Employee e3 = new Employee(3, "e3", e1);
		Employee e4 = new Employee(4, "e4", e2);
		Employee e5 = new Employee(5, "e5", e2);
		Employee e6 = new Employee(6, "e6", e3);
	
		employee.add(e1);
		employee.add(e2);
		employee.add(e3);
		employee.add(e4);
		employee.add(e5);
		employee.add(e6);

		findDirectOrIndirectReportee(e1);
		
		
		
	}

	private static void findDirectOrIndirectReportee(Employee e1) {
		Set<Employee> reportee = new HashSet<>();
		reportee.add(e1);
		for (Employee emp : employee) {
			if(reportee.contains(emp.manager)) {
				reportee.add(emp);
			}
		}
		reportee.remove(e1);
		addReportee(reportee);
		
		for (Employee e : reportee) {
			System.out.println(e.name);
		}
	}

	private static void addReportee(Set<Employee> reportee) {
		int size = reportee.size();
		for (Employee emp : employee) {
			if(reportee.contains(emp.manager)) {
				reportee.add(emp);
			}
		}
		if(size < reportee.size()) {
			addReportee(reportee);
		}
	}

}
