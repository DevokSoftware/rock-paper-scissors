package com.imc.util;

import java.util.Scanner;

public class ScannerReader {
    private static ScannerReader INSTANCE;
    private final Scanner scanner;

    private ScannerReader() {
        scanner = new Scanner(System.in);
    }

    public static ScannerReader getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ScannerReader();
        }
        return INSTANCE;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
