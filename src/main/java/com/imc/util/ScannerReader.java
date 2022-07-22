package com.imc.util;

import java.util.Scanner;

public class ScannerReader {
    private static Scanner scanner;

    private ScannerReader() {
    }

    public static String getInputValue() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner.next();
    }
}
