package com.dee.jpa.hibernate.compoundprimary;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.inheritence.jointable.Customer2;
import com.dee.jpa.hibernate.inheritence.jointable.Employee2;
import com.dee.jpa.hibernate.inheritence.perconcreteclass.Customer3;
import com.dee.jpa.hibernate.inheritence.perconcreteclass.Employee3;
import com.dee.jpa.hibernate.inheritence.singletable.Customer1;
import com.dee.jpa.hibernate.inheritence.singletable.Employee1;
import com.dee.jpa.hibernate.inheritence.singletable.UserType;

/**
 * @author dien.nguyen
 **/

public class InheritenceTest extends TestCase {

    public void testSingleTable() {
        
        Employee1 employee1 = new Employee1();
        employee1.setDept("Dept 1");
        employee1.setEmail("email1@gmail.com");
        
        Customer1 customer1 = new Customer1();
        customer1.setVip(true);
        customer1.setEmail("email2@gmail.com");
        
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(employee1);
        em.persist(customer1);
        em.getTransaction().commit();
        em.close();
        
        
        // Load
        em = EntityManagerUtil.getEntityManager();
        Employee1 pEmployee1 = em.find(Employee1.class, employee1.getId());
        assertEquals("Dept 1", pEmployee1.getDept());
        assertEquals("email1@gmail.com", pEmployee1.getEmail());
        assertEquals(UserType.EmployeeUser, pEmployee1.getUserType());
        em.close();
        
    }

    public void testJoinedTable() {
        Employee2 employee1 = new Employee2();
        employee1.setDept("Dept 1");
        employee1.setEmail("email1@gmail.com");
        
        Customer2 customer1 = new Customer2();
        customer1.setVip(true);
        customer1.setEmail("email2@gmail.com");

        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(employee1);
        em.persist(customer1);
        em.getTransaction().commit();
        em.close();
        
        
        // Load
        em = EntityManagerUtil.getEntityManager();
        Employee2 pEmployee1 = em.find(Employee2.class, employee1.getId());
        assertEquals("Dept 1", pEmployee1.getDept());
        assertEquals("email1@gmail.com", pEmployee1.getEmail());
        assertEquals(UserType.EmployeeUser, pEmployee1.getUserType());
        em.close();
        
    }

    public void testTablePerConcreteClass() {

        Employee3 employee1 = new Employee3();
        employee1.setDept("Dept 1");
        employee1.setEmail("email1@gmail.com");
        
        Customer3 customer1 = new Customer3();
        customer1.setVip(true);
        customer1.setEmail("email2@gmail.com");

        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(employee1);
        em.persist(customer1);
        em.getTransaction().commit();
        em.close();
        
        // Load
        em = EntityManagerUtil.getEntityManager();
        Employee3 pEmployee1 = em.find(Employee3.class, employee1.getId());
        assertEquals("Dept 1", pEmployee1.getDept());
        assertEquals("email1@gmail.com", pEmployee1.getEmail());
        em.close();
        
    }

}
