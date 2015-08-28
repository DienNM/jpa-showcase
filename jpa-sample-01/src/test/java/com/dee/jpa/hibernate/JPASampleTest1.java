package com.dee.jpa.hibernate;

import javax.persistence.EntityManager;

import org.junit.Assert;

import com.dee.jpa.hibernate.model.UserModel;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class JPASampleTest1 extends TestCase{
    
    private UserModel createUser() {
        UserModel userModel = new UserModel();
        userModel.setFirstName("Dien");
        userModel.setLastName("Nguyen");
        userModel.setEmail("nmdien61@gmail.com");
        return userModel;
    }

    public void testJPAStartUp() {
        UserModel userModel = createUser();
        Assert.assertNull(userModel.getId());
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        // Persist User
        em.getTransaction().begin();
        em.persist(userModel);
        em.getTransaction().commit();
        Assert.assertNotNull(userModel.getId());
        
        // In the same Persistent Context, the same entity identifier, the same java instance must be returned
        
        UserModel pUserModel1 = em.find(UserModel.class, userModel.getId());
        UserModel pUserModel2 = em.find(UserModel.class, userModel.getId());
        Assert.assertNotNull(pUserModel1);
        Assert.assertNotNull(pUserModel2);
        Assert.assertTrue(pUserModel1 == pUserModel2);

        em.close();
        
        // Update User
        em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        UserModel pUserModel3 = em.find(UserModel.class, userModel.getId());
        pUserModel3.setLastName("Nguyen Minh");
        em.getTransaction().commit();
        em.close();
        
        em = EntityManagerUtil.getEntityManager();
        pUserModel3 = em.find(UserModel.class, userModel.getId());
        Assert.assertEquals("Nguyen Minh", pUserModel3.getLastName());
        em.close();
        
        // Remove User, note that we cannot remove a detached object
        em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        UserModel pUserModel4 = em.find(UserModel.class, userModel.getId());
        Assert.assertNotNull(pUserModel4);
        em.remove(pUserModel4);
        em.getTransaction().commit();
        
        pUserModel4 = em.find(UserModel.class, userModel.getId());
        Assert.assertNull(pUserModel4);
        em.close();
    }
}
