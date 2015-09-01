package com.dee.jpa.hibernate;

import java.util.Calendar;

import javax.annotation.PreDestroy;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.dee.jpa.hibernate.model.Employee;

/**
 * @author dien.nguyen
 */

public class DataValidator {
    
    @PrePersist
    @PreUpdate
    public void validateFields(Employee employee) {
        if(employee.getEmail() == null) {
            throw new DataValidationException("Email must be set");
        }
        if(employee.getDob() == null) {
            throw new DataValidationException("Date of Birth must be set");
        }
        if(employee.getDob().get(Calendar.YEAR) > 2000) {
            throw new DataValidationException("You are not old enough");
        }
    }
    
    @PreDestroy
    public void validateSpecialEmail(Employee employee) {
        if(employee.getEmail().equals("nmdien61@gmail.com")) {
            throw new DataValidationException("This employee cannot be removed");
        }
    }
    
}
