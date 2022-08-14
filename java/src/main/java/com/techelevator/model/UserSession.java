package com.techelevator.model;

public class UserSession {

    private String deckStudied;
    private int totalCards;
    private int totalCorrect;
    private int totalIncorrect;
    private int userId;

    public UserSession() {}

    public UserSession(String deckStudied, int totalCards, int totalCorrect, int totalIncorrect, int user_id) {
        this.deckStudied = deckStudied;
        this.totalCards = totalCards;
        this.totalCorrect = totalCorrect;
        this.totalIncorrect = totalIncorrect;
        this.userId = user_id;
    }

    public String getDeckStudied() {
        return deckStudied;
    }

    public void setDeckStudied(String deckStudied) {
        this.deckStudied = deckStudied;
    }

    public int getTotalCards() {
        return totalCards;
    }

    public void setTotalCards(int totalCards) {
        this.totalCards = totalCards;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
    }

    public int getTotalIncorrect() {
        return totalIncorrect;
    }

    public void setTotalIncorrect(int totalIncorrect) {
        this.totalIncorrect = totalIncorrect;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
