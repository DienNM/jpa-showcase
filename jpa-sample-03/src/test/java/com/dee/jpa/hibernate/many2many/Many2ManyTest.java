package com.dee.jpa.hibernate.many2many;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Assert;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.model.many2many.DeveloperModel;
import com.dee.jpa.hibernate.model.many2many.OrderEntryIdModel;
import com.dee.jpa.hibernate.model.many2many.OrderEntryModel;
import com.dee.jpa.hibernate.model.many2many.OrderModel;
import com.dee.jpa.hibernate.model.many2many.ProductModel;
import com.dee.jpa.hibernate.model.many2many.ProjectModel;

/**
 * @author dien.nguyen
 */

public class Many2ManyTest extends TestCase{

    public void testBidirectionOne2Many() {
        
        DeveloperModel dev1 = new DeveloperModel();
        dev1.setName("Dien Nguyen 01");
        
        DeveloperModel dev2 = new DeveloperModel();
        dev2.setName("Dien Nguyen 02");
        
        ProjectModel project = new ProjectModel();
        project.setName("DEE");
        project.getDevelopers().add(dev1);
        project.getDevelopers().add(dev2);
        
        dev1.getProjects().add(project);
        dev2.getProjects().add(project);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(dev1);
        em.persist(dev2);
        em.persist(project);
        em.getTransaction().commit();
        em.close();
        
        // Load
        em = EntityManagerUtil.getEntityManager();
        ProjectModel pProject = em.find(ProjectModel.class, project.getId());
        
        Assert.assertNotNull(pProject);
        Assert.assertNotNull(pProject.getDevelopers());
        Assert.assertEquals(2, pProject.getDevelopers().size());
        Assert.assertNotNull(pProject.getDevelopers().get(0));
        Assert.assertNotNull(pProject.getDevelopers().get(1));
        
        DeveloperModel pDev1 = em.find(DeveloperModel.class, dev1.getId());
        DeveloperModel pDev2 = em.find(DeveloperModel.class, dev2.getId());
        
        Assert.assertNotNull(pDev1);
        Assert.assertNotNull(pDev2);
        
        Assert.assertNotNull(pDev1.getProjects());
        Assert.assertNotNull(pDev2.getProjects());
        
        Assert.assertEquals(1, pDev1.getProjects().size());
        Assert.assertEquals(1, pDev2.getProjects().size());
        
        em.close();
    }
    
    public void testMany2ManyExtraColumns() {
        
        OrderModel order = new OrderModel();
        order.setTotal(150);
        
        ProductModel product1 = new ProductModel();
        product1.setName("Product 1");
        
        ProductModel product2 = new ProductModel();
        product2.setName("Product 2");
        
        ProductModel product3 = new ProductModel();
        product3.setName("Product 3");
        
        OrderEntryModel orderEntry1 = new OrderEntryModel();
        orderEntry1.setAmount(2);
        orderEntry1.setPrice(10);
        orderEntry1.setProduct(product1);
        orderEntry1.setOrder(order);
        
        OrderEntryModel orderEntry2 = new OrderEntryModel();
        orderEntry2.setAmount(1);
        orderEntry2.setPrice(20);
        orderEntry2.setProduct(product2);
        orderEntry2.setOrder(order);
        
        OrderEntryModel orderEntry3 = new OrderEntryModel();
        orderEntry3.setAmount(5);
        orderEntry3.setPrice(6);
        orderEntry3.setProduct(product3);
        orderEntry3.setOrder(order);
        
        order.getOrderEntries().add(orderEntry1);
        order.getOrderEntries().add(orderEntry2);
        order.getOrderEntries().add(orderEntry3);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        
        em.persist(order);
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        
        OrderEntryIdModel id1 = new OrderEntryIdModel();
        id1.setOrderId(order.getId());
        id1.setProductId(product1.getId());
        orderEntry1.setId(id1);
        
        OrderEntryIdModel id2 = new OrderEntryIdModel();
        id2.setOrderId(order.getId());
        id2.setProductId(product2.getId());
        orderEntry2.setId(id2);
        
        OrderEntryIdModel id3 = new OrderEntryIdModel();
        id3.setOrderId(order.getId());
        id3.setProductId(product3.getId());
        orderEntry3.setId(id3);
        
        em.persist(orderEntry1);
        em.persist(orderEntry2);
        em.persist(orderEntry3);
        
        em.getTransaction().commit();
        em.close();
        
        // Load
        em = EntityManagerUtil.getEntityManager();
        
        OrderModel pOrder = em.find(OrderModel.class, order.getId());
        assertNotNull(pOrder);
        assertEquals(3, pOrder.getOrderEntries().size());
        
        OrderEntryModel pOrderEntry1 = em.find(OrderEntryModel.class, orderEntry1.getId());
        assertNotNull(pOrderEntry1);
        assertEquals(2, pOrderEntry1.getAmount());
        em.close();
        
    }
    
}
