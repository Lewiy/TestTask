package com.gmail.lev.romanenko;

import com.gmail.lev.romanenko.util.Parser;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String fileInput = args[0];
        String fileOutPut = args[1];
        Parser parser = new Parser(fileInput,fileOutPut);
        parser.parseData();
    }
}
