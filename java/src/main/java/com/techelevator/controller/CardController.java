package com.techelevator.controller;

import com.techelevator.dao.CardDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Card;
import com.techelevator.model.Deck;
import com.techelevator.model.UserSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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

    @RequestMapping(path = "/deck/{deckId}", method = RequestMethod.PUT)
    public int updateDeck(@PathVariable int deckId, @RequestBody Deck deck) {
        return cardDao.updateDeck(deckId, deck);
    }

    @RequestMapping(path = "/decks/{userId}", method = RequestMethod.GET)
    public List<Deck> getDecks(@PathVariable int userId) {
        return cardDao.getDecks(userId);
    }

    @RequestMapping(path = "/decks", method = RequestMethod.POST)
    public int createDeck(@RequestBody Deck deck) {
        return cardDao.createDeck(deck);
    }

    @RequestMapping(path = "/deck-cards/{deckId}", method = RequestMethod.GET)
    public int getNumberOfCards(@PathVariable int deckId) {
        return cardDao.getNumberOfCards(deckId);
    }

    @RequestMapping(path = "/cards/{cardId}/decks/{deckId}", method = RequestMethod.POST)
    public void putCardsInDeck(@PathVariable int cardId, @PathVariable int deckId) {
        cardDao.putCardsInDeck(cardId, deckId);
    }

    @RequestMapping(path = "/cards-in/{deckId}", method = RequestMethod.GET)
    public List<Card> getCardsByDeckId(@PathVariable int deckId) {
        return cardDao.getCardsByDeckId(deckId);
    }

    @RequestMapping(path = "/cards-out/{userId}/{deckId}", method = RequestMethod.GET)
    public List<Card> getExcludedCards(@PathVariable int userId, @PathVariable int deckId) {
        return cardDao.getExcludedCards(userId, deckId);
    }

    @RequestMapping(path = "/clear-card-deck/{deckId}", method = RequestMethod.DELETE)
    public int clearCardDeck(@PathVariable int deckId) {
        return cardDao.clearCardDeck(deckId);
    }

    @RequestMapping(path = "/save-session", method = RequestMethod.POST)
    public int saveSession(@RequestBody UserSession session) {
        return cardDao.saveSession(session);
    }

}
