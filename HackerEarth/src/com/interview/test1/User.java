package com.interview.test1;

import java.util.List;

public class User  implements Comparable<User> {

    private String username;
    private String name;
    private int age;

    private int gender;
    private List<String> hobbies;
    private int num = 0;

    public User(String name, String gender, int age,  List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.gender = gender.equalsIgnoreCase("Female")? 1: 2;
        this.hobbies = hobbies;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(User o) {
        return this.getNum()-o.getNum();
    }
}
