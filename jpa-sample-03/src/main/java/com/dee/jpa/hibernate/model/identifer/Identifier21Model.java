package com.dee.jpa.hibernate.model.identifer;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * @author dien.nguyen
 */

@Entity
@Table(name = "identifier_21")
public class Identifier21Model implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @TableGenerator(name="identifier_21_gen",
        table="generated_keys",
        pkColumnName="gen_id",
        valueColumnName="gen_value",
        pkColumnValue="id_21",
        allocationSize=2,
        initialValue = 10
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "identifier_21_gen")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
