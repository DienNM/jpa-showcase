package com.dee.jpa.hibernate;

import java.util.List;

import com.dee.jpa.hibernate.model.Employee;

/**
 * @author dien.nguyen
 **/

public interface EmployeeService {
    
    List<Employee> getAll();
    
    Employee getByEmail(String email);
    
    Employee getByPhoneNumber(String phone);
    
    List<Employee> getByDepartmentName(String departName);
    
}
