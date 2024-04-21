package com.example;


import java.util.ArrayList;

public class Order {

    private int orderID;
    private ArrayList<Item> itemsList;
    

    public Order(int orderID)
    {
        this.orderID = orderID;
        itemsList = new ArrayList<Item>();
    }

    public void addItem(Item item)
    {
        itemsList.add(item);
    }

    public void removeItem(Item item)
    {
        itemsList.remove(item);
    }

    public ArrayList<Item> getItemsList() 
    {
        return itemsList;
    }

    public int getOrderID() 
    {
        return orderID;
    }

    public double calculateTotalPrice()
    {
        double total = 0;
        for (int i = 0; i < itemsList.size(); i++) {
            total += itemsList.get(i).getPrice();
        }
        return total;
    }

}
