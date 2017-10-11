package fr.codevallee.formation.tp7bapp;

import java.io.Serializable;

/**
 * Created by maximerevel on 11/10/2017.
 */

public class Question {
    /**
     * Represents a question, its two possible answers and the true one.
     */
    private String question;
    private String answerOne;
    private String answerTwo;
    private int trueAnswer; // starts at one

    public Question(String question, String answerOne, String answerTwo, int trueAnswer) {
        this.question = question;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.trueAnswer = trueAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(int trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
}
