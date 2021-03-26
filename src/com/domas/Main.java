package com.domas;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Player player1 = null;
        Player player2 = null;

        Optional<Player> playerOne = Optional.ofNullable(player1);
        Optional<Player> playerTwo = Optional.ofNullable(player2);

        DeckOfCards deck = new DeckOfCards();
        deck.shuffleDeck();

        WarGame game = new WarGame();
        deck.dealCards(playerOne, playerTwo);
        game.selectTrumpSuite();
        game.war(playerOne, playerTwo);
    }
}
