package com.dee.jpa.hibernate.model.collection;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author dien.nguyen
 */

@Embeddable
public class AddressMapModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Column(name = "address_detail")
    private String address;
    
    public AddressMapModel() {
    }
    
    public AddressMapModel(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
