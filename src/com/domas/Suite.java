package com.domas;

import java.util.HashMap;
import java.util.Map;

public enum Suite {
    HEARTS(1),
    SPADES(2),
    CLUBS(3),
    DIAMONDS(4);

    private static final Map<Integer, Suite> BY_SUITE_ID = new HashMap<>();

    static {
        for (Suite s : values()) {
            BY_SUITE_ID.put(s.suiteId, s);
        }
    }

    public final int suiteId;

    private Suite(int suiteId) {
        this.suiteId = suiteId;
    }

    public static Suite valueOfSuiteId(int id) {
        return BY_SUITE_ID.get(id);
    }
}
