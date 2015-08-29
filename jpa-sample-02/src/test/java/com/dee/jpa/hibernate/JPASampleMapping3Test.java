package com.dee.jpa.hibernate;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Assert;

import com.dee.jpa.hibernate.model.TypeMapping3Model;

/**
 * @author dien.nguyen
 **/

public class JPASampleMapping3Test extends TestCase{
    
    private TypeMapping3Model createTypeMappingModel() {
        TypeMapping3Model typeMappingModel = new TypeMapping3Model();
        
        byte[] bytes = "diennm".getBytes();
        Byte[] bytesW = new Byte[bytes.length];
        int index = 0;
        for(byte b : bytes) {
            bytesW[index++] = b;
        }
        
        char[] chars = "diennm".toCharArray();
        Character[] charsW = new Character[chars.length];
        index = 0;
        for(char c : chars) {
            charsW[index++] = c;
        }
        
        typeMappingModel.setByteArrValue(bytes);
        typeMappingModel.setByteArrWrapperValue(bytesW);
        typeMappingModel.setCharArrValue(chars);
        typeMappingModel.setCharArrWrapperValue(charsW);
        
        return typeMappingModel;
    }

    public void testJPA_MappingType() {
        TypeMapping3Model typeMappingModel = createTypeMappingModel();
        Assert.assertNull(typeMappingModel.getId());
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(typeMappingModel);
        em.getTransaction().commit();
        Assert.assertNotNull(typeMappingModel.getId());
        
        em.close();
    }
}
