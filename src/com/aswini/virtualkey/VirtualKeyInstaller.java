package com.aswini.virtualkey;


import com.aswini.virtualkey.fileoperationsimpl.FileOperationsImpl;
import com.aswini.virtualkey.fileoptions.Options;
import com.aswini.virtualkey.menu.Menu;

/**
 * this class contains main method which is used to execute the project.
 * @author user
 *
 */
public class VirtualKeyInstaller {

	/**
	 * this method is used to implement the complete project.
	 * @param args supplies arguments as an array of String objects
	 */
	public static void main(String[] args) {
		
		// Create "main" folder if not present in current folder structure
		FileOperationsImpl fileOperationsImpl = new FileOperationsImpl();
		fileOperationsImpl.createFolderIfFolderNotAvailable("aswini");
		
		Menu.printWelcomeScreen(" Virtual key ", "Aswini");
		
		Options.welcomeInput();
	}

	
}
