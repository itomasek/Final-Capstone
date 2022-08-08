package com.techelevator.controller;

import com.techelevator.dao.CardDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Card;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CardController {

    private CardDao cardDao;

    public CardController(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @RequestMapping(path = "/cards", method = RequestMethod.GET)
    public List<Card> getCards() {
        return cardDao.getCards();
    }


}
