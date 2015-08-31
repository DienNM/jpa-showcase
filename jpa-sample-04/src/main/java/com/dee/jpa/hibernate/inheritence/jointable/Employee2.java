package com.dee.jpa.hibernate.inheritence.jointable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "employee_2")
@DiscriminatorValue(value = "EmployeeUser")
public class Employee2 extends User2{

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
