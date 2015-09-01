package com.dee.jpa.hibernate.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.dee.jpa.hibernate.EmployeeService;
import com.dee.jpa.hibernate.model.Address;
import com.dee.jpa.hibernate.model.Employee;
import com.dee.jpa.hibernate.model.Phone;

/**
 * @author dien.nguyen
 **/

public class EmployeeServiceImpl implements EmployeeService {

    private EntityManager em;

    public EmployeeServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> query = em.createQuery("FROM Employee", Employee.class);
        return query.getResultList();

    }

    @Override
    public Employee getByEmail(String email) {

        TypedQuery<Employee> query = em.createQuery("FROM Employee WHERE email = :email", Employee.class);
        query.setParameter("email", email);

        List<Employee> employees = query.getResultList();
        if (employees.isEmpty()) {
            return null;
        }
        return employees.get(0);

    }

    @Override
    public Employee getByPhoneNumber(String phone) {

        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e JOIN e.phones p" + 
                        " WHERE p.num = :phone",Employee.class);
        query.setParameter("phone", phone);

        return (Employee) query.getSingleResult();
    }

    @Override
    public List<Employee> getByDepartmentName(String departName) {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e JOIN e.dept d" + 
                        " WHERE d.name = :name", Employee.class);
        query.setParameter("name", departName);
        return query.getResultList();
    }
    
    @Override
    public List<Phone> getPhones(Long employeeId) {
        TypedQuery<Phone> query = em.createQuery("SELECT p FROM Employee e JOIN e.phones p " + 
                        " WHERE e.id = :employeeId", Phone.class);
        query.setParameter("employeeId", employeeId);
        return query.getResultList();
    }

    @Override
    public Address getAddress(Long employeeId) {
        TypedQuery<Address> query = em.createQuery("SELECT a FROM Employee e JOIN e.address a " + 
                        " WHERE e.id = :employeeId", Address.class);
        query.setParameter("employeeId", employeeId);
        List<Address> address = query.getResultList();
        if (address.isEmpty()) {
            return null;
        }
        return address.get(0);
    }

    @Override
    public String getEmployeeEmail(Long id) {
        
        Query query = em.createQuery("SELECT e.email FROM Employee e WHERE e.id = :id");
        query.setParameter("id", id);
        
        return (String) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> getPhoneNumbers(Long employeeId) {
        
        Query query = em.createQuery("SELECT p.num FROM Employee e JOIN e.phones p WHERE e.id = :employeeId");
        query.setParameter("employeeId", employeeId);
        
        List<Object> objectArrays = query.getResultList();
        
        List<String> phones = new ArrayList<String>();
        for(Object  obj : objectArrays) {
            phones.add(obj.toString());
        }
        return phones;
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public List<String> getEmailAndPhoneNumbers(Long employeeId) {
        Query query = em.createQuery("SELECT e.email, p.num FROM Employee e JOIN e.phones p WHERE e.id = :employeeId");
        query.setParameter("employeeId", employeeId);
        
        List<Object[]> objectArrays = query.getResultList();
        
        List<String> emailAndPhones = new ArrayList<String>();
        for(Object[]  obj : objectArrays) {
            emailAndPhones.add("Email=" + obj[0].toString() + " - Phone=" + obj[1].toString());
        }
        return emailAndPhones;
    }
}
