package com.dee.jpa.hibernate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Assert;

import com.dee.jpa.hibernate.model.LargeObjectMappingModel;

/**
 * @author dien.nguyen
 **/

public class LargeObjectMappingTest extends TestCase {
    
    private LargeObjectMappingModel createLargeObject() {
        LargeObjectMappingModel largeObjectMapping = new LargeObjectMappingModel();

        BufferedReader bis = null;
        try {
            bis = new BufferedReader(new FileReader(new File("src/test/resources/large-object-data.txt")));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while((line = bis.readLine()) != null) {
                sb.append(line).append("\n");
            }
            largeObjectMapping.setBlobValue(sb.toString().getBytes());
            largeObjectMapping.setClobValueChars(sb.toString().toCharArray());
            largeObjectMapping.setClobValueString(sb.toString());
            
        } catch(Exception e) {
        }finally {
            try {
                bis.close();
            } catch (IOException e) {
            }
        }
        
        return largeObjectMapping;
    }

    public void testJPA_LargeObject() {
        LargeObjectMappingModel typeMappingModel = createLargeObject();
        Assert.assertNull(typeMappingModel.getId());
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(typeMappingModel);
        em.getTransaction().commit();
        Assert.assertNotNull(typeMappingModel.getId());
        em.close();
        
        typeMappingModel.setStringValue(new String(typeMappingModel.getBlobValue()));
        em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(typeMappingModel);
            em.getTransaction().commit();
            fail();
        }catch(Exception e) {
            // Because of:
            // com.mysql.jdbc.MysqlDataTruncation: Data truncation: Data too long for column 'stringValue' at row 1
        } finally {
            em.close();
        }
        
        // Save another value
        typeMappingModel.setStringValue("Value of String");
        em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(typeMappingModel);
            em.getTransaction().commit();
        }catch(Exception e) {
            fail();
        } finally {
            em.close();
        }
        
    }
}
