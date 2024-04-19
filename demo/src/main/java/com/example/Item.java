package com.example;

public class Item {
    private int itemID;
    private String itemName;
    private double price;


    public Item(int itemID, String itemName, double price)
    {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
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
}
