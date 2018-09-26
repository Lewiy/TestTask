package com.gmail.lev.romanenko.data.line.lines;

import com.gmail.lev.romanenko.data.constituents.DatePeriod;
import com.gmail.lev.romanenko.data.constituents.Question;
import com.gmail.lev.romanenko.data.constituents.Response;
import com.gmail.lev.romanenko.data.constituents.ServiceEntity;
import com.gmail.lev.romanenko.data.line.Line;

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
        private ServiceEntity serviceEntity;
        private Question questionType;
        private Response responseType;
        private DatePeriod datePeriod;

        public Builder(ServiceEntity serviceEntity, Question questionType, Response responseType) {
            this.serviceEntity = serviceEntity;
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
        this.serviceEntity = builder.serviceEntity;
        this.questionType = builder.questionType;
        this.responseType = builder.responseType;
       this.datePeriod = builder.datePeriod;
    }
}
