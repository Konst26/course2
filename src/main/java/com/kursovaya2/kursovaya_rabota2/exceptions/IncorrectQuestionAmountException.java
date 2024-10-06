package com.kursovaya2.kursovaya_rabota2.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectQuestionAmountException extends RuntimeException {

}
