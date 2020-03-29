package com.headfirst.iterator;

import java.util.ArrayList;

public class PancakeHouseMenu implements Menu{

    ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        this.menuItems = new ArrayList<>();

        addItem("Name-A", "Description-a", true, 2.9);
        addItem("Name-AB", "Description-ab", true, 12.19);
        addItem("Name-ABC", "Description-abc", true, 22.9);
        addItem("Name-ABCD", "Description-abcd", true, 32.9);
    }

    @Override
    public PancakeHouseMenuIterator createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        this.menuItems.add(new MenuItem(name, description, vegetarian, price));
    }


    // other menu methods here
    // loots of code depend on ArrayList implementation which he doesn't want to rework
}
