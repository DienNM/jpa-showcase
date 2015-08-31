package com.dee.jpa.hibernate.compoundprimary.idclass;

import java.io.Serializable;

/**
 * @author dien.nguyen
 **/

public class PeopleId1 implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String country;
    private String id;
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
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof PeopleId1)) {
            return false;
        }
        
        PeopleId1 people = (PeopleId1) obj;
        return people.getCountry().equals(this.country) && people.getId().equals(this.id);
    }
    
    @Override
    public int hashCode() {
        int result = (this.country == null ? 0 : this.country.hashCode());
        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        
        return result;
    }

}
