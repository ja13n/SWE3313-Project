/**
 * The item class represents an item
 * @author Braden Carthron
 */


 package com.example;

 import java.sql.*;
 import java.util.ArrayList;
 
 public class Item {
     private int itemID;
     private String itemName;
     private int quantity;
     private ArrayList<Item> items = new ArrayList<>();
 
     /**
      * Item constructor with all fields as parameters
      * @param itemID The unique id for the item
      * @param itemName the name of the item
      * @param quantity the quantity of said item
      */
     public Item(int itemID, String itemName, int quantity)
     {
         this.itemID = itemID;
         this.itemName = itemName;
         this.quantity = quantity;
     }
 
     public Item(){
 
     }
 
     public void getItemsDB() throws ClassNotFoundException {
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
 
         String sql = "SELECT ProductID, EPD, OnHand FROM Inventory WHERE OnHand != 0 AND EPD !=\"null\"LIMIT 300";
         try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Inventory/Inventory.mdb")) {
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()) {
                 this.items.add(new Item(rs.getInt("ProductID"), rs.getString("EPD"), rs.getInt("OnHand")));
             }
 
 
 
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
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
 
     /**
      * returns the quantity
      * @return
      */
 
     public int getQuantity() {
         return quantity;
     }
 
     public void setQuantity(int quantity) {
         this.quantity = quantity;
     }
     public ArrayList<Item> getItems() {
         return this.items;
     }
 
     public static void main(String[] args) throws ClassNotFoundException {
         Item item = new Item();
         item.getItemsDB();
         for (Item i: item.items) {
             System.out.println(i.getItemName());
 
         }
     }
 }