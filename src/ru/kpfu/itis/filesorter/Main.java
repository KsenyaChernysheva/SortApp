package ru.kpfu.itis.filesorter;

import ru.kpfu.itis.filesorter.constants.DialogResult;
import ru.kpfu.itis.filesorter.terminals.ConsoleUserTerminal;
import ru.kpfu.itis.filesorter.terminals.GraphicalUserTerminal;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

       UserTerminal terminal = new ConsoleUserTerminal();
       ConsoleUserInteraction userInteraction = new ConsoleUserInteraction(terminal);

        DialogResult result = terminal.showOptionDialog("Start in graphical mode?", "SortApp");
        if (result == DialogResult.RESULT_YES){
            terminal = new GraphicalUserTerminal();
            userInteraction.setTerminal(terminal);
        }

     //  UserTerminal terminal = new GraphicalUserTerminal();
       //WindowUserInteraction userInteraction = new WindowUserInteraction(terminal);

        FileSorter fileSorter = new FileSorter();

        File directoryToSort = userInteraction.getDirectory("Choose file to sort");
        terminal.showNotificationMessage(directoryToSort + " chose");

        File directoryForSortedFiles = userInteraction.getDirectory("Choose directory for sorted files");
        terminal.showNotificationMessage(directoryForSortedFiles + " chose");

        userInteraction.callHelp();

        Pattern pattern = userInteraction.getPattern("Please, enter pattern for sorting");
        terminal.showNotificationMessage(pattern + " chose");
        
        terminal.showNotificationMessage("Sorting started");

        int sortedFilesCount = fileSorter.sortFiles(directoryToSort, directoryForSortedFiles, pattern);

        terminal.showNotificationMessage(sortedFilesCount + " files sorted");

        System.exit(0);
    }

}
