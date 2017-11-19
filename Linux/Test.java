package ru.kpfu.itis.Sort;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.kpfu.itis.Sort.CommandExe;
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
        check(shedule, files, dir);
    }

    public static void check(String shedule, String[] files, String dir){
        int count = 0;
        if (shedule.charAt(0) == '.') {
            shedule = ".+\\" + shedule;
        }else{
            shedule = shedule + "+.";
        }
        for (int i = 0; i < files.length - 1; i++) {
            Pattern p = Pattern.compile(shedule);
            Matcher m = p.matcher(files[i]);
            System.out.println(shedule);
            if (m.matches()) {
                CommandExe.exeCp(files[i], dir);
                count++;        
            }
        }
        JOptionPane.showMessageDialog(null, "All is done, amount of sorted files = " + count, "Service", JOptionPane.PLAIN_MESSAGE);
    }
}
