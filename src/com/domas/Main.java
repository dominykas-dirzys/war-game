package com.domas;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        DeckOfCards deck = new DeckOfCards();
        deck.shuffleDeck();

        WarGame game = new WarGame();
        deck.dealCards(player1, player2);
        game.selectTrumpSuite();
        game.war(player1, player2);
    }
}
