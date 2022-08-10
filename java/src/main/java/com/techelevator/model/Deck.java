package com.techelevator.model;

public class Deck {

    private int DeckId;
    private String name;
    private String subject;
    private String description;
    private int userId;

    public Deck() {}

    public Deck(int deckId, String name, String subject, String description, int userId) {
        DeckId = deckId;
        this.name = name;
        this.subject = subject;
        this.description = description;
        this.userId = userId;
    }

    public int getDeckId() {
        return DeckId;
    }

    public void setDeckId(int deckId) {
        DeckId = deckId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
