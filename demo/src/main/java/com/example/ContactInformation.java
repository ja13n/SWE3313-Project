package com.example;

public class ContactInformation {
    private String email, phoneNumber;
    public ContactInformation(String email, String phoneNumber)
    {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
