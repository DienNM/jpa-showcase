package com.dee.jpa.hibernate.compoundprimary.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author dien.nguyen
 **/

@Embeddable
public class PeopleId2 implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "country_name")
    private String country;
    
    @Column(name = "identifier")
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
        if(!(obj instanceof PeopleId2)) {
            return false;
        }
        
        PeopleId2 people = (PeopleId2) obj;
        return people.getCountry().equals(this.country) && people.getId().equals(this.id);
    }
    
    @Override
    public int hashCode() {
        int result = (this.country == null ? 0 : this.country.hashCode());
        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        
        return result;
    }

}
