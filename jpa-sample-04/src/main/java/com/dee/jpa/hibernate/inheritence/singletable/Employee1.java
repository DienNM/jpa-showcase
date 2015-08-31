package com.dee.jpa.hibernate.inheritence.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * @author dien.nguyen
 **/

@Entity
@DiscriminatorValue(value = "EmployeeUser")
public class Employee1 extends User1{

    private static final long serialVersionUID = 1L;
    
    @Column(name = "department")
    private String dept;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

}
