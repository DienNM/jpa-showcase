package com.dee.jpa.hibernate.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.bytecode.internal.javassist.FieldHandled;
import org.hibernate.bytecode.internal.javassist.FieldHandler;

/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "fetching_mapping")
public class FetchingMappingModel implements Serializable, FieldHandled {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private FieldHandler  fieldHandler;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "_lazy")
    private byte[] lazyFetchingValue;

    @Basic(fetch = FetchType.EAGER)
    @Column(name = "_eager")
    private String eagerFetchingValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getLazyFetchingValue() {
        if(lazyFetchingValue != null) { 
            return lazyFetchingValue;
        }
        if (fieldHandler == null) { 
            return null;
        }
        return (byte[]) fieldHandler.readObject(this, "lazyFetchingValue", lazyFetchingValue); 
    }

    public void setLazyFetchingValue(byte[] lazyFetchingValue) {
        this.lazyFetchingValue = lazyFetchingValue;
    }

    public String getEagerFetchingValue() {
        return eagerFetchingValue;
    }

    public void setEagerFetchingValue(String eagerFetchingValue) {
        this.eagerFetchingValue = eagerFetchingValue;
    }

    public FieldHandler getFieldHandler() {
        return fieldHandler;
    }

    public void setFieldHandler(FieldHandler fieldHandler) {
        this.fieldHandler = fieldHandler;
    }

}
