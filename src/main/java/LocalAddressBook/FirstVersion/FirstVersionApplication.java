package LocalAddressBook.FirstVersion;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class FirstVersionApplication {
	private static final Logger logger = LoggerFactory.getLogger(FirstVersionApplication.class);
	public static List pathList;

	public static void main(String[] args) {
		SpringApplication.run(FirstVersionApplication.class, args);

		// get args
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		pathList = appArgs.getOptionValues("dataDir");
		if (pathList == null) {
			System.out.println("Please specify a directory with --dataDir=<directory path> option!");
			System.exit(1);
		}
		/*
		String pathStr = (String) pathList.get(0);
		logger.info("Path is : " + pathStr);
		Path path = Paths.get(pathStr);

		if (!Files.isDirectory(path)) {
			new File(pathStr).mkdirs();
			logger.info("Path does not exist, created " + pathStr);
		} else {
			logger.info("Path " + pathStr + " exists!");
		}
		*/

	}

}
