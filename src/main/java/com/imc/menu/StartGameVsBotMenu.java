package com.imc.menu;

import com.imc.GameLogic;
import com.imc.model.Game;
import com.imc.model.GameSymbol;
import com.imc.util.ScannerReader;


import java.util.Scanner;

public class StartGameVsBotMenu extends GameMenu {
    public static String MENU_OPTION = "1";

    static String getMenuOption() {
        return MENU_OPTION;
    }

    @Override
    public boolean execute() {
        System.out.println("--------------------------------\n" +
                "|         Game started         | \n" +
                "--------------------------------");
        boolean stillPlaying = true;
        Game game = new Game();
        while (stillPlaying) {
            GameSymbol.printExistentSymbols();
            GameLogic.startGame(game, true);
            printRecords(game);
            stillPlaying = isToStillPlaying();
        }
        return true;
    }

    private boolean isToStillPlaying() {
        System.out.println("\n1 - Just one more game." +
                "\n2-Back To Menu.");
        while (true) {
            Scanner scanner = ScannerReader.getInstance().getScanner();
            String option = scanner.next();
            if (option.equals("1")) return true;
            if (option.equals("2")) return false;
        }
    }

    private void printRecords(Game game) {
        System.out.println("--------------------------"
                + "\nGames Played: " + game.getGamesPlayed()
                + "\nNumber of Player Wins: " + game.getPlayer1Wins()
                + "\nNumber of BOT wins: " + game.getPlayer2Wins()
                + "\nTies: " + game.getTies()
                + "\n--------------------------");
    }
}
