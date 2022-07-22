package com.imc.menu;

import com.imc.model.GameSymbol;
import com.imc.util.ScannerReader;

public class H2PMenu extends GameMenu {
    public static String MENU_OPTION = "2";

    static String getMenuOption() {
        return MENU_OPTION;
    }

    @Override
    public boolean execute() {
        System.out.println("\n------------------------------\n" +
                "|         How to Play         |\n" +
                "------------------------------");
        System.out.println("In this game you need to choose a symbol simultaneously with your opponent. Each symbol can beat or be beaten by another one.");
        System.out.println("Symbols: ");
        for (GameSymbol symbol : GameSymbol.values()) {
            System.out.print("-> " + symbol.getValue() + " beats ");
            symbol.getBeats().forEach(gameSymbol -> System.out.print("[" + gameSymbol.getValue() + "] "));
            System.out.println("");
        }
        System.out.println("To Start a new game against the computer you should press [1] in the Menu. Record of games played and respective results are displayed at the end of each game.");
        System.out.println("\nPress some key to get back to the Menu..");
        ScannerReader.getInputValue();
        return true;
    }
}
