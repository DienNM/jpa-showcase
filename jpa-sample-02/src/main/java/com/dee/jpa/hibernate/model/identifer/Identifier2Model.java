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
@Table(name = "identifier_2")
public class Identifier2Model implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @TableGenerator(name="identifier_2_gen",
        table="generated_keys",
        pkColumnName="gen_id",
        valueColumnName="gen_value",
        pkColumnValue="id_2",
        allocationSize=10,
        initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "identifier_2_gen")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
