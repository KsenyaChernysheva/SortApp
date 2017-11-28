import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSorter {
    public int sortFiles(File from, File to, Pattern pattern){
        int sortedFilesCount = 0;
        File[] filesInDirectory = from.listFiles();
        if (filesInDirectory == null || filesInDirectory.length == 0){
            return 0;
        }
        for (File file : filesInDirectory) {
            Matcher matcher = pattern.matcher(file.getName());
            if (matcher.matches()){
                if(copyFile(file, to)){
                    sortedFilesCount++;
                }
            }
        }
        return sortedFilesCount;
    }

    private boolean copyFile(File from, File toDirectory){
        File destination = new File(toDirectory, from.getName());
        try {
            Files.copy(from.toPath(), destination.toPath());
            System.out.println(from + " copied");
            return true;
        } catch (IOException e) {
            System.err.println("can't copy " + from);
            return false;
        }
    }
}
