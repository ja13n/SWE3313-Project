package com.example;

import java.sql.*;
import com.example.ContactInformation;

public class Customer{

    private int customerID; // ID of the customer
    private String companyName; // Company name 
    private ContactInformation contactInfo; // contact information
    private boolean loadingDock; // Whether loading doc is available to customer
    private String deliveryHours; // Hours in which deliveries are accepted


    // customer constructor
    public Customer(int customerID, String companyName, ContactInformation contactinfo, boolean loadingDock, String deliveryHours) {
        this.customerID = customerID;
        this.companyName = companyName;
        this.contactInfo = contactinfo;
        this.loadingDock = loadingDock;
        this.deliveryHours = deliveryHours;
    }

    // Empty customer constructor
    public Customer(){

    }

    // method to get customer info from database
    public void selectDB(int customerID) throws SQLException, ClassNotFoundException {
        int counter = 0;
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        try (Connection connection = DriverManager.getConnection("")) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Students WHERE ID = " + customerID);
            rs.next();
            this.customerID = rs.getInt(1);
            this.companyName = rs.getString(2);
        }
    }

    // CustomerID getter method
    public int getCustomerID() {return this.customerID;}

    // CompanyName getter method
    public String getCompanyName() {return this.companyName;}

    //Contact info getter method
    public ContactInformation getContactInfo() {return this.contactInfo;}

    // Has Loading dock method (returns true or false)
    public boolean hasLoadingDock() {return this.loadingDock;}

    // Get delivery hours method
    public String getDeliveryHours() {return this.deliveryHours;}
}