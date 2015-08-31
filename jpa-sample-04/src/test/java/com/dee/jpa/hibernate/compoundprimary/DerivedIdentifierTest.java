package com.dee.jpa.hibernate.compoundprimary;

import java.util.Calendar;

import javax.persistence.EntityManager;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.derivedidentifier.sharedprimary.Employee;
import com.dee.jpa.hibernate.derivedidentifier.sharedprimary.EmployeeHistory;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class DerivedIdentifierTest extends TestCase{
    
    public void testDerivedIdentifier_SharePrimaryKey() {
        
        Employee employee1 = new Employee();
        employee1.setName("DienNM");
        
        Employee employee2 = new Employee();
        employee2.setName("DienNM");
        
        EmployeeHistory employeeHistory1 = new EmployeeHistory();
        employeeHistory1.setAccessDate(Calendar.getInstance());
        employeeHistory1.setEmployee(employee1);
        
        EmployeeHistory employeeHistory2 = new EmployeeHistory();
        employeeHistory2.setAccessDate(Calendar.getInstance());
        employeeHistory2.setEmployee(employee2);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(employee1);
        em.persist(employee2);
        em.persist(employeeHistory1);
        em.persist(employeeHistory2);
        em.getTransaction().commit();
        em.close();
        
    }
    
}
