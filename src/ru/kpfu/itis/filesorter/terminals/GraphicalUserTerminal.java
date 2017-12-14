package ru.kpfu.itis.filesorter.terminals;

import jdk.nashorn.internal.scripts.JO;
import ru.kpfu.itis.filesorter.constants.DialogResult;
import ru.kpfu.itis.filesorter.exceptions.InputWindowClosedException;
import ru.kpfu.itis.filesorter.UserTerminal;

import javax.swing.*;
import java.io.File;

public class GraphicalUserTerminal implements UserTerminal {

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showNotificationMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public DialogResult showConfirmDialog(String message, String title) {
        int closeApp = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        return getDialogResult(closeApp);
    }

    @Override
    public DialogResult showOptionDialog(String message, String title) {
        Object[] options = {"Help", "No"};
        int choice = JOptionPane.showOptionDialog(null, message, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, null);
        return getDialogResult(choice);
    }

    private DialogResult getDialogResult(int choice) {
        if (choice == JOptionPane.OK_OPTION){
            return DialogResult.RESULT_YES;
        } else if(choice == JOptionPane.CANCEL_OPTION){
            return DialogResult.CANCEL;
        } else {
            return DialogResult.RESULT_NO;
        }
    }


    @Override
    public File getFile(String message) throws InputWindowClosedException {
        File file = null;
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if (jFileChooser.showDialog(null, message) == JFileChooser.APPROVE_OPTION) {
            file = jFileChooser.getSelectedFile();
            return file;
        } else {
            throw new InputWindowClosedException();
        }
    }

    @Override
    public String getRegex(String title) throws InputWindowClosedException {
        String s = JOptionPane.showInputDialog(title);
        if (s == null){
            throw new InputWindowClosedException();
        } else {
            return s;
        }
    }

}
