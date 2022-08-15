package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.Deck;
import com.techelevator.model.UserSession;
import org.springframework.data.relational.core.sql.In;
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
        String getCardSql = "SELECT * FROM card WHERE user_id = ? ORDER BY card_id DESC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(getCardSql, userId);
        while (results.next()) {
            Card card = mapRowToCard(results);
            cards.add(card);
        }
        return cards;
    }

    @Override
    public List<UserSession> getSessions(int userId) {
        List<UserSession> sessions = new ArrayList<>();
        String sql = "SELECT * FROM user_session WHERE user_id = ? ORDER BY session_id DESC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            sessions.add(mapRowToSession(results));
        }
        return sessions;
    }

    @Override
    public void deleteCardsFromDeck(int cardId) {
        String sql = "DELETE FROM card_deck WHERE card_id = ?";
        jdbcTemplate.update(sql, cardId);
    }

    @Override
    public void deleteCard(int cardId) {
        String sql = "DELETE FROM card WHERE card_id = ?";
        jdbcTemplate.update(sql, cardId);
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
    public int updateDeck(int deckId, Deck deck) {
        String updateSql = "UPDATE deck SET name = ?, subject = ?, description = ?, user_id = ? WHERE deck_id = ?";
        int rowsUpdated = jdbcTemplate.update(updateSql, deck.getName(), deck.getSubject(), deck.getDescription(), deck.getUserId(), deckId);
        return rowsUpdated;
    }

    @Override
    public int saveSession(UserSession session) {
        String sql = "INSERT INTO user_session (deck_studied, total_cards, total_correct, total_incorrect, user_id) VALUES (?, ?, ?, ?, ?) RETURNING session_id";
        int sessionId = jdbcTemplate.queryForObject(sql, Integer.class, session.getDeckStudied(), session.getTotalCards(), session.getTotalCorrect(), session.getTotalIncorrect(), session.getUserId());
        return sessionId;
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
        jdbcTemplate.update(sql, cardId, deckId);

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
    public List<Card> getExcludedCards(int userId, int deckId) {
        List<Card> cards = new ArrayList<>();
        String sql = "SELECT c.card_id, c.subject, c.question, c.tags, c.answer, c.user_id, cd.deck_id\n" +
                "FROM card AS c\n" +
                "LEFT JOIN card_deck AS cd ON cd.card_id = c.card_id\n" +
                "WHERE c.user_id = ? and cd.deck_id != ? OR cd.deck_id IS NULL;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, deckId);
        while (results.next()) {
            cards.add(mapRowToCard(results));
        }
        return cards;
    }

    @Override
    public void clearCardDeck(int deckId) {
        String sql = "DELETE FROM card_deck WHERE deck_id = ?";
        jdbcTemplate.update(sql, deckId);
    }

    @Override
    public void deleteDeck(int deckId) {
        String sql = "DELETE FROM deck WHERE deck_id = ?";
        jdbcTemplate.update(sql, deckId);
    }

    public void clearSessions(int userId) {
        String sql = "DELETE FROM user_session WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
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

    private UserSession mapRowToSession(SqlRowSet rowSet) {
        UserSession session = new UserSession();
        session.setSessionId(rowSet.getInt("session_id"));
        session.setDeckStudied(rowSet.getString("deck_studied"));
        session.setTotalCards(rowSet.getInt("total_cards"));
        session.setTotalCorrect(rowSet.getInt("total_correct"));
        session.setTotalIncorrect(rowSet.getInt("total_incorrect"));
        session.setUserId(rowSet.getInt("user_id"));
        return session;
    }
}