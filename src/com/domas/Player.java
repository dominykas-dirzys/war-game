package com.domas;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> handCards;
    private List<Card> scorePile;

    public Player() {
        this.handCards = new ArrayList<>();
        this.scorePile = new ArrayList<>();
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public List<Card> getScorePile() {
        return scorePile;
    }
}
