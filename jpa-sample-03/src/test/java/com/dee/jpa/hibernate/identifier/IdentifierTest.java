package com.dee.jpa.hibernate.identifier;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Assert;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.model.identifer.Identifier21Model;
import com.dee.jpa.hibernate.model.identifer.Identifier2Model;

/**
 * @author dien.nguyen
 */

public class IdentifierTest extends TestCase{
    
    public void testIdentifier2Model() {
        
        Identifier2Model identifier1 = new Identifier2Model();
        Identifier2Model identifier11 = new Identifier2Model();
        Identifier2Model identifier12 = new Identifier2Model();
        
        Identifier21Model identifier21 = new Identifier21Model();
        Identifier21Model identifier22 = new Identifier21Model();
        Identifier21Model identifier23 = new Identifier21Model();
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(identifier1);
        em.persist(identifier11);
        em.persist(identifier12);

        Assert.assertNotNull(identifier1.getId());
        Assert.assertNotNull(identifier11.getId());
        Assert.assertNotNull(identifier12.getId());
        
        em.persist(identifier21);
        em.persist(identifier22);
        em.persist(identifier23);
        em.getTransaction().commit();
        
        em.close();
        
        
        // Second time
        Identifier21Model identifier24 = new Identifier21Model();
        em = EntityManagerUtil.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(identifier24);
        em.getTransaction().commit();
        em.close();
    }
    
}
