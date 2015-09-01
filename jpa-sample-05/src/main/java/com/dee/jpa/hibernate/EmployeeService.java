package com.dee.jpa.hibernate;

import java.util.List;

import com.dee.jpa.hibernate.model.Address;
import com.dee.jpa.hibernate.model.Employee;
import com.dee.jpa.hibernate.model.Phone;

/**
 * @author dien.nguyen
 **/

public interface EmployeeService {
    
    List<Employee> getAll();
    
    Employee getByEmail(String email);
    
    Employee getByPhoneNumber(String phone);
    
    List<Employee> getByDepartmentName(String departName);
    
    List<Phone> getPhones(Long employeeId);
    
    Address getAddress(Long employeeId);
    
    String getEmployeeEmail(Long id);
    
    List<String> getPhoneNumbers(Long employeeId);
    
    List<String> getEmailAndPhoneNumbers(Long employeeId);
    
    List<PhoneAggregate> getAllEmailsAndPhones();
    
    List<String[]> getEmailsAndAddresses();
    
    List<EmailAndAddress> getEmailAndAddress1();
    
}
