package com.dee.jpa.hibernate.model;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * @author dien.nguyen
 **/

@Entity(name = "user_jpa_1")
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private String firstName;
    
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
