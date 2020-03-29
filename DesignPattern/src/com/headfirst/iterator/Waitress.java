package com.headfirst.iterator;

import java.util.List;

public class Waitress {
    List<Menu> menuList;

    public Waitress(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void printMenu(){
        for(Menu menu :menuList) {
            Iterator<MenuItem> iterator = menu.createIterator();
            printMenu(iterator);

        }
    }

    private void printMenu(Iterator<MenuItem> iterator){
        while(iterator.hasNext()){
            MenuItem item = iterator.next();
            System.out.print(item.getName()+", ");
            System.out.print(item.getDescription()+" --- ");
            System.out.println(item.getPrice()+";");
        }
    }
}
