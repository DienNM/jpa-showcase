package com.dee.jpa.hibernate;

import javax.persistence.EntityManager;

import com.dee.jpa.hibernate.model.AddressModel;
import com.dee.jpa.hibernate.model.OrderEntityModel;
import com.dee.jpa.hibernate.model.OrderModel;
import com.dee.jpa.hibernate.service.OrderService;
import com.dee.jpa.hibernate.service.impl.OrderServiceImpl;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class AssociationCRUDTest extends TestCase{
    
    private OrderService orderService;
    
    private AddressModel address;
    
    @Override
    protected void setUp() throws Exception {
        EntityManager em = EntityManagerUtil.getEntityManager();
        orderService = new OrderServiceImpl(em);
        
        initAddress();
    }
    
    @Override
    protected void tearDown() throws Exception {
        orderService.deleteAll();
    }
    
    private void initAddress() {
        address = new AddressModel();
        address.setAddress("Ly Thanh Tong, Tan Phu, HCM");
        address.setPhone("01659xxxxxx");
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
        em.close();
    }
    
    public void testSave() {
        
        // Save Successfully
        OrderModel order = new OrderModel();
        order.setTotalPrice(100);
        
        OrderEntityModel entity1 = new OrderEntityModel();
        entity1.setAmount(2);
        entity1.setProductId(1L);
        
        OrderEntityModel entity2 = new OrderEntityModel();
        entity2.setAmount(1);
        entity2.setProductId(3L);
        
        order.getOrderEntities().add(entity1);
        order.getOrderEntities().add(entity2);
        
        OrderModel pOrder = null;
        try {
            orderService.save(order, address.getId());
            pOrder = orderService.get(order.getId());
            
            assertNotNull(pOrder);
            assertNotNull(pOrder.getDeliveryAddress());
            assertEquals("01659xxxxxx", pOrder.getDeliveryAddress().getPhone());
            
            assertNotNull(pOrder.getOrderEntities());
            assertEquals(2, pOrder.getOrderEntities().size());
            
            // Add Order Entry
            OrderEntityModel entity3 = new OrderEntityModel();
            entity3.setAmount(4);
            entity3.setProductId(10L);
            orderService.addOrderEntry(pOrder, entity3);
            
            pOrder = orderService.get(order.getId());
            assertNotNull(pOrder.getOrderEntities());
            assertEquals(3, pOrder.getOrderEntities().size());
            
            
            // Add New Address
            AddressModel address1 = new AddressModel();
            address1.setAddress("Ho Chi Minh");
            address1.setPhone("0999xxxxxx");
            orderService.changeAddress(pOrder, address1);
            
            pOrder = orderService.get(order.getId());
            
            assertNotNull(pOrder);
            assertNotNull(pOrder.getDeliveryAddress());
            assertEquals("0999xxxxxx", pOrder.getDeliveryAddress().getPhone());
            
        } catch (Exception e) {
            fail();
        }
        
        // Save failed
        order = new OrderModel();
        order.setTotalPrice(101);
        try {
            orderService.save(order, 100L);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof javax.persistence.EntityNotFoundException);
            assertEquals("Unable to find com.dee.jpa.hibernate.model.AddressModel with id 100", e.getMessage());
        }
        
    }
    
}
