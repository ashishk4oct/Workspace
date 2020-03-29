package com.whatfix;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SuggessionsEngine {

    List<SuggestBy> orderBy;

    SuggessionsEngine(List<SuggestBy> orderBy){
        this.orderBy  = orderBy;
    }

    public void performOrdering(List<User> users, User user) {
        for (SuggestBy ob : orderBy) {
            ob.order(users);
        }
    }


    public List<User> performOrderingFixed(List<User> users, User user) {

        for(User u : users){
            int number = generateNumber(user,u);
            u.setNum(number);
        }

        Collections.sort(users);

        return users;
    }

    private int generateNumber(User user, User u) {

        String number = "";

        if(user.getGender() != u.getGender()){
            number += "1";
        }else{
            number += "2";
        }

        int ageDiff = Math.abs(u.getAge()-user.getAge());
        int len = 3-(ageDiff+"").length();

        for (int i = 0; i < len; i++) {
            number += "0";
        }
        number += ageDiff;

        number += generateHobbiesNumber(u.getHobbies(), user.getHobbies());

        return Integer.valueOf(number);
    }

    private int generateHobbiesNumber(List<String> hobbies, List<String> hobbies1) {

        int matchCount = 0;

        for (String h : hobbies) {
            for (String h1 : hobbies1) {
                if(h1.equalsIgnoreCase(h)){
                    matchCount++;
                }
            }
        }

        return 3-matchCount;

    }


}

