package com.dee.jpa.hibernate.relationship.extrastate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "order_")
public class Order implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    private String id;
    
    private int total;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
