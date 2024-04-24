/**
 * The order class represents an order being taken
 */

package com.example;


import java.util.ArrayList;

public class Order {

    private int orderID;
    private ArrayList<Item> itemsList = new ArrayList<>();
    
/**
 * Order constructor with orderId as a parameter
 * @param orderID the unique ID for each order
 */
    public Order(int orderID)
    {
        this.orderID = orderID;
    }

    public Order () {

    }

    /**
     * adds an item to the order
     * @param item item to be added
     */
    public void addItem(Item item)
    {
        itemsList.add(item);
    }

    /**
     * removes an item from the order
     * @param item item to be removed
     */
    public void removeItem(Item item)
    {
        itemsList.remove(item);
    }

    /**
     * returns the list of the order
     * @return itemslist
     */
    public ArrayList<Item> getItemsList() 
    {
        return itemsList;
    }

    /**
     * returns the orderID
     * @return orderID
     */
    public int getOrderID() 
    {
        return orderID;
    }

    /**
     * calculates the total price of the order
     * @return total
     */
//    public double calculateTotalPrice()
//    {
//        double total = 0;
//        for (int i = 0; i < itemsList.size(); i++) {
//            total += itemsList.get(i).getPrice();
//        }
//        return total;
//    }

}
