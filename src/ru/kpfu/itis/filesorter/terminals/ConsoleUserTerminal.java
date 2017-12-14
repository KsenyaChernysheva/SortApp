package ru.kpfu.itis.filesorter.terminals;

import ru.kpfu.itis.filesorter.constants.DialogResult;
import ru.kpfu.itis.filesorter.exceptions.InputWindowClosedException;
import ru.kpfu.itis.filesorter.UserTerminal;

import java.io.File;
import java.util.Scanner;

public class ConsoleUserTerminal implements UserTerminal {

    @Override
    public void showErrorMessage(String message) {
        System.err.println("[ERROR]: " + message);
    }

    @Override
    public void showNotificationMessage(String message) {
        System.out.println("[INFO]: " + message);
    }

   @Override
    public DialogResult showConfirmDialog(String message, String title) {
        System.out.println(message);
        System.out.println("[Y/n]");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("Y") || choice.isEmpty()) {
            return DialogResult.RESULT_YES;
        } else {
            return DialogResult.RESULT_NO;
        }
    }

    @Override
    public DialogResult showOptionDialog(String message, String title) {
        System.out.println(message);
        System.out.println("[Y/n]");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if(choice.equals("Y") || choice.isEmpty()) {
            return DialogResult.RESULT_YES;
        }
        return DialogResult.RESULT_NO;
    }


    @Override
    public File getFile(String message) throws InputWindowClosedException {
        showNotificationMessage(message);
        Scanner scanner = new Scanner(System.in);
        String pathToFine = scanner.nextLine();
        File file = new File(pathToFine);
        return file;
    }

    @Override
    public String getRegex(String title) throws InputWindowClosedException {
        showNotificationMessage(title);
        Scanner scanner = new Scanner(System.in);
        String regex = scanner.nextLine();
        return regex;
    }
}
