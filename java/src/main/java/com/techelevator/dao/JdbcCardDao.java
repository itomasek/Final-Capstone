package com.techelevator.dao;

import com.techelevator.model.Card;
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