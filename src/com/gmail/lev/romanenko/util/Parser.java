package com.gmail.lev.romanenko.util;

import com.gmail.lev.romanenko.Constants.Constants;
import com.gmail.lev.romanenko.data.Data;
import com.gmail.lev.romanenko.data.constituents.DatePeriod;
import com.gmail.lev.romanenko.data.constituents.Question;
import com.gmail.lev.romanenko.data.constituents.Response;
import com.gmail.lev.romanenko.data.constituents.ServiceEntity;
import com.gmail.lev.romanenko.data.line.lines.CLine;
import com.gmail.lev.romanenko.data.line.lines.DLine;
import com.gmail.lev.romanenko.exception.InvalidDataFileDatePeriod;
import com.gmail.lev.romanenko.exception.InvalidDataFileQuestion;
import com.gmail.lev.romanenko.exception.InvalidDataFileResponse;
import com.gmail.lev.romanenko.exception.InvalidDataFileService;
import com.gmail.lev.romanenko.regex.RegexValidation;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Parser {
    private String fileInput, fileOutPut;
    private RegexValidation regexValidation;

    public Parser(String fileInput, String fileOutPut, RegexValidation regexValidation) {
        this.fileInput = fileInput;
        this.fileOutPut = fileOutPut;
        this.regexValidation = regexValidation;
    }


    public Data parseData() {
        Data data = new Data();
        Map<DLine, List<CLine>> DAndCLines = new LinkedHashMap<>();
        List<CLine> cLines = new ArrayList<>();

      Scanner sc = prepareScanner();
        while (sc.hasNextLine()) {
            String[] parts = sc.nextLine().split(Constants.LINE_SPLITER);
            if (parts[0].equals(Constants.WAITING_LINE)) {
                CLine cLine = null;
                cLine = new CLine.Builder(checkServiceString(parts[1]), checkQuestionString(parts[2]), checkResponseType(parts[3]))
                        .date(createDate(parts[4]))
                        .waitingTime(createWaitingTime(parts[5]))
                        .build();
                cLines.add(cLine);
            } else if (parts[0].equals(Constants.QUERY_LINE)) {
                DLine dLine = null;
                dLine = new DLine.Builder(checkServiceString(parts[1]), checkQuestionString(parts[2]), checkResponseType(parts[3]))
                        .datePeriod(devideDateToPeriod(parts[4]))
                        .build();
                DAndCLines.put(dLine, new ArrayList<>(cLines));
            }
        }
        data.setDAndCLines(DAndCLines);

        return data;
    }

    private Scanner prepareScanner() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileInput));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sc;
    }

    private ServiceEntity checkServiceString(String serviceString) {
        ServiceEntity serviceEntity = null;
        try {
            if (RegexValidation.validationService(serviceString)) {
                serviceEntity = createService(serviceString);
            }
        } catch (InvalidDataFileService invalidDataFileService) {
            invalidDataFileService.printStackTrace();
        }
        return serviceEntity;
    }

    private boolean checkServiceLenght(String[] serviceContains) {
        return serviceContains.length == Constants.NUMBER_OF_CATEGORIES;
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
                 response = createResponseType(responceType);
            }
        } catch (InvalidDataFileResponse invalidDataFileResponse) {
            invalidDataFileResponse.printStackTrace();
        }
        return response;
    }

    private DatePeriod checkDatePeriod(String fromDate, String toDate) {

        DatePeriod datePeriod = null;
        try {
            if (RegexValidation.validationDate(fromDate) && RegexValidation.validationDate(toDate)) {
                createDatePeriod(fromDate, toDate);
            }
        } catch (InvalidDataFileDatePeriod invalidDataFileDatePeriod) {
            invalidDataFileDatePeriod.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datePeriod;
    }

    private ServiceEntity createService(String serviceString) {
        ServiceEntity serviceEntity = null;
        String[] serviceParts = serviceString.split(Constants.NUMBER_SPLITER);
        String serviceId = serviceParts[0];
        if (checkServiceLenght(serviceParts)) {
            serviceEntity = new ServiceEntity(serviceId, createVariation(serviceParts[1]));
        } else {
            serviceEntity = new ServiceEntity(serviceId, null);
        }
        return serviceEntity;
    }

    private ServiceEntity.Variation createVariation(String variation) {
        return new ServiceEntity.Variation(variation);
    }

    private Question createQuestion(String questionString) {
        Question question = null;
        String[] questionParts = questionString.split(Constants.NUMBER_SPLITER);
        if (questionParts.length > Constants.NUMBER_OF_CATEGORIES) {
            question = new Question(questionParts[0], new Question.Category(questionParts[1], new Question.Category.SubCategory(questionParts[2])));
        }
        if (questionParts.length == Constants.NUMBER_OF_CATEGORIES) {
            question = new Question(questionParts[0], new Question.Category(questionParts[1], null));
        } else if(questionParts.length < Constants.NUMBER_OF_CATEGORIES) {
            question = new Question(questionParts[0]);
        }
        return question;
    }

    private Response createResponseType(String responceType) {
        return new Response(responceType);
    }


    private DatePeriod devideDateToPeriod(String undevidedDate) {
        String[] datePeriods = undevidedDate.split(Constants.DATE_SPLITER);
        DatePeriod datePeriod = null;
        try {
            if (datePeriods.length == 1) {

                datePeriod = createDatePeriod(datePeriods[0], null);
            } else {

                datePeriod =  createDatePeriod(datePeriods[0], datePeriods[1]);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datePeriod;
    }

    private DatePeriod createDatePeriod(String fromDateString, String toDateString) throws ParseException {
        return new DatePeriod(createDate(fromDateString), createDate(toDateString));
    }

    private Date createDate(String dateString) {
        if(dateString != null){
            Date date = null;
            SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_REGEX);
            try {
                date = formatter.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        } else return null;
    }

    private int createWaitingTime(String waitingTimeString) {
        int waitingTime = 0;
        waitingTime = Integer.parseInt(waitingTimeString);
        return waitingTime;
    }
}
