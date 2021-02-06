package com.java.streams.exceptionhandling;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Sample1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("asdh");
        list.add("ashi");
        list.add("as");
        list.forEach( s -> {
            if(s.length() > 2)
                return;
            System.out.println(s+" Success");
        });
    }

}

interface A{

}
