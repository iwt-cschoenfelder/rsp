package com.cschoenfelder.rsp.service;

import java.util.Random;

public enum Choice {
    ROCK, SCISSOR, PAPER;

    private static final Random random = new Random();

    public static Choice randomChoice() {
        Choice[] allPossibleChoices = values();
        return allPossibleChoices[random.nextInt(allPossibleChoices.length)];
    }

}
