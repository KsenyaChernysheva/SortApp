package ru.kpfu.itis.filesorter;

import ru.kpfu.itis.filesorter.constants.DialogResult;
import ru.kpfu.itis.filesorter.exceptions.InputWindowClosedException;

import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ConsoleUserInteraction {
    private UserTerminal terminal;

    public ConsoleUserInteraction(UserTerminal terminal) {
        this.terminal = terminal;
    }

    public File getDirectory(String message) {
        File directory = null;
        while (directory == null || (directory != null && !directory.isDirectory())) {
            try {
                directory = terminal.getFile(message);
                if (!directory.isDirectory()) {
                    if (directory.getName().equals("CANCEL")) {
                        showConfirmDialog();
                    }
                    terminal.showErrorMessage("This file is not directory! Try again!");
                }
            } catch (InputWindowClosedException e) {
                showConfirmDialog();
            }
        }
        return directory;
    }

    public void callHelp() {
        DialogResult choice = terminal.showOptionDialog("Do you want to display a help for pattern?", "Help");

        if (choice == DialogResult.RESULT_YES) {
            terminal.showNotificationMessage("The pattern must satisfy the following conditions:\n" +
                    "* - sequence of several symbols\n" +
                    "? - one symbol\n" +
                    ". - file name and file delimiter");
        }
    }

    public Pattern getPattern(String message) {
        Pattern pattern = null;
        while (pattern == null) {
            try {
                String p = terminal.getRegex(message);
                if (p.equals("CANCEL")) {
                    showConfirmDialog();
                }
                p = makeBeautifulRegexp(p);
                pattern = Pattern.compile(p);
            } catch (InputWindowClosedException e) {
                showConfirmDialog();
            } catch (PatternSyntaxException e1) {
                terminal.showErrorMessage("Pattern is invalid!!! Please, try again!");
            }
        }
        return pattern;
    }

    private void showConfirmDialog() {
        DialogResult closeApp = terminal.showConfirmDialog("Are you sure you want to get out?", "Cancel");
        if (closeApp == DialogResult.RESULT_YES) {
          System.exit(0);
      }
    }

    public UserTerminal getTerminal() {
        return terminal;
    }

    public void setTerminal(UserTerminal terminal) {
        this.terminal = terminal;
    }

    private String makeBeautifulRegexp(String s) {
        s = s.replaceAll("\\{", "\\\\{");
        s = s.replaceAll("}", "\\\\}");
        s = s.replaceAll("\\[", "\\\\[");
        s = s.replaceAll("]", "\\\\]");
        s = s.replaceAll("\\^", "\\\\^");
        s = s.replaceAll("\\$", "\\\\$");
        s = s.replaceAll("\\+", "\\\\+");
        s = s.replaceAll("\\.", "\\\\.");

        s = s.replaceAll("\\*", ".*");
        s = s.replaceAll("\\?", ".");
        return s;
    }
}
