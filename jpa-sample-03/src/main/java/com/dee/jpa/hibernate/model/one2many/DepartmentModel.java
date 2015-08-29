package com.dee.jpa.hibernate.model.one2many;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "o2m_department")
public class DepartmentModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String depName;
    
    @OneToMany(mappedBy = "department")
    private List<ProfessorModel> professors = new ArrayList<ProfessorModel>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<ProfessorModel> getProfessors() {
        return professors;
    }

    public void setProfessors(List<ProfessorModel> professors) {
        this.professors = professors;
    }

}
