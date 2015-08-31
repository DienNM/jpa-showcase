package com.dee.jpa.hibernate.collection;

import java.util.Iterator;

import javax.persistence.EntityManager;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.model.collection.OrderedCollectionAddressModel;
import com.dee.jpa.hibernate.model.collection.OrderedCollectionModel;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class OrderedCollectionTest extends TestCase{
    
    public void testOrderedCollection() {
        OrderedCollectionModel collection = new OrderedCollectionModel();
        
        // Order
        collection.getFavourites().add("Reading");
        collection.getFavourites().add("Online");
        collection.getFavourites().add("Watching TV");
        collection.getFavourites().add("Travaling");
        
        
        // Persist Order
        collection.getFavouritesPersistentOrder().add("Reading");
        collection.getFavouritesPersistentOrder().add("Online");
        collection.getFavouritesPersistentOrder().add("Watching TV");
        collection.getFavouritesPersistentOrder().add("Travaling");
        
        // Not Order
        collection.getFavouritesNotOrdered().add("Reading");
        collection.getFavouritesNotOrdered().add("Online");
        collection.getFavouritesNotOrdered().add("Watching TV");
        collection.getFavouritesNotOrdered().add("Travaling");
        
        // Override Attribute
        collection.getAddresses().add(new OrderedCollectionAddressModel("Ho Chi Minh", "Quan 1"));
        collection.getAddresses().add(new OrderedCollectionAddressModel("Ho Chi Minh", "Tan Phu"));
        collection.getAddresses().add(new OrderedCollectionAddressModel("Ho Chi Minh", "Binh Tan"));
        
        // Lazy Loading
        collection.getArticlesLazyLoading().add("Article 1");
        collection.getArticlesLazyLoading().add("Article 2");
        collection.getArticlesLazyLoading().add("Article 3");
        
        // SET
        collection.getPhones().add("0907xxxxxx");
        collection.getPhones().add("0907xxxxxx");
        collection.getPhones().add("0908xxxxxx");
        collection.getPhones().add("0903xxxxxx");
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(collection);
        em.getTransaction().commit();
        em.close();
        
        em = EntityManagerUtil.getEntityManager();
        OrderedCollectionModel pCollection = em.find(OrderedCollectionModel.class, collection.getId());
        Assert.assertNotNull(pCollection);
        
        Assert.assertEquals(4, pCollection.getFavouritesNotOrdered().size());
        Assert.assertEquals("Reading", pCollection.getFavouritesNotOrdered().get(0));
        Assert.assertEquals("Online", pCollection.getFavouritesNotOrdered().get(1));
        Assert.assertEquals("Watching TV", pCollection.getFavouritesNotOrdered().get(2));
        Assert.assertEquals("Travaling", pCollection.getFavouritesNotOrdered().get(3));
        
        Assert.assertEquals(4, pCollection.getFavourites().size());
        Assert.assertEquals("Online", pCollection.getFavourites().get(0));
        Assert.assertEquals("Reading", pCollection.getFavourites().get(1));
        Assert.assertEquals("Travaling", pCollection.getFavourites().get(2));
        Assert.assertEquals("Watching TV", pCollection.getFavourites().get(3));

        Assert.assertEquals(3, pCollection.getAddresses().size());
        Assert.assertEquals("Binh Tan", pCollection.getAddresses().get(0).getAddress());
        Assert.assertEquals("Quan 1", pCollection.getAddresses().get(1).getAddress());
        Assert.assertEquals("Tan Phu", pCollection.getAddresses().get(2).getAddress());
        
        Assert.assertEquals(3, pCollection.getPhones().size());
        Iterator<String> phones = pCollection.getPhones().iterator();
        Assert.assertEquals("0903xxxxxx", phones.next());
        Assert.assertEquals("0907xxxxxx", phones.next());
        Assert.assertEquals("0908xxxxxx", phones.next());
        em.close();
        
        try {
            pCollection.getArticlesLazyLoading().size();
            fail();
        } catch(LazyInitializationException  ex) {
            // Lazy Initization
        }
        
    }
    
}
