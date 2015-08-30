package com.dee.jpa.hibernate.model.many2many;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author dien.nguyen
 */

@Embeddable
public class OrderEntryIdModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;
    
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
