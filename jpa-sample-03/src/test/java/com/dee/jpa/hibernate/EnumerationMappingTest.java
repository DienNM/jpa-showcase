package com.dee.jpa.hibernate;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Assert;

import com.dee.jpa.hibernate.enumeration.AccountStatus;
import com.dee.jpa.hibernate.enumeration.Gender;
import com.dee.jpa.hibernate.enumeration.MarriageStatus;
import com.dee.jpa.hibernate.model.EnumerationMappingModel;

/**
 * @author dien.nguyen
 */

public class EnumerationMappingTest extends TestCase {
    
    private EnumerationMappingModel createEnumerationMapping() {
        
        EnumerationMappingModel enumerationMapping = new EnumerationMappingModel();
        enumerationMapping.setAccountStatus(AccountStatus.ACTIVE);
        enumerationMapping.setGender(Gender.FEMALE);
        enumerationMapping.setMarriedStatus(MarriageStatus.Married);
        
        return enumerationMapping;
    }

    public void testJPA_MappingType() {
        EnumerationMappingModel mappingModel = createEnumerationMapping();
        Assert.assertNull(mappingModel.getId());
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(mappingModel);
        em.getTransaction().commit();
        Assert.assertNotNull(mappingModel.getId());
        em.close();
        
        // Table/Column Value:
        // ID, AccountStatus, Gender, MarriedStatus
        // '1', 'ACTIVE', '1', '1'
        
        // Load
        em = EntityManagerUtil.getEntityManager();
        mappingModel = em.find(EnumerationMappingModel.class, mappingModel.getId());
        Assert.assertEquals(MarriageStatus.Married, mappingModel.getMarriedStatus());
        Assert.assertEquals(AccountStatus.ACTIVE, mappingModel.getAccountStatus());
        Assert.assertEquals(Gender.FEMALE, mappingModel.getGender());
        em.close();
    }
}
