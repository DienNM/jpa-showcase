package com.dee.jpa.hibernate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Assert;

import com.dee.jpa.hibernate.model.TypeMapping4Model;

/**
 * @author dien.nguyen
 **/

public class JPASampleMapping4Test extends TestCase{
    
    private TypeMapping4Model createTypeMappingModel() {
        TypeMapping4Model typeMappingModel = new TypeMapping4Model();
        
        typeMappingModel.setBigIntValue(new BigInteger("9999"));
        typeMappingModel.setBigDecimalValue(new BigDecimal("99999999999.2222222222"));
        
        typeMappingModel.setCalendarValue(Calendar.getInstance());
        typeMappingModel.setTimeStampDateValue(Calendar.getInstance().getTime());
        typeMappingModel.setUtilDateValue(Calendar.getInstance().getTime());
        
        typeMappingModel.setSqlDate(new Date(System.currentTimeMillis()));
        typeMappingModel.setSqlTime(new Time(System.currentTimeMillis()));
        typeMappingModel.setSqlTimestamp(new Timestamp(System.currentTimeMillis()));
        
        return typeMappingModel;
    }

    public void testJPA_MappingType() {
        TypeMapping4Model typeMappingModel = createTypeMappingModel();
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
