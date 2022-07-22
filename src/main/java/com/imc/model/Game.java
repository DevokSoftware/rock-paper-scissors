package com.imc.model;

public class Game {
    private int gamesPlayed = 0;
    private int player1Wins = 0;
    private int player2Wins = 0;
    private int ties = 0;

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getPlayer1Wins() {
        return player1Wins;
    }

    public int getPlayer2Wins() {
        return player2Wins;
    }

    public int getTies() {
        return ties;
    }

    public void incrementGamesPlayed(){
        gamesPlayed++;
    }
    public void incrementPlayer1Wins(){
        player1Wins++;
    }
    public void incrementPlayer2Wins(){
        player2Wins++;
    }
    public void incrementTies(){
        ties++;
    }
}
