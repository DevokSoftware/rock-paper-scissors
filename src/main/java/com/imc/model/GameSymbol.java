package com.imc.model;

import java.util.Random;
import java.util.Set;


public enum GameSymbol {
    R("ROCK"),
    P("PAPER"),
    S("SCISSORS");

    private final String value;
    private Set<GameSymbol> beats;
    private static Random random;

    GameSymbol(String value) {
        this.value = value;
    }

    static {
        R.beats = Set.of(S);
        S.beats = Set.of(P);
        P.beats = Set.of(R);
    }

    public GameResult beatsSymbol(GameSymbol secondChoice) {
        if (this.beats.contains(secondChoice)) return GameResult.WIN;
        if (secondChoice.beats.contains(this)) return GameResult.LOSE;
        return GameResult.TIE;
    }

    public String getValue() {
        return value;
    }

    public Set<GameSymbol> getBeats() {
        return beats;
    }

    public static void printExistentSymbols() {
        System.out.println("\n\nSYMBOLS:");
        for (GameSymbol symbol : GameSymbol.values()) {
            System.out.println(symbol + " - " + symbol.getValue());
        }
    }

    public static GameSymbol getRandomSymbol() {
        return GameSymbol.values()[getRandomInstance().nextInt(GameSymbol.values().length)];
    }

    private static Random getRandomInstance() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }
}
