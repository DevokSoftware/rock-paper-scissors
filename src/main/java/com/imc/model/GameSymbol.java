package com.imc.model;

import java.util.List;
import java.util.Random;

public enum GameSymbol {
    R("ROCK"),
    P("PAPER"),
    S("SCISSORS");

    private final String value;
    private List<GameSymbol> beats;

    GameSymbol(String value) {
        this.value = value;
    }

    static {
        R.beats = List.of(S);
        S.beats = List.of(P);
        P.beats = List.of(R);
    }

    public GameResult getResult(GameSymbol secondChoice) {
        if (this.beats.contains(secondChoice)) return GameResult.WIN;
        if (secondChoice.beats.contains(this)) return GameResult.LOSE;
        return GameResult.TIE;
    }

    public String getValue() {
        return value;
    }

    public List<GameSymbol> getBeats() {
        return beats;
    }

    public static void printExistentSymbols() {
        System.out.println("SYMBOLS:");
        for (GameSymbol symbol : GameSymbol.values()) {
            System.out.println(symbol + " - " + symbol.getValue());
        }
    }

    public static GameSymbol getRandomSymbol() {
        return GameSymbol.values()[new Random().nextInt(GameSymbol.values().length)];
    }
}
