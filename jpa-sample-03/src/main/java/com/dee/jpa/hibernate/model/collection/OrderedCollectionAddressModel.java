package com.dee.jpa.hibernate.model.collection;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author dien.nguyen
 **/

@Embeddable
public class OrderedCollectionAddressModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Column(name = "address_city")
    private String city;

    @Column(name = "address_detail")
    private String address;
    
    public OrderedCollectionAddressModel() {
    }
    
    public OrderedCollectionAddressModel(String city, String address) {
        this.city = city;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
