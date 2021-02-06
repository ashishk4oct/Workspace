package com.interview.informatica;

import com.util.RandomUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1 {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        for (int i : RandomUtil.generateRandom(20, 0, 15)) {
            lines.add(i+"");
            System.out.print(" "+i);
        }
        System.out.println();
        String text = "4";
        int context = 4;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lines.size() ; i++) {
            if(lines.get(i).equalsIgnoreCase(text)){
                list.add(i);
            }
        }

        Set<String> set = new HashSet<>();
        int pointer = 0;
        for (Integer i : list){
            pointer = (i-context) > pointer ? i-context : pointer;
            for (; pointer <= i ; pointer++) {
                if(!set.contains(lines.get(pointer))){
                    System.out.print(" "+lines.get(pointer));
                    set.add(lines.get(pointer));
                }
            }
            for ( ; pointer <= i+context && pointer < lines.size() ; pointer++){
                if(!set.contains(lines.get(pointer))){
                    System.out.print(" "+lines.get(pointer));
                    set.add(lines.get(pointer));
                }
            }
        }

    }
}
