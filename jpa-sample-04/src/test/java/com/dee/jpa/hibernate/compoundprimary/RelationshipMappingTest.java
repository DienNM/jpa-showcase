package com.dee.jpa.hibernate.compoundprimary;

import javax.persistence.EntityManager;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.relationship.TravelHistory;
import com.dee.jpa.hibernate.relationship.Traveller;
import com.dee.jpa.hibernate.relationship.TravellerGroup;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class RelationshipMappingTest extends TestCase{

    public void testRelationshipMapping() {
        
        Traveller traveller1 = new Traveller();
        traveller1.setName("T1");
        
        Traveller traveller2 = new Traveller();
        traveller2.setName("T2");
        
        Traveller traveller3 = new Traveller();
        traveller3.setName("T3");
        
        Traveller traveller4 = new Traveller();
        traveller4.setName("T4");
        
        TravellerGroup group = new TravellerGroup();
        group.getTravellers().add(traveller3);
        group.getTravellers().add(traveller4);
        
        TravelHistory travelHistory1  = new TravelHistory();
        travelHistory1.setCountry("US");
        travelHistory1.setCity("NewYork");
        travelHistory1.getTravallers().add(traveller1);
        travelHistory1.getTravallers().add(traveller2);
        
        TravelHistory travelHistory2  = new TravelHistory();
        travelHistory2.setCountry("US");
        travelHistory2.setCity("WST-DC");
        travelHistory2.getTravallers().add(traveller2);
        
        TravelHistory travelHistory3  = new TravelHistory();
        travelHistory3.setCountry("VN");
        travelHistory3.setCity("Ha Noi");
        travelHistory3.getTravallers().add(traveller1);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(traveller1);
        em.persist(traveller2);
        em.persist(traveller3);
        em.persist(traveller4);
        
        em.persist(group);

        em.persist(travelHistory1);
        em.persist(travelHistory2);
        em.persist(travelHistory3);
        em.getTransaction().commit();
        em.close();
        
        em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        
        TravellerGroup pTravallerGroup = em.find(TravellerGroup.class, group.getId());
        em.remove(pTravallerGroup);
        
        em.getTransaction().commit();
        em.close();
        
    }
    
    
}
