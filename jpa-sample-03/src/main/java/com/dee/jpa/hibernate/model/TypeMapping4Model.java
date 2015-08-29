package com.dee.jpa.hibernate.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author dien.nguyen
 **/

@Entity
@Table(name = "type_mapping_model_4")
public class TypeMapping4Model implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // DECIMAL(19,2)
    private BigInteger bigIntValue;
    
    // DECIMAL(19,2)
    private BigDecimal bigDecimalValue;
    
    // DATETIME
    @Temporal(TemporalType.TIME)
    // 15:06:19
    private Date utilDateValue;

    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.DATE)
    // 2015-08-29 00:00:00
    private Date timeStampDateValue;
    
    // DATETIME
    @Temporal(TemporalType.TIMESTAMP)
    // 2015-08-29 15:08:06
    private Calendar calendarValue;
    
    @Temporal(TemporalType.DATE)
    // 2015-08-29
    private Calendar calendarDateValue;
    
    // DATE
    private java.sql.Date sqlDate;
    
    // TIME
    private Time sqlTime;
    
    // DATETIME
    private Timestamp sqlTimestamp;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getBigIntValue() {
        return bigIntValue;
    }

    public void setBigIntValue(BigInteger bigIntValue) {
        this.bigIntValue = bigIntValue;
    }

    public BigDecimal getBigDecimalValue() {
        return bigDecimalValue;
    }

    public void setBigDecimalValue(BigDecimal bigDecimalValue) {
        this.bigDecimalValue = bigDecimalValue;
    }

    public Date getUtilDateValue() {
        return utilDateValue;
    }

    public void setUtilDateValue(Date utilDateValue) {
        this.utilDateValue = utilDateValue;
    }

    public Calendar getCalendarValue() {
        return calendarValue;
    }

    public void setCalendarValue(Calendar calendarValue) {
        this.calendarValue = calendarValue;
    }

    public java.sql.Date getSqlDate() {
        return sqlDate;
    }

    public void setSqlDate(java.sql.Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    public Time getSqlTime() {
        return sqlTime;
    }

    public void setSqlTime(Time sqlTime) {
        this.sqlTime = sqlTime;
    }

    public Timestamp getSqlTimestamp() {
        return sqlTimestamp;
    }

    public void setSqlTimestamp(Timestamp sqlTimestamp) {
        this.sqlTimestamp = sqlTimestamp;
    }

    public Date getTimeStampDateValue() {
        return timeStampDateValue;
    }

    public void setTimeStampDateValue(Date timeStampDateValue) {
        this.timeStampDateValue = timeStampDateValue;
    }

    public Calendar getCalendarDateValue() {
        return calendarDateValue;
    }

    public void setCalendarDateValue(Calendar calendarDateValue) {
        this.calendarDateValue = calendarDateValue;
    }
    
}
