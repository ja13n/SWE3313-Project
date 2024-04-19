package com.example;


import java.util.LinkedList;

public class Order {

    private int orderID;
    private LinkedList<Item> itemslist;
    

    public Order(int orderID)
    {
        this.orderID = orderID;
        itemslist = new LinkedList<Item>();

        
    }
}
