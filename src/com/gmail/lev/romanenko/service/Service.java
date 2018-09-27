package com.gmail.lev.romanenko.service;

import com.gmail.lev.romanenko.constants.Constants;
import com.gmail.lev.romanenko.data.constituents.Question;
import com.gmail.lev.romanenko.data.constituents.Response;
import com.gmail.lev.romanenko.data.constituents.ServiceEntity;
import com.gmail.lev.romanenko.data.line.lines.CLine;
import com.gmail.lev.romanenko.data.line.lines.DLine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class Service {

    private List<String> result = new ArrayList<String>();

    public List<String> getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public void writeDataToResult(int totalSec, int mached) {
        if (mached != 0) {
            result.add(Integer.toString(totalSec / mached));
        } else {
            result.add(Constants.DASH);
        }
    }

    private boolean compareQuestion(Question Cquestion, Question Dquestion) {
        return Dquestion.getQuestion().equals(Constants.SPECIAL_VALUE) ||
                Dquestion.equals(Cquestion);
    }

    private boolean compareResponse(Response responseTypeD, Response responseTypeC) {
        return responseTypeD.getResponce().equals(Constants.SPECIAL_VALUE) || responseTypeD.equals(responseTypeC);
    }

    public void compare(Map<DLine, List<CLine>> data) {
        for (Map.Entry<DLine, List<CLine>> entry : data.entrySet()) {
            int totalSec = 0, mached = 0;
            for (CLine cLine : entry.getValue()) {
                if (compareCDLines(cLine, entry.getKey())) {
                    mached++;
                    totalSec += cLine.getWaitingTime();
                }
            }
            writeDataToResult(totalSec, mached);
        }
    }

    private boolean compareServise(ServiceEntity Dservice, ServiceEntity Cservice) {
        return Dservice.equals(Cservice)|| Dservice.getService().equals(Constants.SPECIAL_VALUE);
    }

    private boolean compareDate(Date cDate, Date dDateStart, Date dDateEnd) {
        return cDate.after(dDateStart) && cDate.before(dDateEnd);
    }

    private boolean compareCDLines(CLine cLine, DLine dLine) {
        return compareServise(cLine.getServiceEntity(), dLine.getServiceEntity())
                && compareQuestion(cLine.getQuestionType(), dLine.getQuestionType())
                && compareResponse(cLine.getResponseType(), dLine.getResponseType())
                && compareDate(cLine.getDate(), dLine.getDatePeriod().getStartPeriod()
                , dLine.getDatePeriod().getEndPeriod());
    }
}
