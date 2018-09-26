package com.gmail.lev.romanenko.data.line.lines;

import com.gmail.lev.romanenko.data.constituents.Question;
import com.gmail.lev.romanenko.data.constituents.Response;
import com.gmail.lev.romanenko.data.constituents.Service;
import com.gmail.lev.romanenko.data.line.Line;

import java.util.Date;

public class CLine extends Line {
    private int waitingTime;
    private Date date;

    public CLine(int time, Date date) {
        this.waitingTime = time;
        this.date = date;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int time) {
        this.waitingTime = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static class Builder {
        private Service service;
        private Question questionType;
        private Response responseType;
        private int waitingTime;
        private Date date;

        public Builder(Service service, Question questionType, Response responseType) {
            this.service = service;
            this.questionType = questionType;
            this.responseType = responseType;
        }

        public Builder waitingTime(int waitingTime) {
            this.waitingTime = waitingTime;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }
        public CLine build() {
            return new CLine(this);
        }
    }



    private CLine(Builder builder) {
        this.service = builder.service;
        this.questionType = builder.questionType;
        this.responseType = builder.responseType;
        this.waitingTime = builder.waitingTime;
        this.date = builder.date;
    }
}
