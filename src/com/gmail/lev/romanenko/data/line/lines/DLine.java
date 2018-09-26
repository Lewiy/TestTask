package com.gmail.lev.romanenko.data.line.lines;

import com.gmail.lev.romanenko.data.constituents.DatePeriod;
import com.gmail.lev.romanenko.data.constituents.Question;
import com.gmail.lev.romanenko.data.constituents.Response;
import com.gmail.lev.romanenko.data.constituents.Service;
import com.gmail.lev.romanenko.data.line.Line;

import java.util.Date;

public class DLine extends Line {
    private DatePeriod datePeriod;

    public DatePeriod getDatePeriod() {
        return datePeriod;
    }

    public void setDatePeriod(DatePeriod datePeriod) {
        this.datePeriod = datePeriod;
    }

    public DLine(DatePeriod datePeriod) {
        this.datePeriod = datePeriod;
    }

    public static class Builder {
        private Service service;
        private Question questionType;
        private Response responseType;
        private DatePeriod datePeriod;

        public Builder(Service service, Question questionType, Response responseType) {
            this.service = service;
            this.questionType = questionType;
            this.responseType = responseType;
        }

        public Builder datePeriod(DatePeriod datePeriod) {
            this.datePeriod = datePeriod;
            return this;
        }
        public DLine build() {
            return new DLine(this);
        }
    }



    private DLine(Builder builder) {
        this.service = builder.service;
        this.questionType = builder.questionType;
        this.responseType = builder.responseType;
       this.datePeriod = builder.datePeriod;
    }
}
