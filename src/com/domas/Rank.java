package com.domas;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    private static final Map<Integer, Rank> BY_RANK_VALUE = new HashMap<>();

    static {
        for (Rank r : values()) {
            BY_RANK_VALUE.put(r.rankValue, r);
        }
    }

    public final int rankValue;

    private Rank(int rankValue) {
        this.rankValue = rankValue;
    }

    public static Rank valueOfRankValue(int value) {
        return BY_RANK_VALUE.get(value);
    }
}
