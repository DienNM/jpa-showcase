package com.dee.jpa.hibernate.model.many2many;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "m2m_order")
public class OrderModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private double total;
    
    @OneToMany(mappedBy = "order")
    private List<OrderEntryModel> orderEntries = new ArrayList<OrderEntryModel>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<OrderEntryModel> getOrderEntries() {
        return orderEntries;
    }

    public void setOrderEntries(List<OrderEntryModel> orderEntries) {
        this.orderEntries = orderEntries;
    }

}
