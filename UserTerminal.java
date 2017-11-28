import java.io.File;

public interface UserTerminal {
    void showErrorMessage(String message);

    void showNotificationMessage(String message);

    File getFile(String message) throws InputWindowClosedException;

    String getRegex(String title) throws InputWindowClosedException;
}
