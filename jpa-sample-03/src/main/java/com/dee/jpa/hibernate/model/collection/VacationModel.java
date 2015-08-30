package com.dee.jpa.hibernate.model.collection;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author dien.nguyen
 */

@Embeddable
public class VacationModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Calendar startDate;
    
    @Column(name = "taken_days")
    private int takenDays;

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public int getTakenDays() {
        return takenDays;
    }

    public void setTakenDays(int takenDays) {
        this.takenDays = takenDays;
    }

}
