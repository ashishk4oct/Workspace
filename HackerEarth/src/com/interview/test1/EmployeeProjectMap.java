package com.interview.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeProjectMap {

    Map<Employee, List<String>> employeemap = new HashMap<>();

    EmployeeProjectMap() {

    }

    public boolean addMappings(Employee e, String project) {
        List<String> projects = employeemap.get(e);
        if (!employeemap.containsKey(e)) {
            projects = new ArrayList<String>();
            employeemap.put(e, projects);
        }

        if (!projects.contains(project)) {
            projects.add(project);
            return true;
        }

        return false;
    }

    public List<String> getMapping(Employee e) {
        return employeemap.get(e);
    }

}