package Day03.Code.controller;

import Day03.Code.bean.Card;
import Day03.Code.service.CardService;
import Day03.Code.service.CardServiceImpl;
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
