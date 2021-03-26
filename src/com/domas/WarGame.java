package com.domas;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class WarGame {
    private Suite trumpSuite;

    public void war(Optional<Player> player1, Optional<Player> player2) {
        if (player1.isPresent() && player2.isPresent()) {
            System.out.println("Let's start the war!");
            for (int i = 0; i < 26; i++) {
                System.out.println("Round: " + (i + 1));
                System.out.println("Player1 has: " + player1.get().getHandCards().get(i));
                System.out.println("Player2 has: " + player2.get().getHandCards().get(i));
                if (player1.get().getHandCards().get(i).getSuite() == trumpSuite && player2.get().getHandCards().get(i).getSuite() == trumpSuite) {
                    if (player1.get().getHandCards().get(i).getRank().rankValue > player2.get().getHandCards().get(i).getRank().rankValue) {
                        player1.get().getScorePile().add(player1.get().getHandCards().get(i));
                        player1.get().getScorePile().add(player2.get().getHandCards().get(i));
                        System.out.println(player1.get().getHandCards().get(i) + " beats " + player2.get().getHandCards().get(i));
                    } else {
                        player2.get().getScorePile().add(player1.get().getHandCards().get(i));
                        player2.get().getScorePile().add(player2.get().getHandCards().get(i));
                        System.out.println(player2.get().getHandCards().get(i) + " beats " + player1.get().getHandCards().get(i));
                    }
                } else if (player1.get().getHandCards().get(i).getSuite() == trumpSuite && player2.get().getHandCards().get(i).getSuite() != trumpSuite) {
                    player1.get().getScorePile().add(player1.get().getHandCards().get(i));
                    player1.get().getScorePile().add(player2.get().getHandCards().get(i));
                    System.out.println(player1.get().getHandCards().get(i) + " beats " + player2.get().getHandCards().get(i));
                } else if (player1.get().getHandCards().get(i).getSuite() != trumpSuite && player2.get().getHandCards().get(i).getSuite() == trumpSuite) {
                    player2.get().getScorePile().add(player1.get().getHandCards().get(i));
                    player2.get().getScorePile().add(player2.get().getHandCards().get(i));
                    System.out.println(player2.get().getHandCards().get(i) + " beats " + player1.get().getHandCards().get(i));
                } else {
                    if (player1.get().getHandCards().get(i).getRank().rankValue > player2.get().getHandCards().get(i).getRank().rankValue) {
                        player1.get().getScorePile().add(player1.get().getHandCards().get(i));
                        player1.get().getScorePile().add(player2.get().getHandCards().get(i));
                        System.out.println(player1.get().getHandCards().get(i) + " beats " + player2.get().getHandCards().get(i));
                    } else if (player1.get().getHandCards().get(i).getRank().rankValue == player2.get().getHandCards().get(i).getRank().rankValue) {
                        player1.get().getScorePile().add(player1.get().getHandCards().get(i));
                        player2.get().getScorePile().add(player2.get().getHandCards().get(i));
                        System.out.println(player1.get().getHandCards().get(i) + " ties with " + player2.get().getHandCards().get(i));
                    } else {
                        player2.get().getScorePile().add(player1.get().getHandCards().get(i));
                        player2.get().getScorePile().add(player2.get().getHandCards().get(i));
                        System.out.println(player2.get().getHandCards().get(i) + " beats " + player1.get().getHandCards().get(i));
                    }
                }
            }
            player1.get().getHandCards().clear();
            player2.get().getHandCards().clear();

            if (player1.get().getScorePile().size() > player2.get().getScorePile().size()) {
                System.out.println("Player1 wins with a score of " + player1.get().getScorePile().size() + " (Player2 scored: " + player2.get().getScorePile().size() + ")");
            } else if (player1.get().getScorePile().size() == player2.get().getScorePile().size()) {
                System.out.println("It's a tie!");
            } else {
                System.out.println("Player2 wins with a score of " + player2.get().getScorePile().size() + " (Player1 scored: " + player1.get().getScorePile().size() + ")");
            }
        } else {
            System.out.println("Need two valid players to play");
        }
    }

    public void selectTrumpSuite() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
        trumpSuite = Suite.valueOfSuiteId(randomNum);
        System.out.println("Trump suite for this game: " + trumpSuite);
    }
}
