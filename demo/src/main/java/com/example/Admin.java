package com.example;

public class Admin {
    private int adminID;
    private ContactInformation contactInfo;
    private String department;



    public Admin(int adminID, ContactInformation contactInfo, String department)
    {
        this.adminID = adminID;
        this.contactInfo = contactInfo;
        this.department = department;
    }

    public int getAdminID() {
        return adminID;
    }

    public ContactInformation getContactInfo() {
        return contactInfo;
    }

    public String getDepartment() {
        return department;
    }

    

}
