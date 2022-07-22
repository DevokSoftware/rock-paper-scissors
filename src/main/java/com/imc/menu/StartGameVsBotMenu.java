package com.imc.menu;

import com.imc.GameLogic;
import com.imc.model.Game;
import com.imc.model.GameSymbol;
import com.imc.util.ScannerReader;

public class StartGameVsBotMenu extends GameMenu {
    public static String MENU_OPTION = "1";

    static String getMenuOption() {
        return MENU_OPTION;
    }

    @Override
    public boolean execute() {
        System.out.println("\n--------------------------------\n" +
                "|         Game started         | \n" +
                "--------------------------------");
        boolean stillPlaying = true;
        Game game = new Game();
        while (stillPlaying) {
            GameSymbol.printExistentSymbols();
            GameLogic.startGameVsBot(game);
            printRecords(game);
            stillPlaying = isToStillPlaying(game);
        }
        return true;
    }

    private boolean isToStillPlaying(Game game) {
        System.out.println("\n1 - Just one more game." +
                "\n2-Back To Menu.");
        while (true) {
            String option = ScannerReader.getInputValue();
            if (option.equals("1")) return true;
            if (option.equals("2")) {
                printRecords(game);
                return false;
            }
        }
    }

    private void printRecords(Game game) {
        System.out.println("\n\n--------------------------"
                + "\nGames Played: " + game.getGamesPlayed()
                + "\nPlayer's number of Wins: " + game.getPlayer1Wins()
                + "\nBOT's number of Wins: " + game.getPlayer2Wins()
                + "\nTies: " + game.getTies()
                + "\n--------------------------\n");
    }
}
