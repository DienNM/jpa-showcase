package com.dee.jpa.hibernate;

import java.util.Calendar;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import com.dee.jpa.hibernate.model.Employee;

/**
 * @author dien.nguyen
 */

public class EntityListennerTest extends TestCase{
    
    EntityManager em = EntityManagerUtil.getEntityManager();
    
    @Override
    protected void tearDown() throws Exception {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Employee");
        em.getTransaction().commit();
        em.close();
    }
    
    public void testListenner() {
        
        Employee employee = new Employee();
        
        
        try {
            em.getTransaction().begin();
            em.persist(employee);
            fail();
        } catch(DataValidationException e) {
            assertEquals("Email must be set", e.getMessage());
            em.getTransaction().rollback();
        }
        
        employee.setEmail("email1@gmail.com");
        try {
            em.getTransaction().begin();
            em.persist(employee);
            fail();
        } catch(DataValidationException e) {
            assertEquals("Date of Birth must be set", e.getMessage());
            em.getTransaction().rollback();
        }
        
        employee.setDob(Calendar.getInstance());
        try {
            em.getTransaction().begin();
            em.persist(employee);
            fail();
        } catch(DataValidationException e) {
            assertEquals("You are not old enough", e.getMessage());
            em.getTransaction().rollback();
        }
        
        Calendar dob = Calendar.getInstance();
        dob.set(Calendar.YEAR, 1988);
        employee.setDob(dob);
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
        } catch(DataValidationException e) {
            fail();
        }
        
        Employee employee2 = em.find(Employee.class, employee.getId());
        assertNotNull(employee2);
        assertNotNull(employee2.getCreatedAt());
        assertNull(employee2.getUpdatedAt());
        
        employee2.setEmail("email2@gmail.com");
        em.getTransaction().begin();
        em.merge(employee2);
        em.getTransaction().commit();
        
        
        employee2 = em.find(Employee.class, employee.getId());
        assertNotNull(employee2);
        assertNotNull(employee2.getCreatedAt());
        assertNotNull(employee2.getUpdatedAt());
    }
    
}
