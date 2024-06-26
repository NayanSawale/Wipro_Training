package com.liststackqueue;

import java.util.LinkedList;
import java.util.Stack;

public class PurchaseHistory {
    private Stack<LinkedList<String>> history;

    public PurchaseHistory() {
        history = new Stack<>();
    }

    public void saveCart(LinkedList<String> cart) {
        history.push(new LinkedList<>(cart));
        System.out.println("Cart saved to purchase history.");
    }

    public void undoLastPurchase() {
        if (!history.isEmpty()) {
            LinkedList<String> lastCart = history.pop();
            System.out.println("Last purchase undone: " + lastCart);
        } else {
            System.out.println("No purchase history to undo.");
        }
    }

    public void viewHistory() {
        if (history.isEmpty()) {
            System.out.println("No purchase history.");
        } else {
            System.out.println("Purchase history:");
            for (LinkedList<String> cart : history) {
                System.out.println(cart);
            }
        }
    }
}