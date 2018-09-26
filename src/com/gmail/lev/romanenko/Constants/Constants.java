package com.gmail.lev.romanenko.Constants;

public interface Constants {
    String QUERY_LINE = "D";
    String WAITING_LINE = "C";
    String LINE_SPLITER = " ";
    String SERVICE_REG = "(([1-9]|10)(\\.[1-3])?)|\\*";
    String RESPONSE_REG = "P|N|\\*";
    String DATE_REGEX = "dd.MM.yyyy";
    String WAITING_TIME_REG = "\\d{1,6}";
    String DATE_SPLITER = "\\-";
    String QUESTION_REG = "((10|[1-9])(\\.([1-9]|[1][0-9]|20)(\\.[1-5])?)?)|\\*";
    String NUMBER_SPLITER = "\\.";
    String VALIDATION_DATA_EXEPTION = "";
}
