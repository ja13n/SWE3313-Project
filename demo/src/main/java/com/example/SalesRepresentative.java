/**
 * Sales Reperesentative class that represents a sales rep
 * @author Braden Carthron
 */

package com.example;

public class SalesRepresentative {
    private int salesRepID;
    private ContactInformation contactInfo;

    /**
     * Sales Representative Constructor with all fields as parameters
     * @param salesRepID the unique ID for each sales rep
     * @param contactInfo the contact info for each sales rep
     */
    public SalesRepresentative(int salesRepID, ContactInformation contactInfo) {
        this.salesRepID = salesRepID;
        this.contactInfo = contactInfo;
    }

    /**
     * returns the salesrep's ID
     * @return salesrepID
     */
    public int getSalesRepID() {
        return salesRepID;
    }

    /**
     * returns the contact information of the sales rep
     * @return contactInformation
     */
    public ContactInformation getContactInformation() {
        return contactInfo;
    }
}