package com.dee.jpa.hibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "order_1")
public class OrderModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int totalPrice;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private AddressModel deliveryAddress;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<OrderEntityModel> orderEntities = new ArrayList<OrderEntityModel>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressModel getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AddressModel deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderEntityModel> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(List<OrderEntityModel> orderEntities) {
        this.orderEntities = orderEntities;
    }
    
}
