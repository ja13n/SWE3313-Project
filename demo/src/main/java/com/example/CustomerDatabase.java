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
   
    public void removeCustomer(Customer customer)
    {
        listOfCustomers.remove(customer);
    }
    
    public ArrayList<Customer> getlistofCustomers()
    {
        return listOfCustomers;
    }

}
