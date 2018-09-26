package com.gmail.lev.romanenko.data.line;

import com.gmail.lev.romanenko.data.constituents.Question;
import com.gmail.lev.romanenko.data.constituents.Response;
import com.gmail.lev.romanenko.data.constituents.ServiceEntity;

public abstract class Line {
    protected ServiceEntity serviceEntity;
    protected Question questionType;
    protected Response responseType;

    public Line(ServiceEntity serviceEntity, Question questionType, Response responseType) {
        this.serviceEntity = serviceEntity;
        this.questionType = questionType;
        this.responseType = responseType;
    }

    public Line() {
    }

    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    public Question getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Question questionType) {
        this.questionType = questionType;
    }

    public Response getResponseType() {
        return responseType;
    }

    public void setResponseType(Response responseType) {
        this.responseType = responseType;
    }
}
