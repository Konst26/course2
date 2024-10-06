package com.kursovaya2.kursovaya_rabota2.service;

import com.kursovaya2.kursovaya_rabota2.dto.Question;
import com.kursovaya2.kursovaya_rabota2.service.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

@Test
    void addTest() {
        int questionCount = questionService.getAll().size();

        //when
        questionService.add(new Question(null, null));
        questionService.add(new Question(null, " "));
        questionService.add(new Question(" ", " "));

        //then
        int actualQuestionCount = questionService.getAll().size();
        int expectedQuestionCount = questionCount + 3;
        assertEquals(expectedQuestionCount, actualQuestionCount);
    }

    @Test
    void removeTest() {

        questionService.add(new Question(null, null));
        questionService.add(new Question(null, " "));
        questionService.add(new Question(" ", " "));

        int questionCount = questionService.getAll().size();


        Set<Question> questionToRemove = questionService.getAll()
                .stream()
                .limit(questionCount - 1)
                .collect(Collectors.toSet());

        //when
        questionToRemove.forEach(questionService::remove);

        //then
        Collection<Question> actualQuestions = questionService.getAll();
        assertEquals(1, actualQuestions.size());

        boolean isRemovingCorrect = actualQuestions.stream()
                .noneMatch(questionToRemove::contains);
        assertTrue(isRemovingCorrect);
    }

    @Test
    void getRandomQuestionTest() {

    Set<Question> questionToRemove = new HashSet<>(questionService.getAll());

    //when
    questionToRemove.forEach(questionService::remove);

    //then
        assertThrows(IllegalStateException.class, questionService :: getRandomQuestion);
        }





}
