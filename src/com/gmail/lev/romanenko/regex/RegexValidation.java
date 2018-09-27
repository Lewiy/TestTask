package com.gmail.lev.romanenko.regex;

import com.gmail.lev.romanenko.constants.Constants;
import com.gmail.lev.romanenko.exception.InvalidDataFileDatePeriod;
import com.gmail.lev.romanenko.exception.InvalidDataFileQuestion;
import com.gmail.lev.romanenko.exception.InvalidDataFileResponse;
import com.gmail.lev.romanenko.exception.InvalidDataFileService;

public class RegexValidation {
    public static boolean validationService(String service) throws InvalidDataFileService {
        if (service.matches(Constants.SERVICE_REG)) {
            return true;
        }
        throw new InvalidDataFileService(Constants.VALIDATION_DATA_EXEPTION);
    }

    public static boolean validationQuestionType(String question) throws InvalidDataFileQuestion {
        if (question.matches(Constants.QUESTION_REG)) {
            return true;
        }
        throw new InvalidDataFileQuestion(Constants.VALIDATION_DATA_EXEPTION);
    }

    public static boolean validationResponseType(String responseType) throws InvalidDataFileResponse {
        if (responseType.matches(Constants.RESPONSE_REG)) {
            return true;
        }
        throw new InvalidDataFileResponse(Constants.VALIDATION_DATA_EXEPTION);
    }

    public static boolean validationDate(String validationDate) throws InvalidDataFileDatePeriod {
        if (validationDate.matches(Constants.DATE_REGEX)) {
            return true;
        }
        throw new InvalidDataFileDatePeriod(Constants.VALIDATION_DATA_EXEPTION);
    }

}
