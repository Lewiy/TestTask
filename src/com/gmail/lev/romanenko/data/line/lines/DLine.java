package com.gmail.lev.romanenko.data.line.lines;

import com.gmail.lev.romanenko.data.constituents.DatePeriod;
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
}
