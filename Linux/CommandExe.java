//package ru.kpfu.itis.Sort;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

class CommandExe{
	static int i = 0;
	private CommandExe(){
		//This class doesn't need an instance
	}
	
	public static void exeCp(String file, String dir){
		try{
			ProcessBuilder builder = new ProcessBuilder( "bash", "-c", "cp " + dir + "/" + file + " " + dir + "/SortedFiles" + i);            
			builder.directory(new File("/bin"));
			File log = new File(dir + "/log.txt");
			builder.redirectErrorStream(true);
			builder.redirectOutput(Redirect.appendTo(log));
			Process process = builder.start();
			int exitValue = process.waitFor();
			System.out.println(exitValue);
		}catch (Exception e) {
			System.out.println(e);//TODO description
		}
	}

	public static void exeMkdir(String dir){
		while(true){
			try{
				ProcessBuilder builder = new ProcessBuilder( "bash", "-c", "mkdir " + dir + "/SortedFiles" + i);            
				builder.directory(new File("/bin"));
				File log = new File(dir + "/log.txt");
				builder.redirectErrorStream(true);
				builder.redirectOutput(Redirect.appendTo(log));
				Process process = builder.start();
				int exitValue = process.waitFor();
				System.out.println(exitValue);
				if (exitValue == 0) {
					break;
				}
				i++;
			}catch (Exception e) {
				System.out.println(e);//TODO description
				break;
			}
		}
	}
}