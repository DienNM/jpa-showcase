package com.dee.jpa.hibernate.model.many2many;

import java.io.Serializable;

/**
 * @author dien.nguyen
 */

public class DevTeamRole implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
