package com.dee.jpa.hibernate.many2many;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Assert;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.model.many2many.DeveloperModel;
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
    
}
