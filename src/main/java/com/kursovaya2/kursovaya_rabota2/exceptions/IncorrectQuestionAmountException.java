package com.kursovaya2.kursovaya_rabota2.exceptions;

public class IncorrectQuestionAmountException extends RuntimeException {
    public IncorrectQuestionAmountException() {
    }

    public IncorrectQuestionAmountException(String message) {
        super(message);
    }

    public IncorrectQuestionAmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectQuestionAmountException(Throwable cause) {
        super(cause);
    }

    public IncorrectQuestionAmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
