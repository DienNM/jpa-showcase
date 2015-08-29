package com.dee.jpa.hibernate;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Assert;

import com.dee.jpa.hibernate.model.TypeMapping2Model;

/**
 * @author dien.nguyen
 **/

public class JPASampleMapping2Test extends TestCase{
    
    private TypeMapping2Model createTypeMappingModel() {
        TypeMapping2Model typeMappingModel = new TypeMapping2Model();
        typeMappingModel.setByteValue("a".getBytes()[0]);
        typeMappingModel.setCharValue("a".toCharArray()[0]);
        typeMappingModel.setDoubleValue(150.105);
        typeMappingModel.setFloatValue(Float.valueOf(30));
        typeMappingModel.setIntValue(23);
        typeMappingModel.setLongValue(30l);
        typeMappingModel.setShortValue((short)8);
        
        return typeMappingModel;
    }

    public void testJPA_MappingType() {
        TypeMapping2Model typeMappingModel = createTypeMappingModel();
        Assert.assertNull(typeMappingModel.getId());
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        // Persist User
        em.getTransaction().begin();
        em.persist(typeMappingModel);
        em.getTransaction().commit();
        Assert.assertNotNull(typeMappingModel.getId());
        
        em.close();
    }
}
