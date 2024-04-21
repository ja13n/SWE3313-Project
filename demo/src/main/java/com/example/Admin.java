/**
 * The class admin represents an administrative user
 * @author Braden Carthron
 * 
 */

package com.example;

public class Admin {
    private int adminID;
    private ContactInformation contactInfo;
    private String department;


/**
 * Admin constructor with all fields as parameters
 * @param adminID the unique id for the admin
 * @param contactInfo the contact info of this admin
 * @param department the department of the admin
 */
    public Admin(int adminID, ContactInformation contactInfo, String department)
    {
        this.adminID = adminID;
        this.contactInfo = contactInfo;
        this.department = department;
    }
/**
 * Returns the admin's ID
 * @return admin id
 */
    public int getAdminID() {
        return adminID;
    }
/**
 * returns the contact info of the admin
 * @return contactInfo
 */
    public ContactInformation getContactInfo() {
        return contactInfo;
    }
/**
 * returns the departments of the admin
 * @return department
 */
    public String getDepartment() {
        return department;
    }

    

}
