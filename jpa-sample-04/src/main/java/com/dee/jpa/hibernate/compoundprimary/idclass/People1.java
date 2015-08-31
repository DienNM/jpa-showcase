package com.dee.jpa.hibernate.compoundprimary.idclass;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "people_1")
@IdClass(PeopleId1.class)
public class People1 implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    private String country;
    @Id
    private String id;
    
    private String name;
    
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
