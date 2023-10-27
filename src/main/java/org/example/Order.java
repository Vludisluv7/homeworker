package org.example;

public class Order {
    private String description; // Поле для описания заказа

    public Order(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
