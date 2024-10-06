package com.kursovaya2.kursovaya_rabota2.controller;

import com.kursovaya2.kursovaya_rabota2.dto.Question;
import com.kursovaya2.kursovaya_rabota2.exceptions.IncorrectQuestionAmountException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RestController
public abstract class ExamController {

    @GetMapping("/exam")
    public Collection<Question> getQuestion(int amount) {

        Collection<Question> result = new HashSet<>();

        return new HashSet<>();

    }
}