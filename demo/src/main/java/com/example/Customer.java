package com.example;

/**
 * Business object class for the customer.
 * @author ja13n
 **/

import java.sql.*;
import java.util.ArrayList;

public class Customer {

    private int customerID; // ID of the customer
    private String companyName; // Company name
    private ContactInformation contactInfo; // contact information
    private boolean loadingDock; // Whether loading doc is available to customer
    private String deliveryHours; // Hours in which deliveries are accepted
    private String email;
    private String phone;

    /**
     * Customer contructor class
     * 
     * @param customerID,    holds the ID of the customer.
     * @param companyName,   holds he name of the company.
     * @param contactinfo,   holds the customer contact information.
     * @param loadingDock,   contains whether or not the customers order is in the
     *                       loading dock.
     * @param deliveryHours, contains the hours of delivery.
     **/
    public Customer(int customerID, String companyName, ContactInformation contactinfo, boolean loadingDock,
            String deliveryHours) {
        this.customerID = customerID;
        this.companyName = companyName;
        this.contactInfo = contactinfo;
        this.loadingDock = loadingDock;
        this.deliveryHours = deliveryHours;
        this.email = contactinfo.getEmail();
        this.phone = contactinfo.getPhoneNumber();
    }

    /*
     * Empty customer class.
     */
    public Customer() {

    }

    /**
     * 
     * @param customerID
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void selectDB(int customerID) throws SQLException, ClassNotFoundException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        try (Connection connection = DriverManager.getConnection("")) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Students WHERE ID = " + customerID);
            rs.next();
            this.customerID = rs.getInt(1);
            this.companyName = rs.getString(2);
        }
    }

    /**
     * Method that returns customerID
     * 
     * @return customerID
     */
    public int getCustomerID() {
        return this.customerID;
    }

    /**
     * Method that returns companyName
     * 
     * @return companyName
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * Method that returns the customers contact information.
     * 
     * @return contactInfo
     */
    public ContactInformation getContactInfo() {
        return this.contactInfo;
    }

    /**
     * Method returns true or false if customer order is in the loading dock.
     * 
     * @return loadingDock
     */
    public boolean hasLoadingDock() {
        return this.loadingDock;
    }

    /**
     * Method that returns the delivery hours.
     * 
     * @return deliveryHours
     */
    public String getDeliveryHours() {
        return this.deliveryHours;
    }

    @Override
    public String toString() {
        return customerID + ", " + companyName + ", " + email + ", " + phone;
    }
}