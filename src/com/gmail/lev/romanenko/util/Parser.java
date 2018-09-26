package com.gmail.lev.romanenko.util;

import com.gmail.lev.romanenko.Constants.Constants;
import com.gmail.lev.romanenko.data.constituents.DatePeriod;
import com.gmail.lev.romanenko.data.constituents.Question;
import com.gmail.lev.romanenko.data.constituents.Response;
import com.gmail.lev.romanenko.data.constituents.Service;
import com.gmail.lev.romanenko.data.line.lines.CLine;
import com.gmail.lev.romanenko.data.line.lines.DLine;
import com.gmail.lev.romanenko.exception.InvalidDataFileDatePeriod;
import com.gmail.lev.romanenko.exception.InvalidDataFileQuestion;
import com.gmail.lev.romanenko.exception.InvalidDataFileResponse;
import com.gmail.lev.romanenko.exception.InvalidDataFileService;
import com.gmail.lev.romanenko.regex.RegexValidation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Parser {
    private String fileInput, fileOutPut;
    private RegexValidation regexValidation;

    public Parser(String fileInput, String fileOutPut, RegexValidation regexValidation) {
        this.fileInput = fileInput;
        this.fileOutPut = fileOutPut;
        this.regexValidation = regexValidation;
    }


    public void parseData() {

        Scanner sc = new Scanner(fileInput);

        while (sc.hasNextLine()) {
            String[] parts = sc.next().split(RegexValidation.LINE_SPLITER);
            if (parts[0].equals(Constants.WAITING_LINE)) {
              /* CLine cLine = new CLine();
               cLine.setService();
               cLine.setQuestionType();
               cLine.setResponseType();
               cLine.setDate();
               cLine.setWaitingTime();*/
                CLine.Builder()
                        .waitingTime()
                        .date()
                        .build;

            } else if (parts[0].equals(Constants.QUERY_LINE)) {
                DLine.Builder()
                        .datePeriod()
                        .build;
            }
            System.out.println(sc.nextLine());
        }

    }

    private Service checkServiceString(String serviceString) {
        Service service = null;
        try {
            if (RegexValidation.validationService(serviceString)) {
                service = createService(serviceString);
            }
        } catch (InvalidDataFileService invalidDataFileService) {
            invalidDataFileService.printStackTrace();
        }
        return service;
    }

    private boolean checkServiceLenght(String[] serviceContains) {
        return serviceContains.length == Constants.NUMBER_OF_ELEMENTS;
    }

    private Question checkQuestionString(String questionString) {

        Question question = null;
        try {
            if (RegexValidation.validationQuestionType(questionString)) {
                question = createQuestion(questionString);
            }
        } catch (InvalidDataFileQuestion invalidDataFileQuestion) {
            invalidDataFileQuestion.printStackTrace();
        }
        return question;
    }

    private Response checkResponseType(String responceType) {
        Response response = null;
        try {
            if (RegexValidation.validationResponseType(responceType)) {
                createService(responceType);
            }
        } catch (InvalidDataFileResponse invalidDataFileResponse) {
            invalidDataFileResponse.printStackTrace();
        }
        return response;
    }

    private DatePeriod checkDatePeriod(String fromDate,String toDate) {

        DatePeriod datePeriod = null;
        try {
            if (RegexValidation.validationDate(fromDate)&& RegexValidation.validationDate(toDate)) {
                createDatePeriod(fromDate,toDate);
            }
        } catch (InvalidDataFileDatePeriod invalidDataFileDatePeriod) {
            invalidDataFileDatePeriod.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datePeriod;
    }
    private Service createService(String serviceString) {
        Service service = null;
        String[] serviceContains = serviceString.split(Constants.NUMBER_SPLITER);
        String serviceId = serviceContains[0];
        if (checkServiceLenght(serviceContains)) {
            service = new Service(serviceId, createVariation(serviceContains[1]));
        } else {
            service = new Service(serviceId, null);
        }
        return service;
    }

    private Service.Variation createVariation(String variation){
        return new Service.Variation(variation);
    }

    private Question createQuestion(String question) {
        return new Question(question);
    }
    private Response createResponseType(String responceType) {
        return new Response(responceType);
    }
    private DatePeriod createDatePeriod(String fromDateString, String toDateString) throws ParseException {
        return new DatePeriod(createDate(fromDateString), createDate(toDateString));
    }
    private Date createDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_REGEX);
        return formatter.parse(dateString);
    }
}
