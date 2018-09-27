package com.gmail.lev.romanenko;

import com.gmail.lev.romanenko.regex.RegexValidation;
import com.gmail.lev.romanenko.service.Service;
import com.gmail.lev.romanenko.util.OutPut;
import com.gmail.lev.romanenko.util.Parser;

public class Main {

    static String fileInput,fileOutPut;

    public static void main(String[] args) {

         fileInput  = args[0];
         fileOutPut = args[1];

        Parser parser = new Parser(fileInput,new RegexValidation());

        Service service = new Service();
        service.compare(parser.parseData().getDAndCLines());

        OutPut outData = new OutPut(service.getResult(),fileOutPut);
        OutPut.writeToConsol();
        OutPut.writeToFile();
    }

}
