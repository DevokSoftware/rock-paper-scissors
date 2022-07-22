package com.imc;

import com.imc.model.Game;
import com.imc.model.GameSymbol;
import org.junit.Assert;
import org.junit.Test;

public class GameLogicTest {

    @Test
    public void testPaperBeatsRock() {
        Game game = new Game();
        GameLogic.checkResult(GameSymbol.P, GameSymbol.R, game);
        Assert.assertEquals(1, game.getGamesPlayed());
        Assert.assertEquals(1, game.getPlayer1Wins());
        Assert.assertEquals(0, game.getPlayer2Wins());
        Assert.assertEquals(0, game.getTies());
    }

    @Test
    public void testScissorsLosesToRock() {
        Game game = new Game();
        GameLogic.checkResult(GameSymbol.S, GameSymbol.R, game);
        Assert.assertEquals(1, game.getGamesPlayed());
        Assert.assertEquals(0, game.getPlayer1Wins());
        Assert.assertEquals(1, game.getPlayer2Wins());
        Assert.assertEquals(0, game.getTies());
    }

    @Test
    public void testScissorsBeatsPaper() {
        Game game = new Game();
        GameLogic.checkResult(GameSymbol.S, GameSymbol.P, game);
        Assert.assertEquals(1, game.getGamesPlayed());
        Assert.assertEquals(1, game.getPlayer1Wins());
        Assert.assertEquals(0, game.getPlayer2Wins());
        Assert.assertEquals(0, game.getTies());
    }

    @Test
    public void testAllPossibleTies() {
        Game game = new Game();
        GameLogic.checkResult(GameSymbol.S, GameSymbol.S, game);
        GameLogic.checkResult(GameSymbol.P, GameSymbol.P, game);
        GameLogic.checkResult(GameSymbol.R, GameSymbol.R, game);
        Assert.assertEquals(3, game.getGamesPlayed());
        Assert.assertEquals(0, game.getPlayer1Wins());
        Assert.assertEquals(0, game.getPlayer2Wins());
        Assert.assertEquals(3, game.getTies());
    }
}
