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

    // 스트림을 이용한 아이템 제거
    public void removeItem(String itemName) {
        items.stream()
                .filter(item -> item.getName().equals(itemName)) // itemName 매개변수와 동일한 아이템 필터
                .findFirst() // 같은 이름의 첫 번째 아이템
                .ifPresent(item -> items.remove(item)); // 존재할 경우에 리스트에서 제거!
    }
}
