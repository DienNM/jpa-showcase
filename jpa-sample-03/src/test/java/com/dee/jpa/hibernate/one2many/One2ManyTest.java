package com.dee.jpa.hibernate.one2many;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Assert;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.model.one2many.ClassModel;
import com.dee.jpa.hibernate.model.one2many.DepartmentModel;
import com.dee.jpa.hibernate.model.one2many.ProfessorModel;
import com.dee.jpa.hibernate.model.one2many.StudentModel;

/**
 * @author dien.nguyen
 */

public class One2ManyTest extends TestCase{

    public void testUndirectionOne2Many() {
        
        StudentModel student1 = new StudentModel();
        student1.setName("Dien Nguyen 01");
        
        StudentModel student2 = new StudentModel();
        student2.setName("Dien Nguyen 02");
        
        ClassModel clazz = new ClassModel();
        clazz.setName("12A7");
        clazz.getStudents().add(student1);
        clazz.getStudents().add(student2);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(student1);
        em.persist(student2);
        em.persist(clazz);
        em.getTransaction().commit();
        em.close();
        
        // Load
        em = EntityManagerUtil.getEntityManager();
        ClassModel pClazz = em.find(ClassModel.class, clazz.getId());
        
        Assert.assertNotNull(pClazz);
        Assert.assertNotNull(pClazz.getStudents());
        Assert.assertEquals(2, pClazz.getStudents().size());
        Assert.assertNotNull(pClazz.getStudents().get(0));
        Assert.assertNotNull(pClazz.getStudents().get(1));
    }
    
    public void testBidirectionOne2Many() {
        
        ProfessorModel prof1 = new ProfessorModel();
        prof1.setName("Dien Nguyen 01");
        
        ProfessorModel prof2 = new ProfessorModel();
        prof2.setName("Dien Nguyen 02");
        
        DepartmentModel department = new DepartmentModel();
        department.setDepName("IT");
        department.getProfessors().add(prof1);
        department.getProfessors().add(prof2);
        
        
        prof1.setDepartment(department);
        prof2.setDepartment(department);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(prof1);
        em.persist(prof2);
        em.persist(department);
        em.getTransaction().commit();
        em.close();
        
        // Load
        em = EntityManagerUtil.getEntityManager();
        DepartmentModel pDept = em.find(DepartmentModel.class, department.getId());
        Assert.assertNotNull(pDept);
        Assert.assertNotNull(pDept.getProfessors());
        Assert.assertEquals(2, pDept.getProfessors().size());
        Assert.assertNotNull(pDept.getProfessors().get(0));
        Assert.assertNotNull(pDept.getProfessors().get(1));
        
        
        ProfessorModel pProf1 = em.find(ProfessorModel.class, prof1.getId());
        ProfessorModel pProf2 = em.find(ProfessorModel.class, prof2.getId());
        
        Assert.assertNotNull(pProf1);
        Assert.assertNotNull(pProf2);

        Assert.assertNotNull(pProf1.getDepartment());
        Assert.assertNotNull(pProf2.getDepartment());
        
        em.close();
        
    }
    
}
