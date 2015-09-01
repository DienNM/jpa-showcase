package com.dee.jpa.hibernate;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;

import com.dee.jpa.hibernate.model.UserModel;
import com.dee.jpa.hibernate.service.UserService;
import com.dee.jpa.hibernate.service.impl.UserServiceImpl;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class UserServiceTest extends TestCase{
    
    private UserService userService;
    
    @Override
    protected void setUp() throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        userService = new UserServiceImpl(em);
        
        // prepare Data
        
    }
    
    
    @Override
    protected void tearDown() throws Exception {
        userService.deleteAll();
    }
    
    private UserModel createUser() {
        UserModel userModel = new UserModel();
        userModel.setFirstName("Dien");
        userModel.setLastName("Nguyen");
        userModel.setEmail("nmdien61@gmail.com");
        return userModel;
    }
    
    public void testGet() {
        UserModel user = createUser();
        userService.save(user);
        UserModel pUser = userService.get(user.getId());
        Assert.assertNotNull(pUser);
        Assert.assertEquals("nmdien61@gmail.com", pUser.getEmail());
        
        pUser = userService.get(100L);
        Assert.assertNull(pUser);
    }
    
    public void testGetAll() {
        UserModel user = createUser();
        userService.save(user);
        
        List<UserModel> pUsers = userService.getAll();
        Assert.assertNotNull(pUsers);
        Assert.assertEquals(1, pUsers.size());
    }
    
    public void testUpdate() {
        UserModel user = createUser();
        userService.save(user);
        
        user.setLastName("Nguyen Minh");
        userService.update(user);
        
        user = userService.get(user.getId());
        Assert.assertEquals("Nguyen Minh", user.getLastName());
    }
    
    public void testDelete() {
        UserModel user = createUser();
        userService.save(user);
        
        userService.delete(user.getId());
        user = userService.get(user.getId());
        Assert.assertNull(user);
        
    }
}
