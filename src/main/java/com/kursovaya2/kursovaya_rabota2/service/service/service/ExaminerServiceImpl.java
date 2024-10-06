package com.kursovaya2.kursovaya_rabota2.service.service.service;

import com.kursovaya2.kursovaya_rabota2.dto.Question;
import com.kursovaya2.kursovaya_rabota2.exceptions.IncorrectQuestionAmountException;
import com.kursovaya2.kursovaya_rabota2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
                this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestion(int amount) {

        if (amount < 1 || amount > questionService.getAll().size()) {
            throw new IncorrectQuestionAmountException();
        }

        Set<Question> result = new HashSet<>();

        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }












}
