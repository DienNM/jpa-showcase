package com.dee.jpa.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;

import com.dee.jpa.hibernate.model.UserModel;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class JPASampleJPQLTest extends TestCase{
    
    private UserModel createUser() {
        UserModel userModel = new UserModel();
        userModel.setFirstName("Dien");
        userModel.setLastName("Nguyen");
        userModel.setEmail("nmdien61@gmail.com");
        return userModel;
    }

    public void testJPA_JPQL() {
        UserModel userModel = createUser();
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(userModel);
        em.getTransaction().commit();
        Assert.assertNotNull(userModel.getId());
        em.close();
        
        em = EntityManagerUtil.getEntityManager();
        TypedQuery<UserModel> typedQuery = em.createQuery("from user_jpa_1", UserModel.class);
        List<UserModel> userModels = typedQuery.getResultList();
        Assert.assertEquals(1, userModels.size());
    }
}
