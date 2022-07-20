package com.imc.menu;

public class MenuFactory {
    public GameMenu getMenu(String menuOption) {
        if (menuOption == null) {
            return null;
        }

        if (menuOption.equalsIgnoreCase(StartGameVsBotMenu.getMenuOption())) {
            return new StartGameVsBotMenu();
        } else if (menuOption.equalsIgnoreCase(ExitGameMenu.getMenuOption())) {
            return new ExitGameMenu();
        } else if (menuOption.equalsIgnoreCase(H2PMenu.getMenuOption())) {
            return new H2PMenu();
        }

        return null;
    }
}
