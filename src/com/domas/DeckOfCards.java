package com.domas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DeckOfCards {
    private List<Card> cards;

    public DeckOfCards() {
        List<Card> initialCards = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            for (int j = 2; j <= 14; j++) {
                Card card = new Card(Suite.valueOfSuiteId(i), Rank.valueOfRankValue(j));
                initialCards.add(card);
            }
        }
        this.cards = initialCards;
    }

    public void shuffleDeck() {
        List<Card> tempDeck = new ArrayList<>();
        List<Card> cardsCopy = new ArrayList<>(cards);
        for (int i = 0; i < cards.size(); i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, cardsCopy.size());
            tempDeck.add(cardsCopy.get(randomNum));
            cardsCopy.remove(randomNum);
        }

        cards = tempDeck;
    }

    public void dealCards(Player player1, Player player2) {
        for (int i = 0; i < cards.size(); i++) {
            if (i % 2 == 0) {
                player1.getHandCards().add(cards.get(i));
            } else {
                player2.getHandCards().add(cards.get(i));
            }
        }
        Collections.reverse(player1.getHandCards());
        Collections.reverse(player2.getHandCards());
        cards.clear();
    }
}
