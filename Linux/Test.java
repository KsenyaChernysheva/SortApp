//package ru.kpfu.itis.Sort;
//import ru.kpfu.itis.Sort.CommandExe;
import java.io.File;
import javax.swing.JOptionPane;
//import java.util.ArrayList;
import java.util.Scanner;
                
public class Test{
    public static void main(String[] args){
        String dir = JOptionPane.showInputDialog("Input the directory, which needs to sort");
        File file = new File(dir);
        String[] files = file.list();
        //----------------------------------------------
        JOptionPane.showMessageDialog(null, "Don't worry, YOU just need to input shedule for sorting", "Service", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "This character - '*', means all\nThis character - '?', means only one symbol",
                                    "Service", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "An example '*.JPG' means all files, which have 'JPG' extension\n'?.JPG' means all files , which have 'JPG' extension and 1 symbol in name",
                                    "Service", JOptionPane.PLAIN_MESSAGE);
        //----------------------------------------------
        String shedule = JOptionPane.showInputDialog("Input shedule for sorting");
        CommandExe.exeMkdir(dir);
        //check(shedule, files, dir);
    }

    public static void check(String shedule, String[] files, String dir){
        for (int i = 0, count = 0; i < files.length - 1; i++) {
            String[] temp = files[i].split(".");
            System.out.println(temp.length);
            temp[1] = "." + temp[1];
            if (temp[0] == shedule || temp[1] == shedule) {
                CommandExe.exeCp(files[i], dir);
                count++;
            }
            JOptionPane.showMessageDialog(null, "All is done, amount of sorted files = " + count, "Service", JOptionPane.PLAIN_MESSAGE);
        }

    }
}
