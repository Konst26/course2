package com.kursovaya2.kursovaya_rabota2.service;

import com.kursovaya2.kursovaya_rabota2.dto.Question;
import com.kursovaya2.kursovaya_rabota2.exceptions.IncorrectQuestionAmountException;
import com.kursovaya2.kursovaya_rabota2.service.service.JavaQuestionService;
import com.kursovaya2.kursovaya_rabota2.service.service.service.ExaminerService;
import com.kursovaya2.kursovaya_rabota2.service.service.service.ExaminerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    private static final Random RANDOM = new Random();

    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

@ParameterizedTest
@ValueSource(ints = {5, 100})

    void getQuestionTest(int amount) {


    when(questionService.getRandomQuestion())
            .thenAnswer(invocation -> new Question(
                    RANDOM.nextLong() + "",
                    RANDOM.nextLong() + ""));

        //when
    Collection<Question> actualQuestion = examinerService.getQuestion(amount);

    //then
    assertEquals(amount, actualQuestion.size());
    Mockito.verify(questionService, atLeast(amount)).getRandomQuestion();
    }



    @ParameterizedTest
    @ValueSource(ints = {0, -1})

    void getQuestionsNegativeTest(int amount) {
    assertThrows(IncorrectQuestionAmountException.class, () -> examinerService.getQuestion(amount));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10})

    void getQuestionsNegative1Test(int amount) {

    Collection<Question> questionCollection = IntStream.generate(RANDOM :: nextInt)
            .limit(amount -1)
            .boxed()
                            .map(Objects :: toString)
                                    .map(s -> new Question(s, s))
                                            .toList();

    when(questionService.getAll())
            .thenReturn(questionCollection);
    }




}