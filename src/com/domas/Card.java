package com.domas;

public class Card {
    private Suite suite;
    private Rank rank;

    public Card(Suite suite, Rank rank) {
        this.suite = suite;
        this.rank = rank;
    }

    public Suite getSuite() {
        return suite;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank +
                " of " + suite;
    }
}
