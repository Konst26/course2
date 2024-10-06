package com.kursovaya2.kursovaya_rabota2.service.service;

import com.kursovaya2.kursovaya_rabota2.dto.Question;
import com.kursovaya2.kursovaya_rabota2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private static final Random RANDOM = new Random();

    private final Set<Question> questionsSet = new HashSet<>();

    @Override
    public Question add(Question question) {
        questionsSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionsSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionsSet);
    }

    @Override
    public Question getRandomQuestion() {
        if (questionsSet.isEmpty()) {
            throw new IllegalStateException("Список вопросов пустой");
        }

        int questionIndex = RANDOM.nextInt(questionsSet.size());
        return new ArrayList<>(questionsSet).get(questionIndex);
    }
}