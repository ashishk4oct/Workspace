package com.interview.test1;

public class TestEmployee {

    public static void main(String[] args) {
        EmployeeProjectMap employeeProjectMap = new EmployeeProjectMap();

        Employee e = new Employee("Ashish", "ashi", 29);
        Employee e1 = new Employee("Ravi", "rav", 29);

        employeeProjectMap.addMappings(e,"Pro1");
        employeeProjectMap.addMappings(e,"Pro2");

        employeeProjectMap.addMappings(e1,"Project1");
        employeeProjectMap.addMappings(e1,"Pro2");


        for (String s : employeeProjectMap.getMapping(e)) {
            System.out.println(s);
        }


    }
}
