package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.Deck;

import java.util.List;

public interface CardDao {

    List<Card> getCards(int userId);

    Card getCardById(int cardId);

    int createCard(Card card);

    public int updateCard(int cardId, Card card);

    List<Deck> getDecks(int userId);

    int createDeck(Deck deck);

    int getNumberOfCards(int deckId);

    void putCardsInDeck(int deckId, int cardID);

    List<Card> getCardsByDeckId(int deckId);

    List<Card> getExcludedCards(int deckId);

    int clearCardDeck(int deckId);
}
