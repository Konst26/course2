package com.kursovaya2.kursovaya_rabota2.service.service.service;

import com.kursovaya2.kursovaya_rabota2.dto.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);
}