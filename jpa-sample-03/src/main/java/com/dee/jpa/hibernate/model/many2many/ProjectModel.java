package com.dee.jpa.hibernate.model.many2many;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "m2m_project")
public class ProjectModel implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @ManyToMany
    @JoinTable(name = "m2m_projects_devs", joinColumns = {@JoinColumn(name = "project_id")}, 
                inverseJoinColumns = {@JoinColumn(name = "dev_id")})
    private List<DeveloperModel> developers = new ArrayList<DeveloperModel>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DeveloperModel> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<DeveloperModel> developers) {
        this.developers = developers;
    }
    
}
