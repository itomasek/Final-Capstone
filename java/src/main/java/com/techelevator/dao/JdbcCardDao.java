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
    public List<Card> getCards() {
        List<Card> cards = new ArrayList<>();
        String getCardSql = "SELECT * FROM card";
        SqlRowSet results = jdbcTemplate.queryForRowSet(getCardSql);
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

    private Card mapRowToCard(SqlRowSet rowSet) {
        Card card = new Card();
        card.setCardId(rowSet.getInt("card_id"));
        card.setSubject(rowSet.getString("subject"));
        card.setQuestion(rowSet.getString("question"));
        card.setTags(rowSet.getString("tags").split(", "));
        card.setAnswer(rowSet.getString("answer"));
        card.setUserId(rowSet.getInt("user_id"));
        return card;
    }
}