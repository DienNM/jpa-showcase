package com.dee.jpa.hibernate.model.many2many;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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
@Table(name = "m2m_team")
public class TeamModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @ManyToMany
    @JoinTable(name = "m2m_dev_team_role", joinColumns = {@JoinColumn(name = "team_id")}, 
                inverseJoinColumns = {@JoinColumn(name = "dev_id")})
    private Map<DevTeamRole, DevModel> devRoles = new HashMap<DevTeamRole, DevModel>();

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

    public Map<DevTeamRole, DevModel> getDevRoles() {
        return devRoles;
    }
    
    public void setDevRoles(Map<DevTeamRole, DevModel> devRoles) {
        this.devRoles = devRoles;
    }
}
