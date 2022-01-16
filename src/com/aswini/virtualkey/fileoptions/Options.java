package com.aswini.virtualkey.fileoptions;

import java.util.List;
import java.util.Scanner;

import com.aswini.virtualkey.fileoperationsimpl.FileOperationsImpl;
import com.aswini.virtualkey.menu.Menu;


/**
 * this class is used for choosing the operation that we want to excute.
 * @author user
 *
 */
public class Options {
	static FileOperationsImpl fileOperationsImpl = new FileOperationsImpl();
	/**
	 * this method is used to choose the option what we have to execute from welcome screen
	 */
	public static void welcomeInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				Menu.menu();
				int option = sc.nextInt();

				switch (option) {
				case 1:
					fileOperationsImpl.fileDisplay("aswini");
					break;
				case 2:
					Options.handleFileMenuOptions();
					break;
				case 3:
					System.out.println("Program Exited Successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above displayed options.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				welcomeInput();
			} 
		} while (running == true);
	}
	
	/**
	 * this method is used to choose the operation from the file operations.
	 */
	public static void handleFileMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				Menu.menuOptions();
				fileOperationsImpl.createFolderIfFolderNotAvailable("main");
				
				int option = sc.nextInt();
				switch (option) {
				case 1:
					// File Add
					System.out.println("Enter the name of the file to be added to the \"aswini\" folder");
					String fileToAdd = sc.next();
					
					fileOperationsImpl.createNewFile(fileToAdd, sc);
					
					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter the name of the file to be deleted from \"aswini\" folder");
					String fileToDelete = sc.next();
					
					fileOperationsImpl.createFolderIfFolderNotAvailable("aswini");
					List<String> filesToDelete = fileOperationsImpl.fileLocations(fileToDelete, "aswini");
					
					String deletionPrompt = "Select index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int index = sc.nextInt();
					
					if (index != 0) {
						fileOperationsImpl.fileDelete(filesToDelete.get(index - 1));
					} 
					else {
						for (String path : filesToDelete) {
							fileOperationsImpl.fileDelete(path);
						}
					}
					

					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter the name of the file to search from \"aswini\" folder");
					String fileName = sc.next();
					
					fileOperationsImpl.createFolderIfFolderNotAvailable("aswini");
					fileOperationsImpl.fileLocations(fileName, "aswini");

					
					break;
				case 4:
					// Go to Previous menu
					return;
				case 5:
					// Exit
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from the above displayed options..");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
	}
}
