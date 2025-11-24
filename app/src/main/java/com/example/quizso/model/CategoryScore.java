package com.example.quizso.model;

public class CategoryScore {
    private String username;
    private Category category;
    private int attempts;
    private double bestScore;
    private double lastScore;
    private int questionsAnswered;
    private String lastPlayedDate;

    public CategoryScore() {
    }

    public CategoryScore(String username, Category category, int attempts, 
                        double bestScore, double lastScore, int questionsAnswered, 
                        String lastPlayedDate) {
        this.username = username;
        this.category = category;
        this.attempts = attempts;
        this.bestScore = bestScore;
        this.lastScore = lastScore;
        this.questionsAnswered = questionsAnswered;
        this.lastPlayedDate = lastPlayedDate;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public double getBestScore() {
        return bestScore;
    }

    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }

    public double getLastScore() {
        return lastScore;
    }

    public void setLastScore(double lastScore) {
        this.lastScore = lastScore;
    }

    public int getQuestionsAnswered() {
        return questionsAnswered;
    }

    public void setQuestionsAnswered(int questionsAnswered) {
        this.questionsAnswered = questionsAnswered;
    }

    public String getLastPlayedDate() {
        return lastPlayedDate;
    }

    public void setLastPlayedDate(String lastPlayedDate) {
        this.lastPlayedDate = lastPlayedDate;
    }
}
