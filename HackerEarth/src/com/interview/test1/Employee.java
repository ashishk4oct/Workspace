package com.interview.test1;

public class Employee {

    private String name;
    private String userName;
    private int age;
    private String department;
    private String designation;
    private String empId;

    public Employee(String name, String userName, int age) {
        this.name = name;
        this.userName = userName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Employee)){
            return false;
        }
        Employee e = (Employee)obj;

        return  e.getUserName().equalsIgnoreCase(this.userName);
    }
}
