package com.dee.jpa.hibernate.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dee.jpa.hibernate.enumeration.AccountStatus;
import com.dee.jpa.hibernate.enumeration.Gender;
import com.dee.jpa.hibernate.enumeration.MarriageStatus;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "enumberation_mapping")
public class EnumerationMappingModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Gender gender;

    @Enumerated(EnumType.ORDINAL)
    private MarriageStatus marriedStatus;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MarriageStatus getMarriedStatus() {
        return marriedStatus;
    }

    public void setMarriedStatus(MarriageStatus marriedStatus) {
        this.marriedStatus = marriedStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

}
