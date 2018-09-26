package com.gmail.lev.romanenko.util;

import com.gmail.lev.romanenko.Constants.Constans;
import com.gmail.lev.romanenko.data.line.lines.CLine;
import com.gmail.lev.romanenko.data.line.lines.DLine;
import com.gmail.lev.romanenko.regex.Regex;

import java.nio.file.Files;
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
           String[] parts =  sc.next().split(Regex.LINE_SPLITER);
           if(parts[0].equals(Constans.WAITING_LINE)){
               CLine cLine = new CLine();
               cLine.setService();
               cLine.setQuestionType();
               cLine.setResponseType();
               cLine.setDate();
               cLine.setWaitingTime();

           }else if(parts[0].equals(Constans.QUERY_LINE)){
               DLine dLine = new DLine();
               dLine.setService();
               dLine.setQuestionType();
               dLine.setResponseType();
               dLine.setDatePeriod();
            }
            System.out.println(sc.nextLine());
        }

    }
}
