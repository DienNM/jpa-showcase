package com.dee.jpa.hibernate.model.collection;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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
import javax.persistence.MapKeyTemporal;
import javax.persistence.Table;
import javax.persistence.TemporalType;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "cln_map_collection")
public class MapCollectionModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ElementCollection
    @CollectionTable(name = "cln_map_collection_phone", joinColumns = {@JoinColumn(name = "ref_key_id")})
    @MapKeyColumn(name = "phone_type")
    @Column(name = "phone_num")
    private Map<String, String> phones = new HashMap<String, String>();
    
    @ElementCollection
    @CollectionTable(name = "cln_map_collection_vacation", joinColumns = {@JoinColumn(name = "ref_key_id")})
    @MapKeyColumn(name = "start_date_vacation")
    @MapKeyTemporal(TemporalType.DATE)
    @Column(name = "taken_days")
    private Map<Calendar, Integer> vacations = new HashMap<Calendar, Integer>();
    
    @ElementCollection
    @CollectionTable(name = "cln_map_collection_websites", joinColumns = {@JoinColumn(name = "ref_key_id")})
    @MapKeyColumn(name = "web_type")
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name = "url")
    private Map<SocialNetwork, String> websites = new HashMap<SocialNetwork, String>();
    
    @ElementCollection
    @CollectionTable(name = "cln_map_collection_address", joinColumns = {@JoinColumn(name = "ref_key_id")})
    @MapKeyColumn(name = "address_type")
    private Map<String, AddressMapModel> addresses = new HashMap<String, AddressMapModel>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, String> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, String> phones) {
        this.phones = phones;
    }

    public Map<Calendar, Integer> getVacations() {
        return vacations;
    }

    public void setVacations(Map<Calendar, Integer> vacations) {
        this.vacations = vacations;
    }

    public Map<SocialNetwork, String> getWebsites() {
        return websites;
    }

    public void setWebsites(Map<SocialNetwork, String> websites) {
        this.websites = websites;
    }

    public Map<String, AddressMapModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, AddressMapModel> addresses) {
        this.addresses = addresses;
    }
    
}
