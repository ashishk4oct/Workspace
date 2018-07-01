package com.moran.ex1;

/*Write a Program in Java, You have an Employee class |
	class Employee{
	String name;
	Integer id,
	Employee manager
	}
	Each employee has a manager and the manager of CEO is null. Find all direct and indirect reportees of a manager.
	Eg. Say Employee e1 reports to CEO,
	e2 and e3 reports to e1,
	e4 and e5 reports to e2,
	e6 reports to e3.
	Then by giving e1 as input, output should be e2, e3, e4, e5 and e6.
- Anon April 09, 2017 in India | Report Duplicate | Flag */

public class Employee {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	String name;
	Integer id;
	Employee manager;
	
	public Employee(int id, String name, Employee manager) {
		this.id = id;
		this.name = name;
		this.manager = manager;
	}
}
