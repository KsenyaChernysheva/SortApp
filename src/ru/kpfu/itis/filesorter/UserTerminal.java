package ru.kpfu.itis.filesorter;

import ru.kpfu.itis.filesorter.constants.DialogResult;
import ru.kpfu.itis.filesorter.exceptions.InputWindowClosedException;

import java.io.File;

public interface UserTerminal {
    void showErrorMessage(String message);

    void showNotificationMessage(String message);

    DialogResult showConfirmDialog(String message, String title);

    DialogResult showOptionDialog(String message, String title);

    File getFile(String message) throws InputWindowClosedException;

    String getRegex(String title) throws InputWindowClosedException;
}
