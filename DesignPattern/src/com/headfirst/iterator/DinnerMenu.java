package com.headfirst.iterator;

public class DinnerMenu implements Menu {
    static final int MAX_ITEMS = 6;
    int numberOfitems = 0;
    MenuItem[] menuItems;

    public DinnerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("Dinner Name-A", "Description-a", true, 2.9);
        addItem("Dinner Name-AB", "Description-ab", true, 12.19);
        addItem("Dinner Name-ABC", "Description-abc", true, 22.9);
        addItem("Dinner Name-ABCD", "Description-abcd", true, 32.9);
    }

    public DinnerMenuIterator createIterator() {
        return new DinnerMenuIterator(menuItems);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        if (numberOfitems == MAX_ITEMS) {
            System.out.println("Sorry menu item is full! Can not add items to menu");
            return;
        }
        this.menuItems[numberOfitems++] = new MenuItem(name, description, vegetarian, price);
    }

    // other menu methods here
    // loots of code depend on Array implementation which he doesn't want to rework
}