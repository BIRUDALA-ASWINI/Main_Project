package com.aswini.virtualkey.menu;

/**
 * this class will display the welcome screen in which it can display the application name, developer details, features of user interface.
 * @author user
 *
 */
public class Menu {

	/**
	 * 
	 * @param application it is the name of the application.
	 * @param developer it is the name of the developer.
	 */
	public static void printWelcomeScreen(String application, String developer) {
		String company = String.format("Welcome to"+application + "This application was developed by "+ developer);
		String appFeatures = "You can use this application to :-\n"
							+ " Access all files in the \"aswini\" folder\n"
							+ " Search, add, or delete files in \"aswini\" folder.\n"
							+ " Please enter correct filenames for searching or deleting files";
		System.out.println(company);

		System.out.println(appFeatures);
	}

	/**
	 * this method displays the features of the user interface.
	 */
	public static void menu() {
		String menu = " Select any option number from below and press Enter\n"
				+ "1) Access all files inside \"aswini\" folder\n" 
				+ "2) Display menu for File operations\n"
				+ "3) Exit program\n";
		System.out.println(menu);

	}

	/**
	 * this method displays the features of the user interface.
	 */
	public static void menuOptions() {
		String fileMenu = "\n Select any option number from below and press Enter \n"
				+ "1) Add new file to \"aswini\" folder\n"
				+ "2) Delete a file from \"aswini\" folder\n"
				+ "3) Search for a file from \"aswini\" folder\n" 
				+ "4) Show Previous Menu options \n" 
				+ "5) Exit program\n";

		System.out.println(fileMenu);
	}

}
