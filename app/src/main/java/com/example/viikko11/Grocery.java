package com.example.viikko11;

import java.time.LocalDate;
import java.util.Date;

public class Grocery {

    private String name;
    private String note;

    private Date timeStamp;

    public Grocery(String name, String note, Date time) {
        this.name = name;
        this.note = note;
        this.timeStamp = time;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
