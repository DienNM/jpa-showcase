package com.dee.jpa.hibernate.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "type_mapping_model_3")
public class TypeMapping3Model implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // TINYBLOB
    private byte[] byteArrValue;
    
    // TINYBLOB
    private Byte[] byteArrWrapperValue;
    
    // VARCHAR(255)
    private char[] charArrValue;
    
    // VARCHAR(255)
    private Character[] charArrWrapperValue;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getByteArrValue() {
        return byteArrValue;
    }

    public void setByteArrValue(byte[] byteArrValue) {
        this.byteArrValue = byteArrValue;
    }

    public Byte[] getByteArrWrapperValue() {
        return byteArrWrapperValue;
    }

    public void setByteArrWrapperValue(Byte[] byteArrWrapperValue) {
        this.byteArrWrapperValue = byteArrWrapperValue;
    }

    public char[] getCharArrValue() {
        return charArrValue;
    }

    public void setCharArrValue(char[] charArrValue) {
        this.charArrValue = charArrValue;
    }

    public Character[] getCharArrWrapperValue() {
        return charArrWrapperValue;
    }

    public void setCharArrWrapperValue(Character[] charArrWrapperValue) {
        this.charArrWrapperValue = charArrWrapperValue;
    }
    
}
