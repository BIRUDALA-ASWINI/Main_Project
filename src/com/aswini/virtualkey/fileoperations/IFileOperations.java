package com.aswini.virtualkey.fileoperations;

import java.util.List;
import java.util.Scanner;

/**
 * it is an interface used to implement in the FileOperationsImpl.
 * @author user
 *
 */
public interface IFileOperations {
	/**
	 * 
	 * @param folderName it is a name of the folder which will create if not exists.
	 */
	public void createFolderIfFolderNotAvailable(String folderName);
	
	/**
	 * 
	 * @param path it is a directory of the folder where the files need to be stored.
	 */
	public void fileDisplay(String path);
	
	/**
	 * 
	 *@param path it is a directory of the folder where the files need to be stored.
	 * @param indent it is the count that we are giving.
	 * @param fileNamesList it is the List of file names that are available in the folder.
	 * @return this method returns the list containing file names as a string.
	 */
	public List<String> filesInDirectory(String path, int indent, List<String> fileNamesList);

	/**
	 * 
	 * @param fileToAdd it is a name of the file which will be created.
	 * @param sc it is a scanner variable which will read the name of the file.
	 */
	public void createNewFile(String fileToAdd, Scanner sc);
	
	/**
	 * 
	 * @param fileName it is the name of the file that are available in the folder.
	 * @param filePath it is the directory of the folder in which the files to be stored
	 * @return this method returns the fileListNames which contains file names.
	 */
	public List<String> fileLocations(String fileName, String filePath);
	
	/**
	 * @param filePath this is the directory of the folder where in which files are stored
	 * @param fName it is the name of the file which we need to search.
	 * @param fileNamesList it is the file name list from which we search the file.
	 */
	public void fileSearch(String filePath, String fName, List<String> fileNamesList);
	
	/**
	 * 
	 *@param filePath this is the file path from which we need to delete the file.
	 */
	public void fileDelete(String filePath);
}
