
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class FileIO {

	public FileIO() {

	}

	public FileIO(String dir, String filename) {
		createFile(dir, "", "", filename);
	}

	public boolean directoryExist(String path) {
		File dir = new File(path);
		boolean exists = dir.exists();
		return exists;
	}

	public void deleteDirectory(String dirPath) {
		deleteAllFilesFromDirectory(dirPath);
		File index = new File(dirPath);
		if (!index.exists()) {
			index.mkdir();
		} else {
			index.delete();
			if (!index.exists()) {
				index.mkdir();
			}
		}
	}

	private void createDirectory(String dirPath, String folderLocation, String folderName, String filename,
			String data) {
		String PATH = "";
		String directoryName = PATH.concat(dirPath) + folderLocation + folderName;
		String fileName = "";
		if (!directoryName.contains(".txt")) {
			fileName = filename;
		} else {
			fileName = filename + ".txt";
		}
		File directory = new File(directoryName);
		if (!directory.exists()) {
			directory.mkdir();
		}

		File file = new File(directoryName + "/" + fileName);
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public void createFile_WithData(String dirPath, String folderLocation, String folderName, String filename,
			String data) {
		createDirectory(dirPath, folderLocation, folderName, filename, data);

	}

	public void createFile(String dirPath, String folderLocation, String folderName, String filename) {
		createDirectory(dirPath, folderLocation, folderName, filename, "");

	}

	public void deleteFile(String path) {
		File f = new File(path);
		f.delete();
	}

	public void deleteAllFilesFromDirectory(String path) {
		File f = new File(path);

		for (File eachFile : f.listFiles()) {
			eachFile.delete();
		}

	}

	public void deleteSpecificFileFromDirectory(String path, final String filename) {
		final File f = new File(path);

		f.list(new FilenameFilter() {

			public boolean accept(File dir, String name) {

				if (name.equals(filename)) {

					String deleteFile = f.getAbsolutePath() + "\\" + filename;

					File file = new File(deleteFile);
					file.delete();
				}
				return false;
			}
		});
	}

	public void deleteSimilarFilesFromDirectory(String path, final String keyword) {
		final File f = new File(path);

		f.list(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				if (name.contains(keyword)) {

					String deleteFile = f.getAbsolutePath() + "\\" + name;
					File file = new File(deleteFile);
					file.delete();
				}
				return false;
			}
		});
	}

	public ArrayList<File> getSimilarListOfFiles(String path, final String keyword) {
		final ArrayList<File> listOfFiles = new ArrayList<File>();
		final File f = new File(path);

		f.list(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				System.out.println("Dir Exist: " + dir.isDirectory());
				System.out.println(" Dir: " + dir);
				System.out.println(" Name: " + name);
				System.out.println("-----------------");
				if (name.contains(keyword)) {

					System.out.println("File Name: " + name);
					listOfFiles.add(new File(f.getAbsolutePath() + "\\" + name));
				}
				System.out.println("-----------------");
				return false;

			}
		});
		return listOfFiles;
	}

	public void appendToFile(String path, String data) throws IOException {

		FileWriter fw = null;
		try {
			fw = new FileWriter(path, true);

			fw.write(data);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			;
			close(fw);
		}

	}

	public void appendToFileByLine(String path, String data) throws IOException {

		FileWriter fw = null;
		try {
			fw = new FileWriter(path, true);

			fw.write(data);
			fw.write("\r\n");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			;
			close(fw);
		}

	}

	public void overwriteToFile(String path, String data) throws IOException {
		File fileDir = new File(path);

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), "UTF8"));
		out.write(data);
		out.flush();
		out.close();

	}

	public void grabsContentFromFile(String sourceFilePath, String destinationFilePath) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(sourceFilePath);
			fw = new FileWriter(destinationFilePath);
			int c = fr.read();
			while (c != -1) {
				fw.write(c);
				c = fr.read();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(fr);
			close(fw);
		}
	}

	public void grabsContentFromFileAppend(String sourceFilePath, String destinationFilePath) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(sourceFilePath);
			fw = new FileWriter(destinationFilePath, true);
			int c = fr.read();
			fw.write("\r\n");
			while (c != -1) {
				fw.write(c);
				// appendToFile(destinationFilePath, c + "");
				c = fr.read();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(fr);
			close(fw);
		}
	}

	private static void close(Closeable stream) {
		try {
			if (stream != null) {
				stream.close();
			}
		} catch (IOException e) {
			// ...
		}
	}

}
