package com.gmail.lev.romanenko.constants;

public interface Constants {

    int COUNT_LINES_MUX = 100000;
    int COUNT_LINES_MIN = 1;

    String SPECIAL_VALUE = "*";
    String DASH = "-";
    int NUMBER_OF_CATEGORIES = 2;
    int NUMBER_OF_DATES = 1;
    String QUERY_LINE = "D";
    String WAITING_LINE = "C";
    String LINE_SPLITER = " ";
    String SERVICE_REG = "(([1-9]|10)(\\.[1-3])?)|\\*";
    String RESPONSE_REG = "P|N|\\*";
    String DATE_REGEX = "dd.MM.yyyy";
    String DATE_SPLITER = "\\-";
    String QUESTION_REG = "((10|[1-9])(\\.([1-9]|[1][0-9]|20)(\\.[1-5])?)?)|\\*";
    String NUMBER_SPLITER = "\\.";
    String VALIDATION_DATA_EXEPTION = "";
}
