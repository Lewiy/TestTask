package com.gmail.lev.romanenko.data.line.lines;

import java.util.Date;

public class CLine {
    private int time;
    private Date date;

    public CLine(int time, Date date) {
        this.time = time;
        this.date = date;
    }

    public int getTime() {
        return time;

    }

    public void setTime(int time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
