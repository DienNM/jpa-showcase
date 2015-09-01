package com.dee.jpa.hibernate;

import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.dee.jpa.hibernate.model.Employee;

/**
 * @author dien.nguyen
 */

public class AuditDataListenner {

    @PrePersist
    public void setAuditSavingData(Employee employee) {
        employee.setCreatedAt(Calendar.getInstance().getTime());
    }
    
    @PreUpdate
    public void setAuditUpdatingData(Employee employee) {
        employee.setUpdatedAt(Calendar.getInstance().getTime());
    }
    
}
