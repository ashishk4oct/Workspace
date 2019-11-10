package com.java.examples;

import java.util.ArrayList;
import java.util.List;

public class DummyDataGenerator {

    public static List<Employee> getEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();
        Employee radha = getEmpoyee("Radha", "Krishna", 40, "VP", "vp1", null );
        employeeList.add(radha);
        employeeList.add(getEmpoyee("Vipul", "Gairi", 33, "Senior Manager", "sm1", radha ));
        employeeList.add(getEmpoyee("Deepak", "Atrey", 31, "Senior Manager", "sm2", radha ));
        employeeList.add(getEmpoyee("Ashish", "Kumar", 27, "Senior Associate", "sa1", radha ));

        return employeeList;
    }

    private static Employee getEmpoyee(String firstName, String lastName, int age, String designation, String id, Employee manager){
        Employee employee = new Employee(id);

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setDesignation(designation);
        employee.setManager(manager);

        return employee;
    }
}
