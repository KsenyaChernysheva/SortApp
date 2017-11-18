import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

class CommandExe{
	private CommandExe(){
		//This class doesn't need an instance
	}
	public static exe(String command, String directory){
		try{
			ProcessBuilder builder = new ProcessBuilder( "/bin/bash", "-c", command);            
	        builder.directory(new File(directory));
	        File log = new File("log");
	        builder.redirectErrorStream(true);
	        builder.redirectOutput(Redirect.appendTo(log));
	        Process process = builder.start();

	        int exitValue = process.waitFor();
	        if (exitValue != 0) {
	        	System.out.println("Some think wrong , please take care about command or directory\nYou can chek 'log' File");
	        }
	    } catch (IOException e) {
	    	System.out.println("NO such directory");
        } catch (InterruptedException e) {
        	System.out.println(e);
        }
    }
}