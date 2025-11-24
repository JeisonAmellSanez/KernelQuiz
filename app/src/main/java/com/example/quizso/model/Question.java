package com.example.quizso.model;

import java.util.List;

public class Question {
    private String questionText;
    private List<AnswerOption> options;
    private Category category;

    public Question(String questionText, List<AnswerOption> options, Category category) {
        this.questionText = questionText;
        this.options = options;
        this.category = category;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<AnswerOption> getOptions() {
        return options;
    }

    public Category getCategory() {
        return category;
    }
}