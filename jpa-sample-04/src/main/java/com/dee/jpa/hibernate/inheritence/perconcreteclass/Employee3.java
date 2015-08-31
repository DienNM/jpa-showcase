package com.dee.jpa.hibernate.inheritence.perconcreteclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "employee_3")
@AttributeOverrides(value = {
        @AttributeOverride(name = "id", column = @Column(name = "emp_id")),
        @AttributeOverride(name = "email", column = @Column(name = "primary_email"))
})
public class Employee3 extends User3{

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
