package com.dee.jpa.hibernate.derivedidentifier.sharedprimary;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "employee_history")
public class EmployeeHistory implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    
    @MapsId
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
    private Calendar accessDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Calendar getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Calendar accessDate) {
        this.accessDate = accessDate;
    }

}
