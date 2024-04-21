/**
 * class that represents the contact information
 * @author Braden Carthron
 */

package com.example;

public class ContactInformation {
    private String email, phoneNumber;

    /**
     * Contact Information with all fields as parameters
     * @param email the email associated with the contact
     * @param phoneNumber the phone number associated with the contact
     */
    public ContactInformation(String email, String phoneNumber)
    {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * returns the email of the contact information
     * @return email
     */

    public String getEmail() {
        return email;
    }

    /**
     * returns the phoneNumber of the contact information
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

}
