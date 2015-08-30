package com.dee.jpa.hibernate.model.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "cln_owner")
public class OwnerModel implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ElementCollection
    @CollectionTable(name = "owner_emails", joinColumns = {@JoinColumn(name = "owner_id")})
    @Column(name = "email")
    private List<String> emails = new ArrayList<String>();
    
    @ElementCollection(targetClass = VacationModel.class)
    @CollectionTable(name = "owner_vacations", joinColumns = {@JoinColumn(name = "owner_id")})
    @AttributeOverrides(value = {@AttributeOverride(name = "takenDays",column = @Column(name = "days"))})
    private List<VacationModel> vacations = new ArrayList<VacationModel>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<VacationModel> getVacations() {
        return vacations;
    }

    public void setVacations(List<VacationModel> vacations) {
        this.vacations = vacations;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

}
