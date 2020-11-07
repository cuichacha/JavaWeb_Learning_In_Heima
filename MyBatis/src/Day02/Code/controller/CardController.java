package Day02.Code.controller;

import Day02.Code.bean.Card;
import Day02.Code.service.CardService;
import Day02.Code.service.CardServiceImpl;
import org.junit.Test;

import java.util.List;

public class CardController {
    private CardService cardService = new CardServiceImpl();

    @Test
    public void findAll() {
        List<Card> cards = cardService.findAll();
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
