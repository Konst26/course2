package com.kursovaya2.kursovaya_rabota2.service;

import com.kursovaya2.kursovaya_rabota2.dto.Question;

import java.util.Collection;

public interface QuestionService {

    default Question add(String question, String answer) {
        return this.add(
                new Question(question, answer));

    }

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
