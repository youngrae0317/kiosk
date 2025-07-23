package org.example.c_lv2;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double price = 0.0;
        for (MenuItem item : items) {
            price += item.getPrice();
        }
        return price;
    }

    public void clearCart() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
