package com.dee.jpa.hibernate.model.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
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
    @CollectionTable(name = "cln_owner_emails", joinColumns = {@JoinColumn(name = "owner_id")})
    @Column(name = "email")
    private List<String> emails = new ArrayList<String>();
    
    @ElementCollection(targetClass = VacationModel.class)
    @CollectionTable(name = "cln_owner_vacations", joinColumns = {@JoinColumn(name = "owner_id")})
    @AttributeOverrides(value = {@AttributeOverride(name = "takenDays",column = @Column(name = "days"))})
    private List<VacationModel> vacations = new ArrayList<VacationModel>();
    
    
    // MAP
    @ElementCollection
    @CollectionTable(name = "cln_owner_phones", joinColumns = {@JoinColumn(name = "owner")})
    @MapKeyColumn(name = "phone_type")
    @Column(name = "phone_num")
    private Map<String, String> phones = new HashMap<String, String>();
    
    @ElementCollection
    @CollectionTable(name = "cln_owner_webs", joinColumns = {@JoinColumn(name = "owner")})
    @MapKeyColumn(name = "web_type")
    @Column(name = "url")
    // @Enumerated(EnumType.STRING): Apply to Value not KEY
    // @MapKeyTemporal
    @MapKeyEnumerated(EnumType.STRING)
    private Map<SocialNetwork, String> websites = new HashMap<SocialNetwork, String>();

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

    public Map<String, String> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, String> phones) {
        this.phones = phones;
    }

    public Map<SocialNetwork, String> getWebsites() {
        return websites;
    }

    public void setWebsites(Map<SocialNetwork, String> websites) {
        this.websites = websites;
    }

}
