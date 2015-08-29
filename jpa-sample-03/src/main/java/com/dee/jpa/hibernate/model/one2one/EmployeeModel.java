package com.dee.jpa.hibernate.model.one2one;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "o2o_employee")
public class EmployeeModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @OneToOne
    @JoinColumn(name = "home_address_id")
    private AddressModel homeAddress;
    
    @OneToOne
    @JoinColumn(name = "emp_detail")
    private EmployeeInfoModel employeeDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressModel getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(AddressModel homeAddress) {
        this.homeAddress = homeAddress;
    }

    public EmployeeInfoModel getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(EmployeeInfoModel employeeDetail) {
        this.employeeDetail = employeeDetail;
    }
    
}
