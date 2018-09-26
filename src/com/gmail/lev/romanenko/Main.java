package com.gmail.lev.romanenko;

import com.gmail.lev.romanenko.regex.RegexValidation;
import com.gmail.lev.romanenko.service.Service;
import com.gmail.lev.romanenko.util.Parser;

public class Main {

    static String fileInput,fileOutPut;

    public static void main(String[] args) {
	// write your code here
       fileInput = args[0];
       fileOutPut = args[1];
        Parser parser = new Parser(fileInput,fileOutPut,new RegexValidation());
        Service service = new Service();

        service.compare(parser.parseData().getDAndCLines());
        service.getResult().toString();
        for (String string: service.getResult()){
            System.out.println(string);
        }
    }


}
