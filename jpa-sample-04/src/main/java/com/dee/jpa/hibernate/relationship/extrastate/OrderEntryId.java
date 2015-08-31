package com.dee.jpa.hibernate.relationship.extrastate;

import java.io.Serializable;

/**
 * @author dien.nguyen
 **/

public class OrderEntryId implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String order;
    
    private Long product;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }
}
