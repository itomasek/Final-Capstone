package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.Deck;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcCardDao implements CardDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Card> getCards(int userId) {
        List<Card> cards = new ArrayList<>();
        String getCardSql = "SELECT * FROM card WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(getCardSql, userId);
        while (results.next()) {
            Card card = mapRowToCard(results);
            cards.add(card);
        }
        return cards;
    }

    @Override
    public Card getCardById(int cardId) {
        return null;
    }

    @Override
    public int createCard(Card card) {
        String sql = "INSERT INTO card (subject, question, tags, answer, user_id) VALUES (?, ?, ?, ?, ?) RETURNING user_id";
        int userId = jdbcTemplate.queryForObject(sql, Integer.class, card.getSubject(), card.getQuestion(), card.getTags(), card.getAnswer(), card.getUserId());
        return userId;
    }

    public int updateCard(int cardId, Card card) {
        String updateSql = "UPDATE card SET subject = ?, question = ?, tags = ?, answer = ?, user_id = ? WHERE card_id = ?";
        int rowsUpdated = jdbcTemplate.update(updateSql, card.getSubject(), card.getQuestion(), card.getTags(), card.getAnswer(), card.getUserId(), cardId);
        return rowsUpdated;
    }

    @Override
    public List<Deck> getDecks(int userId) {
        List<Deck> decks = new ArrayList<>();
        String getDeckSql = "SELECT * FROM deck WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(getDeckSql, userId);
        while (results.next()) {
            decks.add(mapRowToDeck(results));
        }
        return decks;
    }

    @Override
    public int createDeck(Deck deck) {
        String sql = "INSERT INTO deck (name, subject, description, user_id) VALUES (?, ?, ?, ?) RETURNING deck_id";
        int deckId = jdbcTemplate.queryForObject(sql, Integer.class, deck.getName(), deck.getSubject(), deck.getDescription(), deck.getUserId());
        return deckId;
    }

    @Override
    public int getNumberOfCards(int deckId) {
        String sql = "SELECT COUNT(*) FROM card_deck WHERE deck_id = ?";
        int numberOfCards = jdbcTemplate.queryForObject(sql, Integer.class, deckId);
        return numberOfCards;
    }

    @Override
    public void putCardsInDeck(int cardId, int deckId) {
        String sql = "INSERT INTO card_deck (card_id, deck_id) VALUES (?, ?)";
        jdbcTemplate.queryForObject(sql, Void.class, cardId, deckId);

    }

    @Override
    public List<Card> getCardsByDeckId(int deckId) {
        List<Card> cards = new ArrayList<>();
        String sql = "SELECT * FROM card JOIN card_deck ON card.card_id = card_deck.card_id WHERE deck_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, deckId);
        while (results.next()) {
            cards.add(mapRowToCard(results));
        }
        return cards;
    }

    @Override
    public List<Card> getExcludedCards(int deckId) {
        List<Card> cards = new ArrayList<>();
        String sql = "SELECT * FROM card JOIN card_deck ON card.card_id = card_deck.card_id WHERE deck_id != ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, deckId);
        while (results.next()) {
            cards.add(mapRowToCard(results));
        }
        return cards;
    }

    @Override
    public int clearCardDeck(int deckId) {
        String sql = "DELETE FROM card_deck WHERE deck_id = ?";
        int numberOfRows = jdbcTemplate.update(sql, Integer.class, deckId);
        return numberOfRows;
    }

    private Deck mapRowToDeck(SqlRowSet rowSet) {
        Deck deck = new Deck();
        deck.setDeckId(rowSet.getInt("deck_id"));
        deck.setName(rowSet.getString("name"));
        deck.setSubject(rowSet.getString("subject"));
        deck.setDescription(rowSet.getString("description"));
        deck.setUserId(rowSet.getInt("user_id"));
        return deck;
    }

    private Card mapRowToCard(SqlRowSet rowSet) {
        Card card = new Card();
        card.setCardId(rowSet.getInt("card_id"));
        card.setSubject(rowSet.getString("subject"));
        card.setQuestion(rowSet.getString("question"));
        card.setTags(rowSet.getString("tags"));
        card.setAnswer(rowSet.getString("answer"));
        card.setUserId(rowSet.getInt("user_id"));
        return card;
    }
}