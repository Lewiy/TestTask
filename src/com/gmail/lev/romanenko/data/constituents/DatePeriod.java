package com.gmail.lev.romanenko.data.constituents;

import java.util.Date;
import java.util.Objects;

public class DatePeriod {
    private Date startPeriod, endPeriod;

    public DatePeriod(Date startPeriod, Date endPeriod) {
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
    }

    public Date getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Date startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Date getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Date endPeriod) {
        this.endPeriod = endPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatePeriod datePeriod = (DatePeriod) o;
        return Objects.equals(this.startPeriod, datePeriod.endPeriod) &&
                Objects.equals(this.startPeriod, datePeriod.endPeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.startPeriod, this.endPeriod);
    }

}
