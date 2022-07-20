package com.imc.menu;

public class ExitGameMenu extends GameMenu {

    public static String MENU_OPTION = "3";

    static String getMenuOption() {
        return MENU_OPTION;
    }

    @Override
    public boolean execute() {
        System.out.println(
                "----------------------------------------------\n" +
                "|    It was a pleasure. Have a nice day!     |\n" +
                "----------------------------------------------");
        return false;
    }
}
