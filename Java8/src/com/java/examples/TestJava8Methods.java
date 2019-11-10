package com.java.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestJava8Methods{

    private static List<Employee> employeeList = DummyDataGenerator.getEmployeeList();

    public static void main(String[] args) {


//        filterTest(employeeList);
//        distinctTest(employeeList);
//        skipLimitTest();
//        sortedTest();
//        noneMatchTest();
//        allMatchTest();
//        findAnyTest();
//        collectTest();
//        reduceTest();
//        countTest();
        orElseTest();
    }


    private static void orElseTest(){
        System.out.println("-------------------------------------------------------------");
        System.out.println(new ArrayList<Employee>().stream().mapToInt(Employee::getAge).max().orElse(-1));
        System.out.println("-------------------------------------------------------------");
    }
    private static void countTest(){
        System.out.println("-------------------------------------------------------------");
        System.out.println(employeeList.stream().count());
        System.out.println("-------------------------------------------------------------");
    }
    private static void reduceTest(){
        System.out.println("-------------------------------------------------------------");
        System.out.println(employeeList.stream().map(Employee::getAge).reduce(-1,(age,age1) -> age+age1));
        System.out.println("-------------------------------------------------------------");
    }
    private static void collectTest(){
        System.out.println("-------------------------------------------------------------");
        employeeList.stream().filter(e -> e.getManager() != null).collect(Collectors.toSet()).forEach(e -> System.out.println(e));
        System.out.println("-------------------------------------------------------------");
    }
    private static void findAnyTest(){
        System.out.println("-------------------------------------------------------------");
        System.out.println(employeeList.stream().filter(e -> e.getManager() != null).findAny().get());
        System.out.println("-------------------------------------------------------------");
    }
    private static void allMatchTest(){
        System.out.println("-------------------------------------------------------------");
        System.out.println(employeeList.stream().skip(1).allMatch(e -> {
            if(null == e || null == e.getManager())
                return false;

            return e.getManager().getFirstName().equals("Radha");
        }));
        System.out.println("-------------------------------------------------------------");
    }
    private static void noneMatchTest(){
        System.out.println("-------------------------------------------------------------");
        System.out.println(employeeList.stream().skip(0).noneMatch(e -> e.getDesignation().equals("VP")));
        System.out.println("-------------------------------------------------------------");
    }
    private static void anyMatchTest(){
        System.out.println("-------------------------------------------------------------");
        System.out.println(employeeList.stream().anyMatch(e -> e.getDesignation().equals("VP")));
        System.out.println("-------------------------------------------------------------");
    }
    private static void sortedTest(){
        System.out.println("-------------------------------------------------------------");
        employeeList.stream().sorted((e1,e2) -> e1.getAge() - e2.getAge()).forEach(employee -> {
            System.out.println(employee);
        });
        System.out.println("-------------------------------------------------------------");
    }
    private static void skipLimitTest(){
        System.out.println("-------------------------------------------------------------");
        employeeList.stream().skip(1).limit(employeeList.size()-2).forEach( employee -> {
            System.out.println(employee);
        });
        System.out.println("-------------------------------------------------------------");
    }
    private static void filterTest(){
        System.out.println("-------------------------------------------------------------");
        employeeList.stream().filter( employee -> employee.getManager() == null).forEach( employee -> {
            System.out.println(employee);
        });
        System.out.println("-------------------------------------------------------------");
    }
    private static void distinctTest(){
        System.out.println("-------------------------------------------------------------");
        employeeList.stream().filter(distinctByKey(Employee::getDesignation)).forEach(employee -> {
            System.out.println(employee);
        });
        System.out.println("-------------------------------------------------------------");
//        System.out.println("Order in not maintained in this.");
        employeeList.stream().collect(Collectors.toMap(Employee::getDesignation, e -> e, (o, n) -> o )).values().forEach(employee -> {
            System.out.println(employee);
        });
        System.out.println("-------------------------------------------------------------");
    }
    private static <T,E> Predicate<T> distinctByKey(Function<T, E> fun){
        Map<E, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
        return (t) -> concurrentHashMap.putIfAbsent(fun.apply(t), Boolean.TRUE) == null;
    }

}
