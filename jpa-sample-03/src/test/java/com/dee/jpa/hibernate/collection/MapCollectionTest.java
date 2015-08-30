package com.dee.jpa.hibernate.collection;

import java.util.Calendar;

import javax.persistence.EntityManager;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.model.collection.AddressMapModel;
import com.dee.jpa.hibernate.model.collection.MapCollectionModel;
import com.dee.jpa.hibernate.model.collection.SocialNetwork;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 */

public class MapCollectionTest extends TestCase{
    
    public void testMapCollection() {
        
        MapCollectionModel map = new MapCollectionModel();
        map.getPhones().put("mobile", "0988XXXXXX");
        map.getPhones().put("home", "0838XXXXXXX");
        
        map.getVacations().put(Calendar.getInstance(), 2);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 5);
        map.getVacations().put(cal, 3);
        
        map.getWebsites().put(SocialNetwork.Facebook, "https://facebook...");
        map.getWebsites().put(SocialNetwork.Linkedin, "https://linkin...");
        
        map.getAddresses().put("home", new AddressMapModel("Home Address"));
        map.getAddresses().put("office", new AddressMapModel("Office Address"));
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(map);
        em.getTransaction().commit();
        em.close();
        
    }
    
}
