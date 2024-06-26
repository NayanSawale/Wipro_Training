package com.liststackqueue;

public class ShoppingApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        PurchaseHistory history = new PurchaseHistory();
        CustomerService service = new CustomerService();

        // Shopping cart operations
        cart.addItem("Laptop");
        cart.addItem("Mouse");
        cart.addItem("Headphones");
        cart.viewItems();
        cart.removeItem("Mouse");
        cart.viewItems();

        // Purchase history operations
        history.saveCart(cart.getItems());
        cart.addItem("Keyboard");
        cart.viewItems();
        history.saveCart(cart.getItems());
        history.viewHistory();
        history.undoLastPurchase();
        history.viewHistory();

        // Customer service operations
        service.addRequest("Help with Order #001");
        service.addRequest("Return for Order #002");
        service.viewPendingRequests();
        service.processNextRequest();
        service.viewPendingRequests();
    }
}

