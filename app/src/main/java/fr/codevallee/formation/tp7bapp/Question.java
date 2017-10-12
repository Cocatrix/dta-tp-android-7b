package fr.codevallee.formation.tp7bapp;

import java.io.Serializable;

/**
 * @author maximerevel
 * @date 11/10/2017
 * This class represents a question with its possible answers and the true answer's number.
 */

public class Question {

    private String question;
    private String answerOne;
    private String answerTwo;
    private int trueAnswer; // starts at one
    /**
     * @param question Question to be asked
     * @param answerOne First possible answer
     * @param answerTwo Second possible answer
     * @param trueAnswer Number of the true answer (1 or 2)
     * Represents a question, its two possible answers and the true one.
     */
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
