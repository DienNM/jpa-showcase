package com.dee.jpa.hibernate.inheritence.jointable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "customer_2")
@DiscriminatorValue(value = "CustomerUser")
public class Customer2 extends User2 {

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
