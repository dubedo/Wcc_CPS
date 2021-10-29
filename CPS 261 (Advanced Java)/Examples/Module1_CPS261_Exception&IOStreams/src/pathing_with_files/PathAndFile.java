package pathing_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFile {

	public static void main(String[] args) {

		// It's a Path created from Paths.
		Path sourceFile = Paths.get("C:\\Users\\idube\\Eclipse Workspace\\Module1_CPS261_Exception&IOStreams\\",
				"badBaseball.txt");
		Path targetFile = Paths.get("C:\\Users\\idube\\Eclipse Workspace\\Module1_CPS261_Exception&IOStreams\\",
				"copyOfBaseball");

		try {
			Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
