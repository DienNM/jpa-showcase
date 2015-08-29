package com.dee.jpa.hibernate;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;

import com.dee.jpa.hibernate.model.FetchingMappingModel;

/**
 * @author dien.nguyen
 **/

public class FetchingMappingTest extends TestCase{
    
    private FetchingMappingModel createTypeMappingModel() {
        FetchingMappingModel fetchingMappingTest = new FetchingMappingModel();
        fetchingMappingTest.setEagerFetchingValue("Eager Value");
        fetchingMappingTest.setLazyFetchingValue("Lazy Value".getBytes());
        return fetchingMappingTest;
    }

    public void testJPA_MappingType() {
        FetchingMappingModel typeMappingModel = createTypeMappingModel();
        Assert.assertNull(typeMappingModel.getId());
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        // Persist User
        em.getTransaction().begin();
        em.persist(typeMappingModel);
        em.getTransaction().commit();
        Assert.assertNotNull(typeMappingModel.getId());
        em.close();
        
        em = EntityManagerUtil.getEntityManager();
        FetchingMappingModel fm = em.find(FetchingMappingModel.class, typeMappingModel.getId());
        
        // Load lazy field
        fm.getLazyFetchingValue();
        em.close();
        Assert.assertNotNull(fm.getLazyFetchingValue());
        
        em = EntityManagerUtil.getEntityManager();
        fm = em.find(FetchingMappingModel.class, typeMappingModel.getId());
        em.close();
        try {
            fm.getLazyFetchingValue();
            fail();
        } catch(LazyInitializationException ex) {
            Assert.assertEquals("session is not connected", ex.getMessage());
        }
        
    }
}
