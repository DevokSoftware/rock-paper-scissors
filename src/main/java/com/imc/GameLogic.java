package com.imc;

import com.imc.menu.GameMenu;
import com.imc.menu.MenuFactory;
import com.imc.model.Game;
import com.imc.model.GameResult;
import com.imc.model.GameSymbol;
import com.imc.util.ScannerReader;
import org.apache.commons.lang3.EnumUtils;

public class GameLogic {
    public static void initialize() {
        boolean stillPlaying = true;
        while (stillPlaying) {
            printHomepageMenu();
            MenuFactory menuFactory = new MenuFactory();
            GameMenu gameMenu = null;
            while (gameMenu == null) {
                System.out.println("\nSelect an option:");
                gameMenu = menuFactory.getMenu(ScannerReader.getInputValue());
            }
            stillPlaying = gameMenu.execute();
        }
    }

    static void printHomepageMenu() {
        System.out.println("\nMENU OPTIONS: " +
                "\n1 - Start New Game [vs BOT]" +
                "\n2 - How To Play?" +
                "\n3 - Exit");
    }

    public static void startGameVsBot(Game game) {
        GameSymbol player1Choice = chooseOption();
        GameSymbol player2Choice = getBotSymbol();
        checkResult(player1Choice, player2Choice, game);
    }

    public static void checkResult(GameSymbol firstSymbol, GameSymbol secondSymbol, Game game) {
        GameResult result = firstSymbol.beatsSymbol(secondSymbol);
        incrementRecords(result, game);
        System.out.println("\nPlayer 1 played " + firstSymbol.getValue() + " and BOT played " + secondSymbol.getValue() + ". It's a " + result + "!");
    }

    public static GameSymbol chooseOption() {
        while (true) {
            System.out.println("Select a valid option: ");
            String option = ScannerReader.getInputValue();
            if (EnumUtils.isValidEnum(GameSymbol.class, option)) {
                return GameSymbol.valueOf(option);
            }
        }
    }

    private static GameSymbol getBotSymbol() {
        return GameSymbol.getRandomSymbol();
    }

    private static void incrementRecords(GameResult result, Game game) {
        game.incrementGamesPlayed();
        if (result.equals(GameResult.WIN)) {
            game.incrementPlayer1Wins();
        } else if (result.equals(GameResult.LOSE)) {
            game.incrementPlayer2Wins();
        } else {
            game.incrementTies();
        }
    }
}
