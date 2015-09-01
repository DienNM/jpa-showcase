package com.dee.jpa.hibernate;

/**
 * @author dien.nguyen
 **/

public class PhoneAggregate {
    
    private String email;
    
    private int totalPhones;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotalPhones() {
        return totalPhones;
    }

    public void setTotalPhones(int totalPhones) {
        this.totalPhones = totalPhones;
    }
    
}
