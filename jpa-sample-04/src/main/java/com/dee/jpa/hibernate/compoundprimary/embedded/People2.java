package com.dee.jpa.hibernate.compoundprimary.embedded;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "people_2")
public class People2 implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    @AttributeOverrides(value = {
            @AttributeOverride(name = "country", column = @Column(name = "country_code")),
            @AttributeOverride(name = "id", column = @Column(name = "identifier_number"))
    })
    private PeopleId2 id;
    
    private String name;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public PeopleId2 getId() {
        return id;
    }
    public void setId(PeopleId2 id) {
        this.id = id;
    }
    
}
