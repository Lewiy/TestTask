package com.gmail.lev.romanenko.util;

import com.gmail.lev.romanenko.Constants.Constants;
import com.gmail.lev.romanenko.data.constituents.DatePeriod;
import com.gmail.lev.romanenko.data.constituents.Question;
import com.gmail.lev.romanenko.data.constituents.Response;
import com.gmail.lev.romanenko.data.constituents.Service;
import com.gmail.lev.romanenko.data.line.lines.CLine;
import com.gmail.lev.romanenko.data.line.lines.DLine;
import com.gmail.lev.romanenko.regex.RegexValidation;

import java.util.Date;
import java.util.Scanner;

public class Parser {

    String fileInput, fileOutPut;

    public Parser(String fileInput, String fileOutPut) {
        this.fileInput = fileInput;
        this.fileOutPut = fileOutPut;
    }


    public void parseData() {

        Scanner sc = new Scanner(fileInput);

        while (sc.hasNextLine()){
           String[] parts =  sc.next().split(RegexValidation.LINE_SPLITER);
           if(parts[0].equals(Constants.WAITING_LINE)){
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

           }else if(parts[0].equals(Constants.QUERY_LINE)){
               DLine.Builder()
                       .datePeriod()
                       .build;
            }
            System.out.println(sc.nextLine());
        }

    }

    private Service createService(){

    }

    private Question createQuestion(){

    }

    private Response createResponseType(){

    }

    private DatePeriod createDatePeriod(){

    }

    private Date createDate(){

    }
}
