package com.dee.jpa.hibernate.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dee.jpa.hibernate.EmployeeService;
import com.dee.jpa.hibernate.model.Employee;

/**
 * @author dien.nguyen
 **/

public class EmployeeServiceImpl implements EmployeeService {

    private EntityManager em;
    
    public EmployeeServiceImpl(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getAll() {
        
        Query query = em.createQuery("FROM Employee");
        return query.getResultList();
        
    }

    @SuppressWarnings("unchecked")
    @Override
    public Employee getByEmail(String email) {
        
        Query query = em.createQuery("FROM Employee WHERE email = :email");
        query.setParameter("email", email);
        
        List<Employee> employees = query.getResultList();
        if(employees.isEmpty()) {
            return null;
        }
        return employees.get(0);
        
    }

    @Override
    public Employee getByPhoneNumber(String phone) {
        
        Query query = em.createQuery(
                "SELECT e FROM Employee e JOIN e.phones p"
                + " WHERE p.num = :phone");
        query.setParameter("phone", phone);
        
        return (Employee) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getByDepartmentName(String departName) {
        Query query = em.createQuery(
                "SELECT e FROM Employee e JOIN e.dept d"
                + " WHERE d.name = :name");
        query.setParameter("name", departName);
        return query.getResultList();
    }
    
    
    
}
