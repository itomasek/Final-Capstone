package com.techelevator.controller;

import com.techelevator.dao.CardDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Card;
import com.techelevator.model.Deck;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CardController {

    private CardDao cardDao;


    public CardController(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @RequestMapping(path = "/cards/{userId}", method = RequestMethod.GET)
    public List<Card> getCards(@PathVariable int userId) {
        return cardDao.getCards(userId);
    }

    @RequestMapping(path = "/cards", method = RequestMethod.POST)
    public int createCard(@RequestBody Card card){
        return cardDao.createCard(card);
    }

    @RequestMapping(path = "/card/{cardId}", method = RequestMethod.PUT)
    public int updateCard(@PathVariable int cardId, @RequestBody Card card) {
        return cardDao.updateCard(cardId, card);
    }

    @RequestMapping(path = "/decks/{userId}", method = RequestMethod.GET)
    public List<Deck> getDecks(@PathVariable int userId) {
        return cardDao.getDecks(userId);
    }


}
