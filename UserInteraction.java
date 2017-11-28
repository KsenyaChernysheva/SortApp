import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class UserInteraction {
    private UserTerminal terminal;

    public UserInteraction(UserTerminal terminal) {
        this.terminal = terminal;
    }

    public File getDirectory(String message) {
        File directory = null;
        while (directory == null || (directory != null && !directory.isDirectory())) {
            try {
                directory = terminal.getFile(message);
                if (!directory.isDirectory()) {
                    terminal.showErrorMessage("This file is not directory! Try again!");
                }
            } catch (InputWindowClosedException e) {
                terminal.showErrorMessage("Directory Not Chose!!! Buy!!!");
                System.exit(0);
            }
        }
        return directory;
    }

    public Pattern getPattern(String message) {
        Pattern pattern = null;
        while (pattern == null) {
            try {
                String p = terminal.getRegex(message);
                p = makeBeautifulRegexp(p);
                pattern = Pattern.compile(p);
            } catch (InputWindowClosedException e) {
                terminal.showErrorMessage("Pattern Not Chose!!! Buy!!!");
                System.exit(0);
            } catch (PatternSyntaxException e1) {
                terminal.showErrorMessage("Pattern is invalid!!! Please, try again!");
            }
        }
        return pattern;
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
