package com.techelevator.model;

import java.util.Arrays;

public class Card {

    private int cardId;
    private String subject;
    private String question;
    private String tags;
    private String answer;
    private int userId;

    public Card(){

    }

    public Card(int cardId, String subject, String question, String tags, String answer, int userId) {
        this.cardId = cardId;
        this.subject = subject;
        this.question = question;
        this.tags = tags;
        this.answer = answer;
        this.userId = userId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
