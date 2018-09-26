package com.gmail.lev.romanenko.data.line.lines;

import com.gmail.lev.romanenko.data.line.Line;

import java.util.Date;

public class CLine extends Line {
    private int WaitingTime;
    private Date date;

    public CLine(int time, Date date) {
        this.WaitingTime = time;
        this.date = date;
    }

    public CLine() {
    }

    public int getWaitingTime() {
        return WaitingTime;
    }

    public void setWaitingTime(int time) {
        this.WaitingTime = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
