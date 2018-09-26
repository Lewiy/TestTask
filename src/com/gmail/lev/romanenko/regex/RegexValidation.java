package com.gmail.lev.romanenko.regex;

import com.gmail.lev.romanenko.Constants.Constants;
import com.gmail.lev.romanenko.exception.InvalidDataFileQuestion;
import com.gmail.lev.romanenko.exception.InvalidDataFileResponse;
import com.gmail.lev.romanenko.exception.InvalidDataFileService;

public class RegexValidation {
    public static boolean validationService(String query) throws InvalidDataFileService {
        if (query.matches(Constants.SERVICE_REG)) {
            return true;
        }
        throw new InvalidDataFileService(Constants.VALIDATION_DATA_EXEPTION);
    }

    public static boolean validationQuestionType(String query) throws InvalidDataFileQuestion {
        if (query.matches(Constants.QUESTION_REG)) {
            return true;
        }
        throw new InvalidDataFileQuestion(Constants.VALIDATION_DATA_EXEPTION);
    }

    public static boolean validationResponseType(String query) throws InvalidDataFileResponse {
        if (query.matches(Constants.RESPONSE_REG)) {
            return true;
        }
        throw new InvalidDataFileResponse(Constants.VALIDATION_DATA_EXEPTION);
    }

}
