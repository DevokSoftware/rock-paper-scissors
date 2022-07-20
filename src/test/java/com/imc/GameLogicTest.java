package com.imc;

import com.imc.model.Game;
import com.imc.model.GameSymbol;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GameLogicTest {

    @Test
    public void testPaperBeatsRock() {
        Game game = new Game();
        GameLogic.checkResult(GameSymbol.P, GameSymbol.R, game, true);
        Assert.assertEquals(game.getGamesPlayed(), 1);
        Assert.assertEquals(game.getPlayer1Wins(), 1);
        Assert.assertEquals(game.getPlayer2Wins(), 0);
        Assert.assertEquals(game.getTies(), 0);
    }

    @Test
    public void testScissorsLosesToRock() {
        Game game = new Game();
        GameLogic.checkResult(GameSymbol.S, GameSymbol.R, game, true);
        Assert.assertEquals(game.getGamesPlayed(), 1);
        Assert.assertEquals(game.getPlayer1Wins(), 0);
        Assert.assertEquals(game.getPlayer2Wins(), 1);
        Assert.assertEquals(game.getTies(), 0);
    }

    @Test
    public void testScissorsBeatsPaper() {
        Game game = new Game();
        GameLogic.checkResult(GameSymbol.S, GameSymbol.P, game, true);
        Assert.assertEquals(game.getGamesPlayed(), 1);
        Assert.assertEquals(game.getPlayer1Wins(), 1);
        Assert.assertEquals(game.getPlayer2Wins(), 0);
        Assert.assertEquals(game.getTies(), 0);
    }

    @Test
    public void testAllPossibleTies() {
        Game game = new Game();
        GameLogic.checkResult(GameSymbol.S, GameSymbol.S, game, true);
        GameLogic.checkResult(GameSymbol.P, GameSymbol.P, game, true);
        GameLogic.checkResult(GameSymbol.R, GameSymbol.R, game, true);
        Assert.assertEquals(game.getGamesPlayed(), 3);
        Assert.assertEquals(game.getPlayer1Wins(), 0);
        Assert.assertEquals(game.getPlayer2Wins(), 0);
        Assert.assertEquals(game.getTies(), 3);
    }

    @Test
    public void startGameAndChooseRockSymbol() {
        InputStream in = System.in;
        System.setIn(new ByteArrayInputStream("R\n".getBytes()));
        GameSymbol symbol = GameLogic.chooseOption();
        System.setIn(in);
        Assert.assertEquals(symbol, GameSymbol.R);
    }
}
