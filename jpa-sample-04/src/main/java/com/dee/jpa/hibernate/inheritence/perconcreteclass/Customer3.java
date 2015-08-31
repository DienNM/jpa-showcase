package com.dee.jpa.hibernate.inheritence.perconcreteclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "customer_3")
public class Customer3 extends User3 {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "is_vip")
    private boolean vip;

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

}
