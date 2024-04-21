/**
 * The item class represents an item
 * @author Braden Carthron
 */


package com.example;

public class Item {
    private int itemID;
    private String itemName;
    private double price;
    private int quantity;

 /**
 * Item constructor with all fields as parameters
 * @param itemID The unique id for the item
 * @param itemName the name of the item
 * @param price the price of the item
 * @param quantity the quantity of said item
 */
    public Item(int itemID, String itemName, double price, int quantity)
    {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
/**
 * returns the item id
 * @return itemID
 */
    public int getItemID() {
        return itemID;
    }
    /**
     * returns the item name
     * @return itemName
     */

    public String getItemName() {
        return itemName;
    }

    /**
     * returns the price
     * @return price
     */

    public double getPrice() {
        return price;
    }

    /**
     * returns the quantity
     * @return
     */

    public int getQuantity() {
        return quantity;
    }
}
