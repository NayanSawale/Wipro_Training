package com.liststackqueue;

import java.util.LinkedList;

public class ShoppingCart {
    private LinkedList<String> cart;

    public ShoppingCart() {
        cart = new LinkedList<>();
    }

    public void addItem(String item) {
        cart.add(item);
        System.out.println(item + " added to the cart.");
    }

    public void removeItem(String item) {
        if (cart.remove(item)) {
            System.out.println(item + " removed from the cart.");
        } else {
            System.out.println(item + " not found in the cart.");
        }
    }

    public void viewItems() {
        if (cart.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Cart items: " + cart);
        }
    }

    public LinkedList<String> getItems() {
        return new LinkedList<>(cart);
    }

    public void clearCart() {
        cart.clear();
    }
}
