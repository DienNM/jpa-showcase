package com.dee.jpa.hibernate.collection;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.Assert;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.model.collection.OwnerModel;
import com.dee.jpa.hibernate.model.collection.VacationModel;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 */

public class CollectionMappingTest extends TestCase{

    public void testCollectionMappingEmbeddable() {
        
        VacationModel vacation1 = new VacationModel();
        vacation1.setStartDate(Calendar.getInstance());
        vacation1.setTakenDays(2);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DAY_OF_MONTH, 5);
        
        VacationModel vacation2 = new VacationModel();
        vacation2.setStartDate(cal2);
        vacation2.setTakenDays(4);
        
        
        OwnerModel owner = new OwnerModel();
        owner.getEmails().add("nmdien61@gmail.com");
        owner.getEmails().add("nguyenminhdien1506@gmail.com");
        owner.getVacations().add(vacation1);
        owner.getVacations().add(vacation2);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(owner);
        em.getTransaction().commit();
        em.close();
        
        em = EntityManagerUtil.getEntityManager();
        OwnerModel pOwner = em.find(OwnerModel.class, owner.getId());
        Assert.assertNotNull(pOwner);
        Assert.assertNotNull(pOwner.getVacations());
        Assert.assertEquals(2, pOwner.getVacations().size());
    }
    
}
