import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;


public class SortingApp {
    public static void main(String[] args) {
        System.out.println(SortingApp.getTextAboutDirectoryExample(SortingApp.getOsName()));
        SortingApp.getFilesOfDirectory(args);
    }

    public static String getOsName() {
        return System.getProperty("os.name");
    }

    public static String getTextAboutDirectoryExample(String osName) {
        if ((new SortingApp()).getOsName().contains("Win")) {
            return "Please enter directory location. Example: C:\\Users\\Public\\ ...";
        }
        else {
        	if ((new SortingApp()).getOsName().contains("Lin")) {
            	return "Please enter directory location. Example: linux directory location /users/mark/...";
            }
            else {
            	if ((new SortingApp()).getOsName().contains("Mac")) {
           			return "Please enter directory location. Example: linux directory location /Users/username/...";
        		}
        		else {
        			return "Error. A wrong os name.";
        		}
        	}
        }
    }

    public static void getFilesOfDirectory(String[] string){]
    	Scanner scanDirectory = new Scanner(System.in);

    	File file = new File(scanDirectory.next());
    	File[] files = file.listFiles();

    	Arrays.sort(files);

    	for(int i = 0; i < files.length; i++){
    		System.out.print(files[i].getName() + "\n"); 
    	}

    	Arrays.sort(files);
    	System.out.println(Arrays.toString(files));
    }

}
