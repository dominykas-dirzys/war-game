package com.domas;

import java.util.concurrent.ThreadLocalRandom;

public class WarGame {
    private Suite trumpSuite;

    public void war(Player player1, Player player2) {
        System.out.println("Let's start the war!");
        for (int i = 0; i < 26; i++) {
            System.out.println("Round: " + (i + 1));
            System.out.println("Player1 has: " + player1.getHandCards().get(i));
            System.out.println("Player2 has: " + player2.getHandCards().get(i));
            if (player1.getHandCards().get(i).getSuite() == trumpSuite && player2.getHandCards().get(i).getSuite() == trumpSuite) {
                if (player1.getHandCards().get(i).getRank().rankValue > player2.getHandCards().get(i).getRank().rankValue) {
                    player1.getScorePile().add(player1.getHandCards().get(i));
                    player1.getScorePile().add(player2.getHandCards().get(i));
                    System.out.println(player1.getHandCards().get(i) + " beats " + player2.getHandCards().get(i));
                } else {
                    player2.getScorePile().add(player1.getHandCards().get(i));
                    player2.getScorePile().add(player2.getHandCards().get(i));
                    System.out.println(player2.getHandCards().get(i) + " beats " + player1.getHandCards().get(i));
                }
            } else if (player1.getHandCards().get(i).getSuite() == trumpSuite && player2.getHandCards().get(i).getSuite() != trumpSuite) {
                player1.getScorePile().add(player1.getHandCards().get(i));
                player1.getScorePile().add(player2.getHandCards().get(i));
                System.out.println(player1.getHandCards().get(i) + " beats " + player2.getHandCards().get(i));
            } else if (player1.getHandCards().get(i).getSuite() != trumpSuite && player2.getHandCards().get(i).getSuite() == trumpSuite) {
                player2.getScorePile().add(player1.getHandCards().get(i));
                player2.getScorePile().add(player2.getHandCards().get(i));
                System.out.println(player2.getHandCards().get(i) + " beats " + player1.getHandCards().get(i));
            } else {
                if (player1.getHandCards().get(i).getRank().rankValue > player2.getHandCards().get(i).getRank().rankValue) {
                    player1.getScorePile().add(player1.getHandCards().get(i));
                    player1.getScorePile().add(player2.getHandCards().get(i));
                    System.out.println(player1.getHandCards().get(i) + " beats " + player2.getHandCards().get(i));
                } else if (player1.getHandCards().get(i).getRank().rankValue == player2.getHandCards().get(i).getRank().rankValue) {
                    player1.getScorePile().add(player1.getHandCards().get(i));
                    player2.getScorePile().add(player2.getHandCards().get(i));
                    System.out.println(player1.getHandCards().get(i) + " ties with " + player2.getHandCards().get(i));
                } else {
                    player2.getScorePile().add(player1.getHandCards().get(i));
                    player2.getScorePile().add(player2.getHandCards().get(i));
                    System.out.println(player2.getHandCards().get(i) + " beats " + player1.getHandCards().get(i));
                }
            }
        }
        player1.getHandCards().clear();
        player2.getHandCards().clear();

        if (player1.getScorePile().size() > player2.getScorePile().size()) {
            System.out.println("Player1 wins with a score of " + player1.getScorePile().size() + " (Player2 scored: " + player2.getScorePile().size() + ")");
        } else if (player1.getScorePile().size() == player2.getScorePile().size()) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Player2 wins with a score of " + player2.getScorePile().size() + " (Player1 scored: " + player1.getScorePile().size() + ")");
        }
    }

    public void selectTrumpSuite() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
        trumpSuite = Suite.valueOfSuiteId(randomNum);
        System.out.println("Trump suite for this game: " + trumpSuite);
    }
}
