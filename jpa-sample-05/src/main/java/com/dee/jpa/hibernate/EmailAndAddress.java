package com.dee.jpa.hibernate;

/**
 * @author dien.nguyen
 **/

public class EmailAndAddress {
    
    private String email;
    
    private String address;
    
    public EmailAndAddress() {
    }
    
    public EmailAndAddress(String email, String address) {
        this.email = email;
        this.address = address;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
