package service;

import face.IDialog;

import java.util.Scanner;

public class Dialog implements IDialog {
    private Scanner scanner;

    public Dialog() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String input(String message) {
        System.out.print(message);
        return input();
    }

    @Override
    public String input() {
        return scanner.nextLine();
    }

}
