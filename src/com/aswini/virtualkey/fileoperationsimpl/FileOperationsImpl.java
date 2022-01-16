package com.aswini.virtualkey.fileoperationsimpl;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.aswini.virtualkey.fileoperations.IFileOperations;

/**
 * This class is used to do operations like crating a folder, displaying files, displaying file locations, creating, searching and deleting the files from a directory.
 * @author user
 *
 */
public class FileOperationsImpl implements IFileOperations{
	static FileOperationsImpl fileOperationsImpl = new FileOperationsImpl();
	/**
	 * This method creates a folder in the directory of the goven name if not exists.
	 * 
	 * @param folderName it is a name of the folder which will create if not exists.
	 */
	public void createFolderIfFolderNotAvailable(String folderName) {
		File file = new File(folderName);

		
		if (!file.exists()) {
			file.mkdirs(); 
		}
	}
	
	/**
	 * This method will displays the files in the given directory
	 * 
	 * @param path it is a directory of the folder where the files need to be stored.
	 */

	public void fileDisplay(String path) {
		fileOperationsImpl.createFolderIfFolderNotAvailable("aswini");
	
		System.out.println("Files are Displying in Asscending order with directory\n");

		
		List<String> fileNamesList = fileOperationsImpl.filesInDirectory(path, 0, new ArrayList<String>());

		System.out.println("Displaying  files in ascending order\n");
		Collections.sort(fileNamesList);
		for(String file : fileNamesList) {
			System.out.println(file);
		}
	}

	/**
	 * this method is used to return the list of files that are available in thr folder
	 * 
	 * @param path it is a directory of the folder where the files need to be stored.
	 * @param indent it is the count that we are giving.
	 * @param fileNamesList it is the List of file names that are available in the folder.
	 * @return this method returns the list containing file names as a string.
	 */
	public List<String> filesInDirectory(String path, int indent, List<String> fileNamesList) {
		File directory = new File(path);
		File[] filesArray = directory.listFiles();
		List<File> filesList = Arrays.asList(filesArray);

		Collections.sort(filesList);

		if (filesArray != null && filesArray.length > 0) {
			for (File file : filesList) {

				System.out.print(" ".repeat(indent * 2));

				if (file.isDirectory()) {
					System.out.println("    " + file.getName());

					// Recursively indent and display the files
					fileNamesList.add(file.getName());
					filesInDirectory(file.getAbsolutePath(), indent + 1, fileNamesList);
				} else {
					System.out.println("    " + file.getName());
					fileNamesList.add(file.getName());
				}
			}
		} else {
			System.out.print(" ".repeat(indent * 2));
			System.out.println("    Empty Directory");
		}
		System.out.println();
		return fileNamesList;
	}

	/**
	 * this method is used to create a new file in the folder.
	 * 
	 * @param fileToAdd it is a name of the file which will be created.
	 * @param sc it is a scanner variable which will read the name of the file.
	 */
	public void createNewFile(String fileToAdd, Scanner sc) {
		fileOperationsImpl.createFolderIfFolderNotAvailable("aswini");
		Path pathToFile = Paths.get("./aswini/" + fileToAdd);
		try {
			Files.createDirectories(pathToFile.getParent());
			Files.createFile(pathToFile);
			System.out.println(fileToAdd + " File created successfully");

			System.out.println("Do you want to add some content to the file? (yes/no)");
			String choice = sc.next().toLowerCase();

			sc.nextLine();
			if (choice.equals("yes")) {
				System.out.println("\n Input content added succesfully and press enter ");
				String content = sc.nextLine();
				Files.write(pathToFile, content.getBytes());
				System.out.println(" Content added to file " + fileToAdd);
				System.out.println("Content can be read using by using any editor");
			}

		} catch (IOException e) {
			System.out.println("Failed to create new file " + fileToAdd);
			System.out.println(e.getClass().getName());
		}
	}

	/**
	 * this method returns the fileListNames which contains file names.
	 * 
	 * @param fileName it is the name of the file that are available in the folder.
	 * @param filePath it is the directory of the folder in which the files to be stored
	 * @return this method returns the fileListNames which contains file names.
	 */
	public List<String> fileLocations(String fileName, String filePath) {
		List<String> fileListNames = new ArrayList<>();
		fileOperationsImpl.fileSearch(filePath, fileName, fileListNames);

		if (fileListNames.isEmpty()) {
			System.out.println(" Couldn't find any file with given file name " + fileName + "\n");
		} else {
			System.out.println("Found file at below location(s):");

			List<String> filesList = IntStream.range(0, fileListNames.size())
					.mapToObj(index -> (index + 1) + ": " + fileListNames.get(index)).collect(Collectors.toList());

			for(String file : filesList) {
				System.out.println(file);
			}
			
		}

		return fileListNames;
	}

	/**
	 * 
	 * @param filePath this is the directory of the folder where in which files are stored
	 * @param fName it is the name of the file which we need to search.
	 * @param fileNamesList it is the file name list from which we search the file.
	 */
	public void fileSearch(String filePath, String fName, List<String> fileNamesList) {
		File dir = new File(filePath);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);

		if (files != null && files.length > 0) {
			for (File file : filesList) {

				if (file.getName().startsWith(fName)) {
					fileNamesList.add(file.getAbsolutePath());
				}

				if (file.isDirectory()) {
					fileSearch(file.getAbsolutePath(), fName, fileNamesList);
				}
			}
		}
	}

	/**
	 * this method is used to delete the file.
	 * 
	 * @param filePath this is the file path from which we need to delete the file.
	 */
	public void fileDelete(String filePath) {

		File currentFile = new File(filePath);
		File[] files = currentFile.listFiles();

		if (files != null && files.length > 0) {
			for (File file : files) {

				String fileName = file.getName() + " at " + file.getParent();
				if (file.isDirectory()) {
					fileDelete(file.getAbsolutePath());
				}

				if (file.delete()) {
					System.out.println(fileName + " deleted successfully");
				} else {
					System.out.println("Failed to delete the file " + fileName);
				}
			}
		}

		String currentFileName = currentFile.getName() + " at " + currentFile.getParent();
		if (currentFile.delete()) {
			System.out.println(currentFileName + " deleted successfully");
		} else {
			System.out.println("Failed to delete the file " + currentFileName);
		}
	}
}
