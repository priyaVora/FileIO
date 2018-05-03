import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileIO_Test {
	String dir = "C:\\Users\\Priya/Desktop\\FolderName";

	// @Test
	// public void testIsDirectory() {
	// FileIO fileIO = new FileIO();
	// boolean exist =
	// fileIO.directoryExist("C:\\Users\\Priya\\Desktop\\MatrixShowWork");
	// assertTrue(exist);
	// }
	//
	//
	// @Test
	// public void deleteDirectoryWithFiles() {
	// FileIO fileIO = new FileIO();
	// fileIO.deleteDirectory("C:\\Users\\Priya/Desktop\\FolderName");
	// }
	//
	// @Test
	// public void deleteSpecificFileFromDirectory() {
	// FileIO fileIO = new FileIO();
	// fileIO.deleteSpecificFileFromDirectory("C:\\Users\\Priya/Desktop\\FolderName",
	// "Priya.txt");
	// }
	//
	//
	// @Test
	// public void deleteSimilarFilesFromDirectory() {
	// FileIO fileIO = new FileIO();
	// fileIO.deleteSimilarFilesFromDirectory(dir, "Priya");
	// }
	//
	// @Test
	// public void getSimilarListOfFiles() {
	// FileIO fileIO = new FileIO();
	// fileIO.getSimilarListOfFiles(dir, "Priya");
	// }
	//
	// @Test
	// public void createDirectoryAndFile() {
	// FileIO fileIO = new FileIO(System.getProperty("user.home") + "\\Desktop\\M",
	// "AccomplishedTask.txt");
	//
	// }
	//
	// @Test
	// public void createFileWithData() {
	// FileIO fileIO = new FileIO(System.getProperty("user.home") + "\\Desktop\\M",
	// "AccomplishedTask.txt");
	//
	// }

	// @Test
	// public void appendToFile() {
	// FileIO fileIO = new FileIO();
	// String data = "Append Successful!";
	// try {
	// fileIO.appendToFile(System.getProperty("user.home") +
	// "\\Desktop\\M\\textfile.txt", data);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }

	// @Test
	// public void overWriteToFile() {
	// FileIO fileIO = new FileIO();
	// String data = "Overwrite File Successful!";
	// try {
	// fileIO.overwriteToFile(System.getProperty("user.home") +
	// "\\Desktop\\M\\overwrite.txt", data);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }

	@Test
	public void deleteFile() {
		FileIO fileIO = new FileIO();
		fileIO.deleteDirectory(System.getProperty("user.home") + "\\Desktop\\M\\overwrite.txt");
	}

	@Test
	public void deleteDirectory() {
		FileIO fileIO = new FileIO();
		fileIO.deleteDirectory(System.getProperty("user.home") + "\\Desktop\\M");
	}
	@Test
	public void deleteDirectory2() {
		FileIO fileIO = new FileIO();
		fileIO.deleteDirectory(System.getProperty("user.home") + "\\Desktop\\FolderName");
	}

}
