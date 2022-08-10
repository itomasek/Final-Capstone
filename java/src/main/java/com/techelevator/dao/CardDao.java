package com.techelevator.dao;

import com.techelevator.model.Card;

import java.util.List;

public interface CardDao {

    List<Card> getCards(int userId);

    Card getCardById(int cardId);

    int createCard(Card card);

    public int updateCard(int cardId, Card card);
}
