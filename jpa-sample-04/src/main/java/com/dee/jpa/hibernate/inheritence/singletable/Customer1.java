package com.dee.jpa.hibernate.inheritence.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * @author dien.nguyen
 **/

@Entity
@DiscriminatorValue(value = "CustomerUser")
public class Customer1 extends User1 {

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
