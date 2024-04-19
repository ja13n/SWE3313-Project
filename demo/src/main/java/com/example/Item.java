package com.example;

public class Item {
    private int itemID;
    private String itemName;
    private double price;
    private int quantity;

    public Item(int itemID, String itemName, double price, int quantity)
    {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getItemID() {
        return itemID;
    }
    public String getItemName() {
        return itemName;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}
