package com.dee.jpa.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "large_object_mapping")
public class LargeObjectMappingModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // char[]. Characters, String -> CLOB
    @Lob
    //LONGTEXT
    private char[] clobValueChars;
    
    @Lob
    //LONGTEXT
    private String clobValueString;

    // byte[], Byte[] -> BLOB: Binary Large Object
    @Lob
    // LONGBLOB
    private byte[] blobValue;
    
    @Column(length = 21829) 
    private String stringValue;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char[] getClobValueChars() {
        return clobValueChars;
    }

    public void setClobValueChars(char[] clobValueChars) {
        this.clobValueChars = clobValueChars;
    }

    public String getClobValueString() {
        return clobValueString;
    }

    public void setClobValueString(String clobValueString) {
        this.clobValueString = clobValueString;
    }

    public byte[] getBlobValue() {
        return blobValue;
    }

    public void setBlobValue(byte[] blobValue) {
        this.blobValue = blobValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

}
