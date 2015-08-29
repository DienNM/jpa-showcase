package com.dee.jpa.hibernate.one2one;

import javax.persistence.EntityManager;

import org.junit.Assert;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.model.one2one.AddressModel;
import com.dee.jpa.hibernate.model.one2one.EmployeeInfoModel;
import com.dee.jpa.hibernate.model.one2one.EmployeeModel;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 */

public class One2OneTest extends TestCase {
    
    public void testUndirectionalOne2One() {
        
        AddressModel address = new AddressModel();
        address.setAddress("Tan Phu, HCM");
        
        EmployeeModel employee = new EmployeeModel();
        employee.setName("Dien Nguyen");
        employee.setHomeAddress(address);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(address);
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
        
        // Load
        em = EntityManagerUtil.getEntityManager();
        EmployeeModel pEmployee = em.find(EmployeeModel.class, employee.getId());
        Assert.assertNotNull(pEmployee);
        Assert.assertNotNull(pEmployee.getHomeAddress());
        
    }
    
    public void testBidirectionalOne2One() {
        AddressModel address = new AddressModel();
        address.setAddress("Tan Phu, HCM");
        EmployeeModel employee = new EmployeeModel();
        employee.setName("Dien Nguyen");
        employee.setHomeAddress(address);
        
        EmployeeInfoModel employeeInfo = new EmployeeInfoModel();
        employeeInfo.setEmail("nmdien61@gmail.com");
        employeeInfo.setEmployee(employee);
        
        employee.setEmployeeDetail(employeeInfo);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(address);
        em.persist(employee);
        em.persist(employeeInfo);
        em.getTransaction().commit();
        em.close();
        
        // Load
        em = EntityManagerUtil.getEntityManager();
        EmployeeModel pEmployee = em.find(EmployeeModel.class, employee.getId());
        Assert.assertNotNull(pEmployee);
        Assert.assertNotNull(pEmployee.getHomeAddress());
        Assert.assertNotNull(pEmployee.getEmployeeDetail());
        
        EmployeeInfoModel pEmployeeInfo = em.find(EmployeeInfoModel.class, employeeInfo.getId());
        Assert.assertNotNull(pEmployeeInfo);
        Assert.assertNotNull(pEmployeeInfo.getEmployee());
    }
    
}
