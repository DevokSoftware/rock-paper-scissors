package com.imc;

import com.imc.menu.GameMenu;
import com.imc.menu.MenuFactory;
import com.imc.model.Game;
import com.imc.model.GameResult;
import com.imc.model.GameSymbol;
import com.imc.util.ScannerReader;
import org.apache.commons.lang3.EnumUtils;

import java.util.Scanner;

public class GameLogic {
    public static void initialize() {
        boolean stillPlaying = true;
        while (stillPlaying) {
            printHomepageMenu();
            MenuFactory menuFactory = new MenuFactory();
            Scanner scanner = ScannerReader.getInstance().getScanner();
            GameMenu gameMenu = null;
            while (gameMenu == null) {
                System.out.println("\nSelect an option:");
                gameMenu = menuFactory.getMenu(scanner.next());
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

    public static void startGame(Game game, boolean versusBot) {
        GameSymbol player1Choice = chooseOption();
        GameSymbol player2Choice = versusBot ? getBotSymbol() : chooseOption();
        checkResult(player1Choice, player2Choice, game, versusBot);
    }

    private static GameSymbol chooseOption() {
        Scanner scanner = ScannerReader.getInstance().getScanner();
        while (true) {
            System.out.println("Select a valid option: ");
            String option = scanner.next();
            if (EnumUtils.isValidEnum(GameSymbol.class, option)) {
                return GameSymbol.valueOf(option);
            }
        }
    }

    private static void checkResult(GameSymbol firstSymbol, GameSymbol secondSymbol, Game game, boolean versusBot) {
        GameResult result = firstSymbol.getResult(secondSymbol);
        incrementRecords(result, game);
        String player2 = versusBot ? "BOT" : "Player 2";
        System.out.println("\nPlayer 1 played " + firstSymbol.getValue() + " and " + player2 + " played " + secondSymbol.getValue() + ". It's a " + result + "!");
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
