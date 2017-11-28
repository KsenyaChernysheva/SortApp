import javax.swing.*;
import java.io.File;

public class GraphicalUserTerminal implements UserTerminal{

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showNotificationMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
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
