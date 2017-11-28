import java.io.File;
import java.util.regex.Pattern;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        UserTerminal terminal = new GraphicalUserTerminal();
        FileSorter fileSorter = new FileSorter();
        UserInteraction userInteraction = new UserInteraction(terminal);

        File directoryToSort = userInteraction.getDirectory("Choose file to sort");
        System.out.println(directoryToSort + " chose");

        File directoryForSortedFiles = userInteraction.getDirectory("Choose directory for sorted files");
        System.out.println(directoryForSortedFiles + " chose");

        Pattern pattern = userInteraction.getPattern("Please, enter pattern for sorting");
        System.out.println(pattern + " chose");



        int sortedFilesCount = fileSorter.sortFiles(directoryToSort, directoryForSortedFiles, pattern);
        terminal.showNotificationMessage(sortedFilesCount + " files sorted");

        System.exit(0);
    }

}
