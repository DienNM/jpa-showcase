package com.dee.jpa.hibernate.compoundprimary;

import javax.persistence.EntityManager;

import org.junit.Assert;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.compoundprimary.embedded.People2;
import com.dee.jpa.hibernate.compoundprimary.embedded.PeopleId2;
import com.dee.jpa.hibernate.compoundprimary.idclass.People1;
import com.dee.jpa.hibernate.compoundprimary.idclass.PeopleId1;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class CompoundKeyTest extends TestCase{
    
    public void testCompoudKeyClassId() {
        PeopleId1 id1 = new PeopleId1();
        id1.setCountry("VN");
        id1.setId("1");
        
        PeopleId1 id2 = new PeopleId1();
        id2.setCountry("VN");
        id2.setId("2");
        
        PeopleId1 id3 = new PeopleId1();
        id3.setCountry("US");
        id3.setId("1");
        
        People1 people1 = new People1();
        people1.setName("Name 1");
        people1.setCountry(id1.getCountry());
        people1.setId(id1.getId());
        
        People1 people2 = new People1();
        people2.setName("Name 2");
        people2.setCountry(id2.getCountry());
        people2.setId(id2.getId());
        
        People1 people3 = new People1();
        people3.setName("Name 3");
        people3.setCountry(id3.getCountry());
        people3.setId(id3.getId());
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(people1);
        em.persist(people2);
        em.persist(people3);
        em.getTransaction().commit();
        em.close();
        
        // Load
        em = EntityManagerUtil.getEntityManager();
        People1 pPeople1 = em.find(People1.class, id1);
        Assert.assertNotNull(pPeople1);
        
        People1 pPeople2 = em.find(People1.class, id2);
        Assert.assertNotNull(pPeople2);
        
        People1 pPeople3 = em.find(People1.class, id3);
        Assert.assertNotNull(pPeople3);
        
        em.close();
    }
    
    public void testCompoundKeyEmbedded() {
        PeopleId2 id1 = new PeopleId2();
        id1.setCountry("VN");
        id1.setId("1");
        
        PeopleId2 id2 = new PeopleId2();
        id2.setCountry("VN");
        id2.setId("2");
        
        PeopleId2 id3 = new PeopleId2();
        id3.setCountry("US");
        id3.setId("1");
        
        People2 people1 = new People2();
        people1.setName("Name 1");
        people1.setId(id1);
        
        People2 people2 = new People2();
        people2.setName("Name 2");
        people2.setId(id2);
        
        People2 people3 = new People2();
        people3.setName("Name 3");
        people3.setId(id3);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(people1);
        em.persist(people2);
        em.persist(people3);
        em.getTransaction().commit();
        em.close();
        
        // Load
        em = EntityManagerUtil.getEntityManager();
        People2 pPeople1 = em.find(People2.class, id1);
        Assert.assertNotNull(pPeople1);
        
        People2 pPeople2 = em.find(People2.class, id2);
        Assert.assertNotNull(pPeople2);
        
        People2 pPeople3 = em.find(People2.class, id3);
        Assert.assertNotNull(pPeople3);
        
        em.close();
        
    }
    
}
