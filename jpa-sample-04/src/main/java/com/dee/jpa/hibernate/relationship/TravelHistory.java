package com.dee.jpa.hibernate.relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "traveller_history")
public class TravelHistory implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "country")
    private String country;
    
    @Id
    @Column(name = "city_name")
    private String city;
    
    private String address;
    
    @ManyToMany
    @JoinTable(name = "traveller_owner", joinColumns = {
            @JoinColumn(name = "country", referencedColumnName = "country"),
            @JoinColumn(name = "city_name", referencedColumnName = "city_name")
    }, inverseJoinColumns = {@JoinColumn(name = "id")})
    private List<Traveller> travallers = new ArrayList<Traveller>();

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public List<Traveller> getTravallers() {
        return travallers;
    }

    public void setTravallers(List<Traveller> travallers) {
        this.travallers = travallers;
    }

}
