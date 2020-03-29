package com.headfirst.iterator;

import java.util.Arrays;

public class MenuTest {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinnerMenu dinnerMenu = new DinnerMenu();

        Waitress waitress = new Waitress(Arrays.asList(new Menu[]{pancakeHouseMenu,dinnerMenu}));

        waitress.printMenu();
    }
}
