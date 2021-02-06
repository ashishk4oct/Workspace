package com.interview.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        List<User> users = getUsersList();
        List<SuggestBy> orderByList = new ArrayList<>();

        orderByList.add(new SuggestByGender());
        orderByList.add(new SuggestByAge());
        orderByList.add(new SuggestByHobbies());

        User user = new User("Vikas" , "Male", 32, Arrays.asList(new String[] {"bowling", "cricket"}));

        SuggessionsEngine suggessionsEngine = new SuggessionsEngine(orderByList);

        suggessionsEngine.performOrderingFixed(users, user).forEach( ( u ) -> {
            System.out.println(u.getName());
        });

    }

    private static List<User> getUsersList() {
        List<User> users = new ArrayList<>();

        User u = new User("Neha" , "Female", 21 , Arrays.asList(new String[] {"Singing", "dancing"}));
        users.add(u);
        u = new User("Pooja" , "Female", 23, Arrays.asList(new String[] {"painting", "badminton"}));
        users.add(u);
        u = new User("Nikita" , "Female", 26, Arrays.asList(new String[] {"ludo", "chess"}));
        users.add(u);
        u = new User("Kiran" , "Male", 29, Arrays.asList(new String[] {"badminton", "chess"}));
        users.add(u);
        u = new User("Uday" , "Male", 23, Arrays.asList(new String[] {"cricket", "programming"}));
        users.add(u);

        return users;
    }


}
