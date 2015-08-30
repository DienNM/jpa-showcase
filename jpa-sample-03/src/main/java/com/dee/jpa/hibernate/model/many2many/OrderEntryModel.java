package com.dee.jpa.hibernate.model.many2many;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "m2m_order_entry")
public class OrderEntryModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private OrderEntryIdModel id;
    
    private double price;
    
    private int amount;

    @ManyToOne
    @MapsId("order_id")
    @PrimaryKeyJoinColumn(name="order_id", referencedColumnName="id")
    private OrderModel order;

    @ManyToOne
    @MapsId("product_id")
    @PrimaryKeyJoinColumn(name="product_id", referencedColumnName="id")
    private ProductModel product;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public OrderEntryIdModel getId() {
        return id;
    }

    public void setId(OrderEntryIdModel id) {
        this.id = id;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

}
