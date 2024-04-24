package com.example;

import java.util.ArrayList;

public class CustomerDatabase
{
    private ArrayList<Customer> listOfCustomers;
    
    public CustomerDatabase()
    {
        listOfCustomers = new ArrayList<Customer>();
    }


    public void addCustomer(Customer customer)
    {
        listOfCustomers.add(customer);
    }

    public void addCustomer(int customerID, String companyName, boolean loadingDock, String deliveryHours, String email, String phoneNumber)
    {
        ContactInformation contactinfo = new ContactInformation(email, phoneNumber);
        Customer customer = new Customer(customerID, companyName, contactinfo, loadingDock, deliveryHours);
        addCustomer(customer);
    }
   
    public void removeCustomer(Customer customer)
    {
        listOfCustomers.remove(customer);
    }
    
    public ArrayList<Customer> getlistofCustomers()
    {
        return listOfCustomers;
    }

}
